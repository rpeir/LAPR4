package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.domain.State;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.domain.UserPermission;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.Query;

public class JpaBoardSharedRepository extends JpaAutoTxRepository<SharedBoard, Long, Long> implements BoardSharedRepository {
    public JpaBoardSharedRepository(TransactionalContext autoTx){
        super(autoTx,"id");
    }

    public JpaBoardSharedRepository(String persistenceUnitName){
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(),"id");
    }

    @Override
    public Iterable<SharedBoard> findBoardsWithWritePermission(EmailAddress email) {
        Query query = entityManager().createQuery("SELECT b FROM SharedBoard b WHERE b.email = :email AND b.userPermission = :permission AND b.board.state = :state");
        query.setParameter("email", email);
        query.setParameter("permission", UserPermission.WRITE);
        query.setParameter("state", State.ACTIVE);
        return query.getResultList();
    }

    @Override
    public Iterable<SharedBoard> findBoardsWithReadPermission(EmailAddress email) {
        Query query = entityManager().createQuery("SELECT b FROM SharedBoard b WHERE b.email = :email AND b.userPermission = :permission");
        query.setParameter("email", email);
        query.setParameter("permission", UserPermission.READ);
        return query.getResultList();
    }

    @Override
    public boolean checkIfUserHasPermission(EmailAddress email, Board board) {
        Query query = entityManager().createQuery("SELECT b FROM SharedBoard b WHERE b.email = :email AND b.board = :board");
        query.setParameter("email", email);
        query.setParameter("board", board);
        return !query.getResultList().isEmpty();
    }

    @Override
    public Iterable<SharedBoard> findByEmail(EmailAddress userEmail) {
        Query query = entityManager().createQuery("SELECT b FROM SharedBoard b WHERE b.email = :email");
        query.setParameter("email", userEmail);
        return query.getResultList();
    }
}
