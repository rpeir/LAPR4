package eapli.ecourse.boardManagement.application;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.infrastructure.persistence.RepositoryFactory;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;

public class ArchiveBoardController {
    private RepositoryFactory repositoryFactory= PersistenceContext.repositories();
    private Iterable<Board> ownedActiveBoards;

    public ArchiveBoardController() {
        repositoryFactory= PersistenceContext.repositories();
        ownedActiveBoards=new ArrayList<>();
    }
    public Iterable<Board> listActiveBoards(EmailAddress email){
        BoardRepository repo=repositoryFactory.boards();
        ownedActiveBoards=repo.findActiveByOwner(email);
        if(!ownedActiveBoards.iterator().hasNext()){
            throw new IllegalStateException("User has no active boards associated!");
        }
        return ownedActiveBoards;
    }
    public Board archiveBoard(String sBoard){
        Board board = repositoryFactory.board().findByTitle(sBoard).orElseThrow();
        board.archive();
        BoardRepository repo=repositoryFactory.boards();
        return repo.save(board);
    }
}
