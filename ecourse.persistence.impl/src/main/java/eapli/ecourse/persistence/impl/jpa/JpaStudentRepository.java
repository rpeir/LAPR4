package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.student.domain.MechanographicNumber;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Optional;

public class JpaStudentRepository  extends JpaAutoTxRepository<Student, Long, EmailAddress> implements StudentRepository {
public JpaStudentRepository(TransactionalContext autoTX){
    super(autoTX,"email");
}

   public JpaStudentRepository(String persistenceUnitName){
    super(persistenceUnitName, Application.settings().extendedPersistenceProperties(),"email");
   }

    @Override
    public Iterable<Student> students() {
        Query query = entityManager().createQuery("select s from Student s");
        return query.getResultList();
    }

    @Override
    public Optional<Student> findByMechanographicNumber(MechanographicNumber m) {
        Query query = entityManager().createQuery("select s from Student s where s.mechanographicNumber= :m");
        query.setParameter("m",m);
        try{
            return Optional.of((Student) query.getSingleResult());
        }catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Student> findByEmail(String string) {
        Query query = entityManager().createQuery("select s from Student s where s.systemUser.email= :email");
        query.setParameter("email",EmailAddress.valueOf(string));
        try{
            return Optional.of((Student) query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}
