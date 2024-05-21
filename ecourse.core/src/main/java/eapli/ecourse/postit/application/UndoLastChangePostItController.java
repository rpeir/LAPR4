package eapli.ecourse.postit.application;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.boardUpdate.repositories.UpdateRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.sharedBoardManagement.application.ShareBoardService;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Domain Controller of Undo Last Change Post-It use case
 */
public class UndoLastChangePostItController {

    private final BoardSharedRepository boardShared;

    private final BoardRepository boards;

    private final UpdateRepository updates;

    public UndoLastChangePostItController() {
        this.boardShared = PersistenceContext.repositories().boardShared();
        this.boards = PersistenceContext.repositories().boards();
        this.updates = PersistenceContext.repositories().updates();
    }

    public UndoLastChangePostItController(BoardSharedRepository boardShared, BoardRepository boards, UpdateRepository updates) {
        this.boardShared = boardShared;
        this.boards = boards;
        this.updates = updates;
    }

    /**
     * List the boards available to the user
     * @param emailAddress email of the user
     * @return list of boards available to the user
     */
    public List<Board> listAvailableBoards(EmailAddress emailAddress) {
        List<Board> boards = (List<Board>) new ShareBoardService(boardShared).userBoardsWithWritePermission(emailAddress);
        if (boards.isEmpty()) throw new IllegalArgumentException("No boards available");
        return boards;
    }

    /**
     * Undo the last change made to a postit
     * @param userEmail email of the user that wants to undo the last change
     * @param boardTitle title of the board where the postit is
     * @param row row of the postit
     * @param column column of the postit
     * @throws IllegalStateException if there are no updates for the postit, or if other error occurs
     * @throws IllegalArgumentException if the postit is not of the user, or it is not possible to undo the last change
     */
    public void undoLastChangePostIt(EmailAddress userEmail, String boardTitle, int row, int column) {
        Board board = boards.findByTitle(boardTitle).orElseThrow();
        new UndoLastChangePostItService(updates, boards).undoLastChangePostIt(board, row, column, userEmail);
    }
}
