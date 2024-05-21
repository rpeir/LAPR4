package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.domain.State;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaBoardRepository extends JpaAutoTxRepository<Board,Long,Long>implements BoardRepository {
    public JpaBoardRepository(TransactionalContext autoTX){
        super(autoTX,"id");
    }
    public JpaBoardRepository(String persistenceUnitName){
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(),"id");
    }

    @Override
    public Iterable<Board> findByOwner(EmailAddress email) {
        Query query = entityManager().createQuery("select b from Board b where b.owner.emailAddress= :email");
        query.setParameter("email",email);
        return query.getResultList();

    }

    @Override
    public Iterable<Board> findActiveByOwner(EmailAddress email) {
        Query query = entityManager().createQuery("select b from Board b where b.owner.emailAddress= :email and b.state= :state");
        query.setParameter("email",email);
        query.setParameter("state", State.ACTIVE);
        return query.getResultList();
    }

    @Override
    public Board findById(String id){
        Query query = entityManager().createQuery("select b from Board  b where b.id =:id");
        query.setParameter("id",(long) Integer.parseInt(id));
        return (Board) query.getSingleResult();
    }

    @Override
    public Optional<Board> findByTitle(String title) {
        final Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        return matchOne("e.title = :title", params);
    }
}
