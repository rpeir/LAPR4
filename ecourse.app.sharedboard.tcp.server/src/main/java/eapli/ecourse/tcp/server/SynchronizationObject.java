package eapli.ecourse.tcp.server;

import org.antlr.v4.runtime.misc.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class used to synchronize the access to the shared board
 * This class is a singleton, so it can be accessed by any thread
 */
public class SynchronizationObject {

    /**
     * Singleton instance
     */
    private static SynchronizationObject instance;

    /**
     * Map that stores the number of threads that are writing to a board
     */
    private Map<String, Integer> writeBoardCounter;

    /**
     * Map to lock the post-its
     * The key is the board title
     * The value is a map of pairs that represent the post-it coordinates (row, column)
     * The value of the inner map is an object that represents the lock
     */
    private Map<String, Map<Pair<Integer, Integer>, Object>> postItLock;

    /**
     * Map to lock the boards
     * The key is the board title
     * The value is an object that represents the lock
     */
    private Map<String, Object> boardLock;

    /**
     * Map that stores the number of threads that are writing to a post-it
     * The key is the board title
     * The value is a map that stores the number of threads that are writing to a post-it
     * The key of the inner map is a pair that represents the post-it coordinates (row, column)
     */
    private Map<String, Map<Pair<Integer, Integer>, Integer>> writePostitCounter;

    public SynchronizationObject() {
        writeBoardCounter = new HashMap<>();
        writePostitCounter = new HashMap<>();
        postItLock = new HashMap<>();
        boardLock = new HashMap<>();
    }

    /**
     * Method used to get the singleton instance
     * @return the singleton instance
     */
    public static SynchronizationObject getInstance() {
        if (instance == null)
            instance = new SynchronizationObject();
        return instance;
    }

    /**
     * Method used to get the lock of a post-it
     * @param boardTitle board title
     * @param row row of the post-it
     * @param column column of the post-it
     * @return the lock of the post-it
     */
    private synchronized Object getPostItLock(String boardTitle, String row, String column) {
        Pair<Integer, Integer> slot = new Pair<>(Integer.parseInt(row), Integer.parseInt(column));
        return postItLock.get(boardTitle).get(slot);
    }

    /**
     * Method used to get the lock of a board
     * @param boardTitle board title
     * @return the lock of the board
     */
    private synchronized Object getBoardLock(String boardTitle) {
        return boardLock.get(boardTitle);
    }

    /**
     * Method used to get the number of threads that are writing to a board
     * @param boardTitle board title
     * @return the number of threads that are writing to a board
     */
    private synchronized int getWriteBoardCounter(String boardTitle) {
        if (!writeBoardCounter.containsKey(boardTitle))
            return 0;
        return writeBoardCounter.get(boardTitle);
    }

    /**
     * Method used to get the number of threads that are writing to a post-it
     * @param boardTitle board title
     * @param row row of the post-it
     * @param column column of the post-it
     * @return the number of threads that are writing to a post-it
     */
    private synchronized int getWritePostitCounter(String boardTitle, String row, String column) {
        Pair<Integer, Integer> slot = new Pair<>(Integer.parseInt(row), Integer.parseInt(column));
        if (!writePostitCounter.get(boardTitle).containsKey(slot))
            return 0;
        return writePostitCounter.get(boardTitle).get(slot);
    }

