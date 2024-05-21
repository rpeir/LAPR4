package eapli.ecourse.boardManagement.application;

import eapli.ecourse.Application;
import eapli.ecourse.boardManagement.domain.*;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.infrastructure.persistence.RepositoryFactory;
import eapli.ecourse.sharedBoardManagement.domain.BoardSharedBuilder;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.domain.UserPermission;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.ecourse.usermanagement.service.FindLoggedECourseUser;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;
import java.util.Optional;

public class CreateBoardController {
    private AuthorizationService authz;
    private RepositoryFactory repositoryFactory;
    private FindLoggedECourseUser loggedSvc;
    private ECourseUser owner;


    public CreateBoardController() {
        this.authz = AuthzRegistry.authorizationService();
        this.repositoryFactory=PersistenceContext.repositories();
        this.loggedSvc = new FindLoggedECourseUser(authz,this.repositoryFactory.students(),this.repositoryFactory.teachers());
    }


    public Board createBoard(String title, EmailAddress email) {
        owner = loggedSvc.findLoggedECourseUser(email);
        BoardBuilder boardBuilder = new BoardBuilder();
        boardBuilder.withTitle(title);
        int maxColumns=Integer.parseInt(Application.settings().getProperty("Board.maxColumns"));
        boardBuilder.withMaxRows(maxColumns);
        int maxRows=Integer.parseInt(Application.settings().getProperty("Board.maxRows"));
        boardBuilder.withMaxColumns(maxRows);
        boardBuilder.withOwner(owner);
        boardBuilder.withState(State.ACTIVE);
        for(int i=0;i<maxRows;i++){
            boardBuilder.withRow(i,"Row "+(i+1));
        }
        for(int i=0;i<maxColumns;i++){
            boardBuilder.withColumn(i,"Column "+(i+1));
        }
        return repositoryFactory.boards().save(boardBuilder.build());
    }

    public SharedBoard defineSharedBoardPermisssions(Board board){
        BoardSharedBuilder boardSharedBuilder = new BoardSharedBuilder();
        boardSharedBuilder.withBoard(board);
        boardSharedBuilder.withPermission(UserPermission.WRITE);
        boardSharedBuilder.withEmail(owner.identity());
        return repositoryFactory.boardShared().save(boardSharedBuilder.build());
    }
}
