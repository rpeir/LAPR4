package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.student.domain.Student;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.Map;
import java.util.Optional;

public class JpaExamRepository extends JpaAutoTxRepository<Exam,Long, Long> implements ExamRepository {

    public JpaExamRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public JpaExamRepository(String persistenceUnitName, Map properties, String identityFieldName) {
        super(persistenceUnitName, properties, identityFieldName);
    }

    public JpaExamRepository(TransactionalContext tx, String identityFieldName) {
        super(tx, identityFieldName);
    }

    public JpaExamRepository(TransactionalContext autoTx) {
        super(autoTx, "examId");
    }

    public JpaExamRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(), "examId");
    }

    @Override
    public Iterable<Exam> findByCourse(Course course){
        Query query = entityManager().createQuery("select s from Exam s where s.course = :param");
        query.setParameter("param", course);
        return (Iterable<Exam>) query.getResultList();
    }
}
