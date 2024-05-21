package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemorySharedBoardRepository extends InMemoryDomainRepository<SharedBoard, Long> implements BoardSharedRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<SharedBoard> findBoardsWithWritePermission(EmailAddress email) {
        return match(b -> b.email().equals(email) && b.userPermission().equals("WRITE") && b.board().isActive());
    }

    @Override
    public Iterable<SharedBoard> findBoardsWithReadPermission(EmailAddress email) {
        return match(b -> b.email().equals(email) && b.userPermission().equals("READ"));
    }

    @Override
    public boolean checkIfUserHasPermission(EmailAddress email, Board board) {
        return match(b -> b.email().equals(email) && b.board().equals(board)).iterator().hasNext();
    }

    @Override
    public Iterable<SharedBoard> findByEmail(EmailAddress userEmail) {
        return match(b -> b.email().equals(userEmail));
    }
}
