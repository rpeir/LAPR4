package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryBoardRepository extends InMemoryDomainRepository<Board,Long> implements BoardRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Board> findByOwner(EmailAddress email) {
        return match(e -> e.owner().identity().equals(email));
    }

    @Override
    public Iterable<Board> findActiveByOwner(EmailAddress email) {
        return match(e -> e.owner().identity().equals(email) && e.isActive());
    }

    @Override
    public Board findById(String id){
        return matchOne(e -> e.id() == Long.parseLong(id)).get();
    }

    @Override
    public Optional<Board> findByTitle(String title) {
        return matchOne(e -> e.board_title().equals(title));
    }
}
