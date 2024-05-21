package eapli.ecourse.exammanagment.repositories;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.framework.domain.repositories.DomainRepository;

public interface ExamRepository extends DomainRepository<Long, Exam> {
    /**
     * Finds exams by course
     * @param course course
     * @return exams
     */
    Iterable<Exam> findByCourse(Course course);

}
