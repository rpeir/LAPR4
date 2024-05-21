package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.postit.domain.PostIt;
import eapli.ecourse.postit.repositories.PostItRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryPostItRepository extends InMemoryDomainRepository<PostIt, Long> implements PostItRepository {
    static {
        InMemoryInitializer.init();
    }

//    @Override
//    public Iterable<PostIt> findAllByBoard(Board board) {
//        return match(postIt -> postIt.board().equals(board));
//    }
}
