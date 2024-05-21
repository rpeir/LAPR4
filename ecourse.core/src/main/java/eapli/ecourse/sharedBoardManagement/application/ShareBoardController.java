package eapli.ecourse.sharedBoardManagement.application;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.infrastructure.persistence.RepositoryFactory;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.domain.UserPermission;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShareBoardController {
    private RepositoryFactory repositoryFactory = PersistenceContext.repositories();
    private AuthorizationService authz;
    private Iterable<Board> ownedBoards;

    public ShareBoardController() {
        repositoryFactory = PersistenceContext.repositories();
        authz = AuthzRegistry.authorizationService();
        ownedBoards = new ArrayList<>();
    }


    public Iterable<Board> listActiveBoards(EmailAddress email) {
        BoardRepository repo = repositoryFactory.boards();
        ownedBoards = repo.findActiveByOwner(email);
        if (!ownedBoards.iterator().hasNext()) {
            throw new IllegalStateException("User has no boards associated");
        }
        return ownedBoards;
    }

    public Iterable<Board> listUserBoards() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.userRoles());
        BoardRepository repo = repositoryFactory.board();
        ownedBoards = repo.findByOwner(authz.session().get().authenticatedUser().email());
        if (!ownedBoards.iterator().hasNext()) {
            throw new IllegalStateException("User has no boards associated");
        }
        return ownedBoards;
    }

    public SharedBoard shareBoard(String boardTitle, String sEmail, String sPermission) {
        EmailAddress email = EmailAddress.valueOf(sEmail);
        Board board = repositoryFactory.board().findByTitle(boardTitle).orElseThrow();
        UserPermission permission = UserPermission.valueOf(sPermission);
        StudentRepository repositoryStd = repositoryFactory.students();
        Optional<Student> student = repositoryStd.findByEmail(sEmail);
        if (!student.isPresent()) {
            TeacherRepository repositoryTch = repositoryFactory.teachers();
            Optional<Teacher> teacher = repositoryTch.findByEmail(email);
            if (!teacher.isPresent()) {
                throw new IllegalStateException("User does not exist");
            }
        }
        SharedBoard sharedBoard = new SharedBoard(permission, board, email);
        BoardSharedRepository repository = repositoryFactory.boardShared();
        repository.save(sharedBoard);
        return sharedBoard;
    }

    public List<UserPermission> getPermissions() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.userRoles());
        return List.of(UserPermission.values());
    }

    public Board getBoardByTitle(String title, EmailAddress email) throws IllegalAccessException {
        BoardRepository boardRepository = repositoryFactory.boards();
        Board board = boardRepository.findByTitle(title).orElseThrow();
        BoardSharedRepository boardSharedRepository = repositoryFactory.boardShared();
        if (!boardSharedRepository.checkIfUserHasPermission(email, board)) throw new IllegalAccessException("User does not have permission to access this board");
        return board;
    }

    public List<Board> listUserBoardsShared(EmailAddress emailAddress) {
        BoardSharedRepository repo = repositoryFactory.boardShared();
        Iterable<SharedBoard> boardShares = repo.findBoardsWithWritePermission(emailAddress);
        List<Board> result = new ArrayList<>();
        for (SharedBoard sharedBoard : boardShares) {
            result.add(sharedBoard.board());
        }
        return result;
    }

    public List<Board> listUserReadBoardsShared(EmailAddress emailAddress) {
        BoardSharedRepository repo = repositoryFactory.boardShared();
        List<Board> result = (List<Board>) new ShareBoardService().userBoards(emailAddress);
        if (result.isEmpty()) throw new IllegalStateException("User has no boards associated");
        return result;
    }

}
