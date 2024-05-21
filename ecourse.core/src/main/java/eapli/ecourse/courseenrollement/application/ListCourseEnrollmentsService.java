package eapli.ecourse.courseenrollement.application;

import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

import java.util.Optional;

public class ListCourseEnrollmentsService {
    private AuthorizationService authz;
    private CourseEnrollmentRepository courseEnrollmentRepository;


    public ListCourseEnrollmentsService(AuthorizationService authz, CourseEnrollmentRepository courseEnrollmentRepository) {
        this.authz = authz;
        this.courseEnrollmentRepository = courseEnrollmentRepository;
    }

    public Iterable<Course> coursesImEnrolled(){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.STUDENT_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        Optional<EmailAddress> email = authz.session().map(s -> s.authenticatedUser().email());
        return courseEnrollmentRepository.coursesImEnrolled(email.get());
    }
}
