package eapli.ecourse.postit.repositories;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.postit.domain.PostIt;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface PostItRepository extends DomainRepository<Long, PostIt> {
   // Iterable<PostIt> findAllByBoard(Board board);
}
