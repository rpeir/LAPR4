package eapli.ecourse.postit.application;

import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.boardManagement.updateevent.BoardUpdateEvent;
import eapli.ecourse.boardUpdate.domain.CellUpdateType;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.postit.domain.Content;
import eapli.ecourse.postit.domain.ContentType;
import eapli.ecourse.postit.domain.PostIt;
import eapli.ecourse.postit.repositories.PostItRepository;
import eapli.ecourse.sharedBoardManagement.application.ShareBoardController;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.ecourse.usermanagement.service.FindLoggedECourseUser;
import eapli.ecourse.boardManagement.domain.Board;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import org.antlr.v4.runtime.misc.Pair;

import java.util.Calendar;
import java.util.Optional;

public class CreatePostItController {
    private BoardRepository boardRepository;
    private ShareBoardController shareBoardController;
    private FindLoggedECourseUser findLoggedECourseUser;
    private EventPublisher publisher;

    public CreatePostItController(BoardRepository boardRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.boardRepository = boardRepository;
        this.shareBoardController = new ShareBoardController();
        this.findLoggedECourseUser = new FindLoggedECourseUser(AuthzRegistry.authorizationService(), studentRepository, teacherRepository);
        this.publisher = InProcessPubSub.publisher();
    }

    public Iterable<Board> listUserBoardsShared(EmailAddress emailAddress) {
        return shareBoardController.listUserBoardsShared(emailAddress);
    }

    public PostIt createPostIt(EmailAddress email, String contentType, byte[] content, String boardTitle, String row, String column) {
        PostIt newPostIt;
        Board savedBoard;
        PostIt savedPostIt;
        ECourseUser owner = findLoggedECourseUser.findLoggedECourseUser(email);
        newPostIt = new PostIt(new Content(ContentType.valueOf(contentType), content), owner);
        Optional<Board> board = boardRepository.findByTitle(boardTitle);
        if (board.isEmpty())
            throw new IllegalArgumentException("Board not found");
        if (!board.get().isFree(Integer.parseInt(row), Integer.parseInt(column)))
            throw new IllegalArgumentException("Cannot create in this area. There is content there!");
        board.get().addPostIt(newPostIt, Integer.parseInt(row), Integer.parseInt(column));
        savedBoard = boardRepository.save(board.get());
        savedPostIt = savedBoard.getPostIt(Integer.parseInt(row), Integer.parseInt(column));
        this.publisher.publish(new BoardUpdateEvent(savedBoard, savedPostIt, Calendar.getInstance(), CellUpdateType.INSERT, new Pair<>(Integer.parseInt(row), Integer.parseInt(column)), new Pair<>(Integer.parseInt(row), Integer.parseInt(column))));
        return newPostIt;
    }

}

