package eapli.ecourse.tcp.server.controller;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.postit.application.CreatePostItController;
import eapli.ecourse.postit.domain.PostIt;
import eapli.ecourse.postit.repositories.PostItRepository;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.tcp.infrastructure.MessageTCP;
import eapli.ecourse.teacher.repositories.TeacherRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreatePostItServerTCPController extends BaseTCPServerController<CreatePostItController> {
    private BoardRepository boardRepository;
    private PostItRepository postItRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public CreatePostItServerTCPController() {
        super(new CreatePostItController(PersistenceContext.repositories().board(),
                PersistenceContext.repositories().students(),
                PersistenceContext.repositories().teachers()));
    }
    public CreatePostItServerTCPController(CreatePostItController controller) {
        super(controller);
    }
    public String listUserBoardsShared(MessageTCP message) {
        if(!sessionManager.isValidSession(message.sessionID())){
            throw new IllegalArgumentException("Invalid session");
        }
        Iterable<Board> boards = this.controller.listUserBoardsShared(sessionManager.getUsername(message.sessionID()));
        StringBuilder sb = new StringBuilder();
        for (Board board : boards) {
            sb.append(board.board_title());
            sb.append("\0");
        }
        return sb.toString();
    }

    public byte[] createPostIt(String contentType, byte[] content, String boardTitle, String row, String column,long sessionId) throws IOException {
        if(!sessionManager.isValidSession(sessionId)){
            throw new IllegalArgumentException("Invalid session");
        }
        PostIt newPostIt = controller.createPostIt(sessionManager.getUsername(sessionId),contentType, content, boardTitle, row, column);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newPostIt);
        return os.toByteArray();
    }
}
