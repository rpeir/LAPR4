package eapli.ecourse.classmanagment.repositories;

import eapli.ecourse.classmanagment.domain.Class;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.time.domain.DateTimeInterval;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.time.domain.model.DateInterval;

import java.util.Optional;

/**
 * The repository for Classes.
 */
public interface ClassRepository extends DomainRepository<Long, Class> {

    /**
     * Finds a class by its title
     * @param title the title of the class
     * @return the class with the given title, if any
     */
    Optional<Class> findByTitle(final String title);

    /**
     * Saves a collection of classes
     * @param classes the classes to save
     * @return the saved classes
     */
    Iterable<Class> saveAll(Iterable<Class> classes);

    /**
     * Finds all classes of a course
     * @param course the course
     * @return the found classes
     */
    Iterable<Class> findByCourse(Course course);

    /**
     * Finds all classes of a course on a given date
     * @param course the course
     * @param date the date
     * @return the found classes
     */
    Iterable<Class> findByCourseAndTimePeriod(Course course, DateTimeInterval date);

    /**
     * Finds all classes of a teacher and on a given date
     * @param teacher the teacher
     * @param date the date
     * @return the found classes
     */
    Iterable<Class> findByTeacherAndTimePeriod(Teacher teacher, DateTimeInterval date);

    /**
     * Finds all classes by a given time interval
     * @param timeInterval the time interval
     * @return the found classes
     */
    Iterable<Class> findByTimePeriod(DateTimeInterval timeInterval);
}
