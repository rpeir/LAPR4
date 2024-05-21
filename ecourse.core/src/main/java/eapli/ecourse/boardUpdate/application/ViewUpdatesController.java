package eapli.ecourse.boardUpdate.application;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.boardUpdate.domain.Update;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.infrastructure.persistence.RepositoryFactory;
import eapli.ecourse.sharedBoardManagement.application.ShareBoardService;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.ArrayList;
import java.util.List;

public class ViewUpdatesController {
    private final RepositoryFactory repositoryFactory;

    private final ShareBoardService shareBoardService;

    public ViewUpdatesController() {
        repositoryFactory= PersistenceContext.repositories();
        shareBoardService=new ShareBoardService();
    }
    public Iterable<Board> listUserBoards(EmailAddress email) {
       Iterable<Board> boards= shareBoardService.userBoards(email);
       if(!boards.iterator().hasNext()){
           throw new IllegalStateException("User has no active boards associated!");
       }
         return boards;
    }
    public Iterable<Update> listBoardHistory(String board){
        BoardRepository repoBoards=repositoryFactory.board();
        Board b=repoBoards.findByTitle(board).orElseThrow();
        return b.history();
    }
}
