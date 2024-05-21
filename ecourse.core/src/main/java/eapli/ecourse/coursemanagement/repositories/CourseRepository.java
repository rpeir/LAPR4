package eapli.ecourse.coursemanagement.repositories;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

public interface CourseRepository extends DomainRepository<String, Course>, LockableDomainRepository<String, Course> {
    Iterable<Course> closeCourses();

    Iterable<Course> openCourses();

    Iterable<Course> availableCourses();

    Iterable<Course> findAll();

    Iterable<Course> availableCoursesTeacher(EmailAddress teacherId);

    Iterable<Course> availableCoursesStudent();

    Iterable<Course> enrollOrInProgressCourses();

    Iterable<Course> findByTeacher(EmailAddress teacherId);

}
