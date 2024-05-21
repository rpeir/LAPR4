package eapli.ecourse.examExecution.repositories;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.examExecution.domain.ExamExecution;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.student.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;

public interface ExamExecutionRepository extends DomainRepository<Long, ExamExecution> {
    Iterable<ExamExecution> findByExam(Exam exam);

    Iterable<ExamExecution> findByStudent(Student student);

    Iterable<ExamExecution> findByCourse(Course course);
}
