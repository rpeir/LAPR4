package eapli.ecourse.sharedBoardManagement.repositories;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

public interface BoardSharedRepository extends DomainRepository<Long, SharedBoard>, LockableDomainRepository<Long, SharedBoard> {

    Iterable<SharedBoard> findBoardsWithWritePermission(EmailAddress email);
    Iterable<SharedBoard> findBoardsWithReadPermission(EmailAddress email);
    boolean checkIfUserHasPermission(EmailAddress email, Board board);
    Iterable<SharedBoard> findByEmail(EmailAddress userEmail);
}
