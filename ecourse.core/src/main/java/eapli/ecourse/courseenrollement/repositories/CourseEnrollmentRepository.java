package eapli.ecourse.courseenrollement.repositories;

import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.courseenrollement.domain.EnrollmentApplication;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.student.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

public interface CourseEnrollmentRepository extends DomainRepository<String, CourseEnrollment> {

    Optional<CourseEnrollment> findByCourse(Course course);

    Iterable<CourseEnrollment> hasPendingEnrollmentApplications();

    Iterable<CourseEnrollment> findEnrollmentsByStudent(Student student);

    Iterable<Course> coursesImEnrolled(EmailAddress emailAddress);
}
