package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.examExecution.domain.ExamExecution;
import eapli.ecourse.examExecution.repositories.ExamExecutionRepository;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.student.domain.Student;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryExamExecutionRepository extends InMemoryDomainRepository<ExamExecution, Long> implements ExamExecutionRepository {
    static {
        InMemoryInitializer.init();
    }
    @Override
    public Iterable<ExamExecution> findByExam(Exam exam) {
        return match(c -> c.exam().equals(exam));
    }

    @Override
    public Iterable<ExamExecution> findByStudent(Student student) {
        return match(c -> c.student().equals(student));
    }

    @Override
    public Iterable<ExamExecution> findByCourse(Course course) {
        return match(c -> c.exam().course().equals(course));
    }
}
