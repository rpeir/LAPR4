package eapli.ecourse.update;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.domain.State;
import eapli.ecourse.boardUpdate.domain.*;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.postit.domain.Content;
import eapli.ecourse.postit.domain.PostIt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

public class UpdateTest {

    private static Board board1;
    private static PostIt postIt1;
    private static Content content1;
    private static ECourseUser eUser1;
    private static BoardChange boardChange1;

    @Before
    public void setUp(){
        postIt1=mock(PostIt.class);
        boardChange1=mock(BoardChange.class);
        content1=mock(Content.class);
        eUser1 = mock(ECourseUser.class);
        board1=new Board("title1", State.ARCHIVED,eUser1);

    }

    /*
    @Test
    public void ensureUpdateIsNotCreatedWithInvalidType(){
        Assert.assertThrows(IllegalArgumentException.class,()->new CellUpdate(postIt1,content1,null,eUser1));
        Assert.assertThrows(IllegalArgumentException.class,()->new BoardUpdate(boardChange1,null,eUser1));
    }
     */

    @Test
    public void ensureUpdateIsNotAssociatedWithArchivedBoard(){
        BoardUpdate testBoardUpdate = new BoardUpdate(boardChange1,BoardUpdateType.CREATE,eUser1);
        Assert.assertFalse(testBoardUpdate.associateBoard(board1));
    }
    /*
    @Test
    public void ensureUpdateIsCreatedWithDifferentTimeStamps(){
        CellUpdate cellUpdate1=new CellUpdate(postIt1,content1,CellUpdateType.INSERT,eUser1);
        CellUpdate cellUpdate2=new CellUpdate(postIt1,content1,CellUpdateType.INSERT,eUser1);
        cellUpdate1.associateBoard(board1);
        cellUpdate2.associateBoard(board1);
        updateRepo.save(cellUpdate1);
        updateRepo.save(cellUpdate2);
        boardRepo.save(board1);
        Iterable<Board> boards = boardRepo.findByOwner(systemUser1.email());
        List<Board> resultBoard = new ArrayList<>();
        boards.forEach(resultBoard::add);

        Iterable<Update> updates = updateRepo.findByBoardID(resultBoard.get(0).id());
        List<Update> result = new ArrayList<Update>();
        updates.forEach(result::add);
        Assert.assertTrue(result.get(0).timeUpdate().before(result.get(1).timeUpdate()));
    }*/

}
