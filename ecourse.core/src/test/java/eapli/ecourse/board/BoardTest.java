package eapli.ecourse.board;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.domain.BoardBuilder;
import eapli.ecourse.boardManagement.domain.Column;
import eapli.ecourse.boardManagement.domain.State;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.postit.domain.Content;
import eapli.ecourse.postit.domain.ContentType;
import eapli.ecourse.postit.domain.PostIt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class BoardTest {
    private static final int MAX_COLUMNS=10;
    private static final int MAX_ROWS=20;

    private static final String title1="Title1";
    private static final String title2="Title2";

    private static final List<Column>columns=new ArrayList<>(MAX_COLUMNS);
    private static final List<Column>rows=new ArrayList<>(MAX_ROWS);
    private static final State state1=State.ACTIVE;
    private static final State state2=State.ARCHIVED;
    private static ECourseUser eUser1;
    private static ECourseUser eUser2;

    private Board board;


    @Before
    public void setUp(){
        eUser1=mock(ECourseUser.class);
        eUser2=mock(ECourseUser.class);
        // Initialize a new Board object for each test
        BoardBuilder bb = new BoardBuilder().withTitle("Board1").withState(State.ACTIVE).withOwner(eUser1).withMaxColumns(10).withMaxRows(20);
        buildBoardColumnsRowsNames(bb);
        board = bb.build();
    }
    @Test
    public void ensureCreateValidBoard(){
        Board board=new Board(title1,state1,eUser1);
        Assert.assertNotNull(board);
    }
    @Test
    public void ensureBoardIsNotCreatedWithInvalidTitle(){
        Assert.assertThrows(IllegalArgumentException.class,()->new Board(null,state1,eUser1));
    }
    @Test
    public void ensureBoardIsNotCreatedWithInvalidState(){
        Assert.assertThrows(IllegalArgumentException.class,()->new Board(title2,null,eUser2));
    }
    @Test
    public void ensureBoardIsNotCreatedWithInvalidECourse(){
        Assert.assertThrows(IllegalArgumentException.class,()->new Board(title1,state1,null));
    }
    @Test
    public void ensureBoardEquals(){
        Board b1=new Board(title1,state1,eUser1);
        Board b2=new Board(title2,state2,eUser2);
        Assert.assertFalse(b1.equals(b2));
        Assert.assertTrue(b1.equals(b1));
    }
    @Test
    public void sameBoard(){
        Board board1=new Board(title1,state1,eUser1);
        Board board2=new Board(title1,state1,eUser1);
        Board board3=new Board(title2,state2,eUser2);
        Assert.assertTrue(board1.sameAs(board2));
    }

    @Test
   public void ensureBoardIsNotFree() {
        BoardBuilder boardBuilder = new BoardBuilder().withTitle("Board2").withState(State.ACTIVE).withOwner(eUser1).withMaxColumns(10).withMaxRows(20);;
        buildBoardColumnsRowsNames(boardBuilder);
        Board board = boardBuilder.build();
        board.addPostIt(new PostIt(new Content(ContentType.TEXT,"Teste".getBytes()), eUser1), 1, 1);
        Assert.assertFalse(board.isFree(1,1));
   }

    @Test
    public void ensureBoardIsFree() {
        BoardBuilder boardBuilder = new BoardBuilder().withTitle("Board2").withState(State.ACTIVE).withOwner(eUser1).withMaxColumns(10).withMaxRows(20);;
        buildBoardColumnsRowsNames(boardBuilder);
        Board board = boardBuilder.build();
        Assert.assertTrue(board.isFree(1,1));
    }

    @Test
    public void ensureAddFailWithInvalidRow(){
        BoardBuilder boardBuilder = new BoardBuilder().withTitle("Board2").withState(State.ACTIVE).withOwner(eUser1).withMaxColumns(10).withMaxRows(20);;
        buildBoardColumnsRowsNames(boardBuilder);
        Board board = boardBuilder.build();
        Assert.assertThrows(IllegalArgumentException.class,()->board.addPostIt(new PostIt(new Content(ContentType.TEXT,"Teste".getBytes()), eUser1), 21, 2));
    }

    @Test
    public void ensureAddFailWithInvalidColumn(){
        BoardBuilder boardBuilder = new BoardBuilder().withTitle("Board2").withState(State.ACTIVE).withOwner(eUser1).withMaxColumns(10).withMaxRows(20);;
        buildBoardColumnsRowsNames(boardBuilder);
        Board board = boardBuilder.build();
        Assert.assertThrows(IllegalArgumentException.class,()->board.addPostIt(new PostIt(new Content(ContentType.TEXT,"Teste".getBytes()), eUser1), 2, 21));
    }

    @Test
    public void ensureAddFailWithNegativeRow(){
        BoardBuilder boardBuilder = new BoardBuilder().withTitle("Board2").withState(State.ACTIVE).withOwner(eUser1).withMaxColumns(10).withMaxRows(20);;
        buildBoardColumnsRowsNames(boardBuilder);
        Board board = boardBuilder.build();
        Assert.assertThrows(IllegalArgumentException.class,()->board.addPostIt(new PostIt(new Content(ContentType.TEXT,"Teste".getBytes()), eUser1), -2, 2));
    }

    @Test
    public void ensureAddFailWithNegativeColumn(){
        BoardBuilder boardBuilder = new BoardBuilder().withTitle("Board2").withState(State.ACTIVE).withOwner(eUser1).withMaxColumns(10).withMaxRows(20);;
        buildBoardColumnsRowsNames(boardBuilder);
        Board board = boardBuilder.build();
        Assert.assertThrows(IllegalArgumentException.class,()->board.addPostIt(new PostIt(new Content(ContentType.TEXT,"Teste".getBytes()), eUser1), 2, -2));
    }

    private void buildBoardColumnsRowsNames(BoardBuilder bBuilder) {
        for (int i = 0; i < 10; i++) {
            bBuilder.withColumn(i, "Column" + i);
        }
        for (int i = 0; i < 20; i++) {
            bBuilder.withRow(i, "Row" + i);
        }
    }

    @Test
    public void testRemovePostIt() {
        // Add a post-it to the board
        PostIt postIt = mock(PostIt.class);
        board.addPostIt(postIt, 1, 1);

        // Remove the post-it
        PostIt removedPostIt = board.removePostIt(1, 1);

        // Ensure that the removed post-it is the same as the one added
        Assert.assertEquals(postIt, removedPostIt);
    }

    @Test
    public void testAddPostIt() {
        // Add a post-it to the board
        PostIt postIt = mock(PostIt.class);

        // Add the post-it to the board
        board.addPostIt(postIt, 1, 1);

        // Retrieve the post-it from the board
        PostIt retrievedPostIt = board.getPostIt(1, 1);

        // Ensure that the retrieved post-it is the same as the one added
        Assert.assertEquals(postIt, retrievedPostIt);
    }

    @Test
    public void testGetPostIt() {
        // Add a post-it to the board
        PostIt postIt = mock(PostIt.class);

        // Add the post-it to the board
        board.addPostIt(postIt, 1, 1);

        // Retrieve the post-it from the board
        PostIt retrievedPostIt = board.getPostIt(1, 1);

        // Ensure that the retrieved post-it is the same as the one added
        Assert.assertEquals(postIt, retrievedPostIt);
    }

    @Test
    public void testIsFree() {
        // Add a post-it to the board
        PostIt postIt = mock(PostIt.class);

        // Initially, the position (1, 1) should be free
        Assert.assertTrue(board.isFree(1, 1));

        // Add a post-it to the position (1, 1)
        board.addPostIt(postIt, 1, 1);

        // Now, the position (1, 1) should not be free
        Assert.assertFalse(board.isFree(1, 1));
    }
}
