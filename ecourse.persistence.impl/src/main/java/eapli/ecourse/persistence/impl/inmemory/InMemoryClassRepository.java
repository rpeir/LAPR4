package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.classmanagment.domain.Class;
import eapli.ecourse.classmanagment.repositories.ClassRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.time.domain.DateTimeInterval;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryClassRepository extends InMemoryDomainRepository<Class, Long> implements ClassRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<Class> findByTitle(String title) {
        return matchOne(c -> c.title().equals(title));
    }

    @Override
    public Iterable<Class> saveAll(Iterable<Class> classes) {
        for(Class c : classes) {
            save(c);
        }
        return classes;
    }

    @Override
    public Iterable<Class> findByCourse(Course course) {
        return match(c -> c.course().equals(course));
    }

    @Override
    public Iterable<Class> findByCourseAndTimePeriod(Course course, DateTimeInterval date) {
        return match(c -> c.course().equals(course) && c.timePeriod().equals(date));
    }

    @Override
    public Iterable<Class> findByTeacherAndTimePeriod(Teacher teacher, DateTimeInterval date) {
        return match(c -> c.teacher().equals(teacher) && c.timePeriod().equals(date));
    }

    @Override
    public Iterable<Class> findByTimePeriod(DateTimeInterval timeInterval) {
        return match(c -> c.timePeriod().equals(timeInterval));
    }
}
