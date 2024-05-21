package eapli.ecourse.persistence.impl.jpa;

import eapli.ecourse.Application;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.examExecution.domain.ExamExecution;
import eapli.ecourse.examExecution.repositories.ExamExecutionRepository;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.student.domain.Student;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import javax.persistence.Query;

public class JpaExamExecutionRepository extends JpaAutoTxRepository<ExamExecution,Long,Long> implements ExamExecutionRepository {
    public JpaExamExecutionRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public JpaExamExecutionRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().extendedPersistenceProperties(), "examExecutionId");
    }
    public JpaExamExecutionRepository(TransactionalContext tx, String identityFieldName) {
        super(tx, identityFieldName);
    }

    public JpaExamExecutionRepository(TransactionalContext autoTx) {
        super(autoTx, "examExecutionId");
    }
    @Override
    public Iterable<ExamExecution> findByExam(Exam exam) {
        Query query = entityManager().createQuery("select s from ExamExecution s where s.exam = :param");
        query.setParameter("param", exam);
        return (Iterable<ExamExecution>) query.getResultList();
    }

    @Override
    public Iterable<ExamExecution> findByStudent(Student student) {
        Query query = entityManager().createQuery("select s from ExamExecution s where s.student = :param");
        query.setParameter("param", student);
        return (Iterable<ExamExecution>) query.getResultList();
    }

    @Override
    public Iterable<ExamExecution> findByCourse(Course course) {
        Query query = entityManager().createQuery("select s from ExamExecution s where s.exam.course = :param");
        query.setParameter("param", course);
        return (Iterable<ExamExecution>) query.getResultList();
    }
}
