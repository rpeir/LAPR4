package eapli.ecourse.sharedBoard;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.domain.State;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.domain.UserPermission;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class SharedBoardTest {
    private static final UserPermission userPermission=UserPermission.WRITE;
    private static final UserPermission up1=UserPermission.READ;
    private ECourseUser usr1;
    private EmailAddress email1;
    private Board board;

    @Before
    public void setUp(){
        usr1=mock(ECourseUser.class);
        board=new Board("title1",State.ACTIVE,usr1);
        email1=mock(EmailAddress.class);
    }
    @Test
    public void ensureBuildValid(){
        SharedBoard sh=new SharedBoard(userPermission,board,email1);
        Assert.assertNotNull(sh);
    }
    @Test
    public void ensureSharedBoardIsNotCreatedWithInvalidUserPermission(){
        Assert.assertThrows(IllegalArgumentException.class,()-> new SharedBoard(null,board,email1));
    }
    @Test
    public void ensureSharedBoardIsNotCreatedWithInvalidBoard(){
        Assert.assertThrows(IllegalArgumentException.class,()-> new SharedBoard(userPermission,null,email1));
    }
    @Test
    public void ensureSharedBoardIsNotCreatedWithInvalidEmail(){
        Assert.assertThrows(IllegalArgumentException.class,()-> new SharedBoard(userPermission,board,null));
    }
    @Test
    public void sameSharedBoard(){
        SharedBoard sh=new SharedBoard(userPermission,board,email1);
        Assert.assertTrue(sh.sameAs(sh));

    }
}
