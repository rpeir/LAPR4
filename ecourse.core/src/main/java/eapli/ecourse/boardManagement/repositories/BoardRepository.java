package eapli.ecourse.boardManagement.repositories;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

public interface BoardRepository extends DomainRepository<Long, Board>, LockableDomainRepository<Long, Board> {

    Iterable<Board> findByOwner(EmailAddress email);

    Iterable<Board> findActiveByOwner(EmailAddress email);

    Board findById(String id);

    Optional<Board> findByTitle(String title);
}
