package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.courseenrollement.domain.EnrollmentApplication;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.student.domain.Student;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCourseEnrollmentRepository extends InMemoryDomainRepository<CourseEnrollment,String> implements CourseEnrollmentRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Optional<CourseEnrollment> findByCourse(Course course) {
        return matchOne(e -> e.course().sameAs(course));
    }

    @Override
    public Iterable<CourseEnrollment> hasPendingEnrollmentApplications() {
        return match(CourseEnrollment::hasPendingApplications);
    }

    @Override
    public Iterable<CourseEnrollment> findEnrollmentsByStudent(Student student) {
        return match(e -> e.enrolledStudents().contains(student));
    }

    /**
     * @param emailAddress
     * @return
     */
    @Override
    public Iterable<Course> coursesImEnrolled(EmailAddress emailAddress) {
        return null;
    }

}
