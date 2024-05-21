package eapli.ecourse.board;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.domain.BoardBuilder;
import eapli.ecourse.boardManagement.domain.Column;
import eapli.ecourse.boardManagement.domain.State;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class BoardBuilderTest {
    private static final int MAX_COLUMNS=10;
    private static final int MAX_ROWS=20;

    private static final String title1="Title1";
    private static final String title2="Title2";
    private static final State state1=State.ACTIVE;
    private static final State state2=State.ARCHIVED;
    private static ECourseUser eUser1;
    private static ECourseUser eUser2;


    @Before
    public void setUp(){
        eUser1=mock(ECourseUser.class);
        eUser2=mock(ECourseUser.class);
    }
    @Test
    public void ensureBuildsValid(){
        BoardBuilder boardBuilder=new BoardBuilder();
        boardBuilder.withTitle(title1);
        boardBuilder.withOwner(eUser1);
        boardBuilder.withState(state1);
        //boardBuilder.withRow(1,"Row1");
        //boardBuilder.withColumn(1,"Column 1");
        boardBuilder.withMaxColumns(MAX_COLUMNS);
        boardBuilder.withMaxRows(MAX_ROWS);
        Board b=boardBuilder.build();
        Assert.assertNotNull(b);
        Assert.assertEquals(b.board_title(),title1);
    }
    @Test
    public void ensureCannotBuildWithoutTitle(){
        BoardBuilder boardBuilder=new BoardBuilder();
        boardBuilder.withOwner(eUser1);
        boardBuilder.withState(state1);
        //boardBuilder.withRow(1,"Row1");
        //boardBuilder.withColumn(1,"Column 1");
        boardBuilder.withMaxColumns(MAX_COLUMNS);
        boardBuilder.withMaxRows(MAX_ROWS);

        Assert.assertThrows(IllegalArgumentException.class,()->boardBuilder.build());
    }
    @Test
    public void ensureCannotBuildWithoutState(){
        BoardBuilder boardBuilder=new BoardBuilder();
        boardBuilder.withTitle(title1);
        boardBuilder.withOwner(eUser1);
        boardBuilder.withMaxColumns(MAX_COLUMNS);
        boardBuilder.withMaxRows(MAX_ROWS);
        Assert.assertThrows(IllegalArgumentException.class,()->boardBuilder.build());

    }
    @Test
    public void ensureCannotBuildWithoutOwner(){
        BoardBuilder boardBuilder=new BoardBuilder();
        boardBuilder.withTitle(title1);
        boardBuilder.withState(state1);
        boardBuilder.withMaxColumns(MAX_COLUMNS);
        boardBuilder.withMaxRows(MAX_ROWS);
        Assert.assertThrows(IllegalArgumentException.class,()->boardBuilder.build());

    }
}
