package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.boardUpdate.domain.Update;
import eapli.ecourse.boardUpdate.repositories.UpdateRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.antlr.v4.runtime.misc.Pair;

import javax.persistence.Query;
import java.util.List;

public class JpaUpdateRepository extends JpaAutoTxRepository<Update,Long,Long> implements UpdateRepository {
    public JpaUpdateRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(), "updateId");
    }

    public JpaUpdateRepository(TransactionalContext autoTx) {
        super(autoTx, "updateId");
    }

    @Override
    public Iterable<Update> findByBoardID(Long boardID) {
        Query query = entityManager().createQuery("select u from Update u where u.id= :boardID and u.undo = false");
        query.setParameter("boardID", boardID);
        return query.getResultList();
    }

    @Override
    public List<Update> findLastTwoByPostIt(Long postItID) {
        Query query = entityManager().createQuery("SELECT u FROM CellUpdate u WHERE u.postIt.id = :postItID AND u.undo = false ORDER BY u.timeUpdate DESC");
        query.setMaxResults(2);
        query.setParameter("postItID", postItID);
        return query.getResultList();
    }

    @Override
    public List<Update> findLastTwoByBoardAndPosition(Long boardID, int row, int column) {
        Pair<Integer, Integer> pair = new Pair<>(row, column);
        Query query = entityManager().createQuery("SELECT u FROM CellUpdate u WHERE u.board.id = :boardID AND u.endPosition = :pos AND u.undo = false ORDER BY u.timeUpdate DESC");
        query.setMaxResults(2);
        query.setParameter("boardID", boardID);
        query.setParameter("pos", pair);
        return query.getResultList();
    }

}