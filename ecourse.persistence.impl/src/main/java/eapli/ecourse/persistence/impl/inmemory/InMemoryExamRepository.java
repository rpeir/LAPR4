package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryExamRepository extends InMemoryDomainRepository<Exam, Long> implements ExamRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Exam> findByCourse(Course course) {
        return match(e -> e.course().equals(course));
    }
}
