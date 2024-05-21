package eapli.ecourse.sharedBoard;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.domain.State;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.sharedBoardManagement.domain.BoardSharedBuilder;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.domain.UserPermission;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class BoardSharedBuilderTest {
    private static final UserPermission userPermission=UserPermission.WRITE;
    private static final UserPermission up1=UserPermission.READ;
    private ECourseUser usr1;
    private Board board;
    private EmailAddress email1;

    @Before
    public void setUp(){
        usr1=mock(ECourseUser.class);
        board=new Board("title1", State.ACTIVE,usr1);
        email1=mock(EmailAddress.class);

    }
    @Test
    public void ensureBuildsValid(){
        BoardSharedBuilder builder=new BoardSharedBuilder();
        builder.withBoard(board);
        builder.withPermission(userPermission);
        builder.withEmail(email1);
        SharedBoard sh=builder.build();
        Assert.assertNotNull(sh);
    }
    @Test
    public void ensureCannotBuildWithInvalidBoard(){
        BoardSharedBuilder builder=new BoardSharedBuilder();
        builder.withPermission(userPermission);
        builder.withEmail(email1);

        Assert.assertThrows(IllegalArgumentException.class,()->builder.build());
    }
    @Test
    public void ensureCannotBuildWithInvalidUserPermission(){
        BoardSharedBuilder builder=new BoardSharedBuilder();
        builder.withBoard(board);
        builder.withEmail(email1);
        Assert.assertThrows(IllegalArgumentException.class,()->builder.build());

    }
    @Test
    public void ensureCannotBuildWithInvalidEmail(){
        BoardSharedBuilder builder=new BoardSharedBuilder();
        builder.withBoard(board);
        builder.withPermission(userPermission);
        Assert.assertThrows(IllegalArgumentException.class,()->builder.build());

    }
}
