package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.postit.domain.PostIt;
import eapli.ecourse.postit.repositories.PostItRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;

public class JpaPostItRepository extends JpaAutoTxRepository<PostIt, Long, Long> implements PostItRepository{
    public JpaPostItRepository(TransactionalContext autoTx) {
        super(autoTx, "postItId");
    }

    public JpaPostItRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(), "postItId");
    }

//    @Override
//    public Iterable<PostIt> findAllByBoard(Board board) {
//        Query query = entityManager().createQuery("SELECT p FROM PostIt p WHERE p.board = :board");
//        query.setParameter("board", board);
//        return query.getResultList();
//    }
}