    /**
     * Method that Increments Counter of writters and create locks if necessary (post-it and board)
     * @param boardTitle board title
     * @param row row of the post-it
     * @param column column of the post-it
     */
    private synchronized void informTryWrite(String boardTitle, String row, String column) {
        Pair<Integer, Integer> slot = new Pair<>(Integer.parseInt(row), Integer.parseInt(column));

        // if contains the lock of the board
        if (writePostitCounter.containsKey(boardTitle)) {
            // if contains the lock of the post-it
            if (writePostitCounter.get(boardTitle).containsKey(slot)) {
                // increment the counter of the post-it
                int value = writePostitCounter.get(boardTitle).get(slot);
                writePostitCounter.get(boardTitle).put(slot, value + 1);
            } else {
                // add the counter of the post-it and initialize it with 1
                writePostitCounter.get(boardTitle).put(slot, 1);
            }
        } else {
            // add the counter of the post-it
            Map<Pair<Integer, Integer>, Integer> aux = new HashMap<>();
            aux.put(slot, 1);
            writePostitCounter.put(boardTitle, aux);
        }
        ////////////////////////////////////////

        // if contains the counter of the board
        if (writeBoardCounter.containsKey(boardTitle)) {
            // increment the counter of the board
            int value = writeBoardCounter.get(boardTitle);
            writeBoardCounter.put(boardTitle, value + 1);
        } else {
            // add the counter of the board and initialize it with 1
            writeBoardCounter.put(boardTitle, 1);
        }
        ////////////////////////////////////////

        // if contains the lock of the post-it
        if (postItLock.containsKey(boardTitle)) {
            // if not contains the lock of the post-it, create it
            if (!postItLock.get(boardTitle).containsKey(slot)) {
                postItLock.get(boardTitle).put(slot, new Object());
            }
        } else {
            // add the lock of the post-it
            HashMap<Pair<Integer, Integer>, Object> aux = new HashMap<>();
            aux.put(slot, new Object());
            postItLock.put(boardTitle, aux);
        }
        ///////////////////////////////////////////
        // if not contains the lock of the board, create it
        if (!boardLock.containsKey(boardTitle)) {
            boardLock.put(boardTitle, new Object());
        }
    }

    /**
     * Method used to add a board lock if it doesn't exist
     * @param boardTitle board title
     */
    private synchronized void informTryRead(String boardTitle) {
        if (!boardLock.containsKey(boardTitle)) {
            boardLock.put(boardTitle, new Object());
        }
    }

    /**
     * Method used to decrement the counter of writers in the post-it position
     * @param boardTitle board title
     * @param row row of the post-it
     * @param column column of the post-it
     */
    private synchronized void informDoneWriting(String boardTitle, String row, String column) {
        Pair<Integer, Integer> slot = new Pair<>(Integer.parseInt(row), Integer.parseInt(column));

        // gets the current number of writters in the post-it position
        int value = writePostitCounter.get(boardTitle).get(slot);
        // decrements the number of writters in the post-it position
        writePostitCounter.get(boardTitle).put(slot, value - 1);

        ////////////////////////////////////////

        // gets the current number of writters in the board
        int value2 = writeBoardCounter.get(boardTitle);
        // decrements the number of writters in the board
        writeBoardCounter.put(boardTitle, value2 - 1);
    }

    /**
     * Method used by readers to check if they can read the board, if not they wait
     * @param boardTitle board title
     */
    public void startReading(String boardTitle) {
        // create lock if it doesn't exist
        informTryRead(boardTitle);

        // acquire lock of the board and waits for the writters to finish
        synchronized (getBoardLock(boardTitle)) {
            while (getWriteBoardCounter(boardTitle) > 0) {
                try {
                    getBoardLock(boardTitle).wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method used to inform that a writer thread has starting reading a post-it
     * @param boardTitle board title
     * @param row row of the post-it
     * @param column column of the post-it
     */
    public void startWriting(String boardTitle, String row, String column) {
        //increment counters
        informTryWrite(boardTitle, row, column);

        //acquire lock of the post-it waits to another writter to finish
        synchronized (getPostItLock(boardTitle, row, column)) {
            if (getWritePostitCounter(boardTitle, row, column) > 1) { // wait for another writter to finish, if any
                try {
                    getPostItLock(boardTitle, row, column).wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method used to inform that a writer thread has finished writing in a post-it
     * @param boardTitle Board title
     * @param row row of the post-it
     * @param column column of the post-it
     */
    public void finishingWriting(String boardTitle, String row, String column) {
        informDoneWriting(boardTitle, row, column); // decrement writter counter

        // aquire lock and notify readers
        synchronized (getBoardLock(boardTitle)) {
            getBoardLock(boardTitle).notifyAll();
        }

        // aquire lock and notify writers to the same post-it
        synchronized (getPostItLock(boardTitle, row, column)) {
            getPostItLock(boardTitle, row, column).notify();
        }
    }
}

