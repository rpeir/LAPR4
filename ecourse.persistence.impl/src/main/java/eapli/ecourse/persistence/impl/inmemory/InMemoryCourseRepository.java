package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.function.Predicate;


public class InMemoryCourseRepository extends InMemoryDomainRepository<Course, String> implements CourseRepository {
    static {
        InMemoryInitializer.init();
    }

    /**
     * @return
     */
    @Override
    public Iterable<Course> closeCourses() {
        return match(Course::isClosed);
    }

    /**
     * @return
     */
    @Override
    public Iterable<Course> openCourses() {
        return match(Course::isOpen);
    }

    /**
     * @return
     */
    @Override
    public Iterable<Course> availableCourses() {
        Predicate<Course> notClosed = Course::isClosed;
        return match(notClosed.negate());
    }

    @Override
    public  Iterable<Course> findAll(){
        Predicate<Course> allCourses = course -> true;
        return match(allCourses);
    }

    /**
     * @param teacherId
     * @return
     */
    @Override
    public Iterable<Course> availableCoursesTeacher(EmailAddress teacherId) {
        return match(c -> c.teachersContains(teacherId) && !c.isClosed());
    }

    /**
     * @return
     */
    @Override
    public Iterable<Course> availableCoursesStudent() {
        return match(Course::isAvailableForEnrollments);
    }

    @Override
    public Iterable<Course> enrollOrInProgressCourses() {
        return match(Course::isEnrollOrInProgress);
    }

    @Override
    public Iterable<Course> findByTeacher(EmailAddress teacherId) {
        return match(c -> c.teachersContains(teacherId));
    }

}
