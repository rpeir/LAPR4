package eapli.ecourse.sharedBoardManagement.application;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.LinkedList;
import java.util.List;

/**
 * Service to list the boards shared with a user
 */
public class ShareBoardService {
    private final BoardSharedRepository repo;

    public ShareBoardService(BoardSharedRepository repo) {
        this.repo = repo;
    }

    public ShareBoardService() {
        this.repo = PersistenceContext.repositories().boardShared();
    }

    /**
     * Returns the boards of a user, shared with him and the ones it owns
     * @param userEmail the user's email
     */
    public Iterable<Board> userBoards(EmailAddress userEmail) {
        Iterable<SharedBoard> sharedBoards = this.repo.findByEmail(userEmail);
        List<Board> boards = new LinkedList<>();
        for (SharedBoard sharedBoard : sharedBoards) {
            boards.add(sharedBoard.board());
        }
        return boards;
    }

    /**
     * Returns the boards of a user ONLY with write permitions, shared with him and the ones it owns
     * @param userEmail the user's email
     */
    public Iterable<Board> userBoardsWithWritePermission(EmailAddress userEmail) {
        Iterable<SharedBoard> sharedBoards = this.repo.findBoardsWithWritePermission(userEmail);
        List<Board> boards = new LinkedList<>();
        for (SharedBoard sharedBoard : sharedBoards) {
            boards.add(sharedBoard.board());
        }
        return boards;
    }

    /**
     * Returns the boards of a user ONLY with read permitions, shared with him and the ones it owns
     * @param userEmail the user's email
     */
    public Iterable<Board> userBoardsWithReadPermission(EmailAddress userEmail) {
        Iterable<SharedBoard> sharedBoards = this.repo.findBoardsWithReadPermission(userEmail);
        List<Board> boards = new LinkedList<>();
        for (SharedBoard sharedBoard : sharedBoards) {
            boards.add(sharedBoard.board());
        }
        return boards;
    }
}
