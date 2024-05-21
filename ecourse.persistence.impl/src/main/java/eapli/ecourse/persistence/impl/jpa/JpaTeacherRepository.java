package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaTeacherRepository extends JpaAutoTxRepository<Teacher,Long, EmailAddress> implements TeacherRepository {

    public JpaTeacherRepository(TransactionalContext autoTx){
        super(autoTx,"email");
    }

    public JpaTeacherRepository(String persistenceUnitName){
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(),"email");
    }
    @Override
    public Iterable<Teacher> availableTeachers() {
        //Query query = entityManager().createQuery("select  t from Teacher  t where t.isActive = true"); TO BE ALTERED
        Query query = entityManager().createQuery("select  t from Teacher  t");
        return query.getResultList();
        //TO BE ALTERED
    }

    @Override
    public Optional<Teacher> findByEmail(EmailAddress email) {
        Query query = entityManager().createQuery("select t from Teacher t where t.systemUser.email= :email");
        query.setParameter("email",email);
        try{
            return Optional.of((Teacher) query.getSingleResult());
        }catch (Exception e){
            return Optional.empty();
        }
    }

}
