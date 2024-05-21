package eapli.ecourse.coursemanagement.application;

import eapli.ecourse.courseenrollement.application.ListCourseEnrollmentsService;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.exceptions.*;

import java.util.Optional;

public class ListAvailableCoursesController {
    private ListCourseService svcCourse;
    private CourseRepository repo;

    private ListCourseEnrollmentsService service;

    private AuthorizationService authz;

    public ListAvailableCoursesController(CourseRepository repo, AuthorizationService authz, CourseEnrollmentRepository courseEnrollmentRepository) {
        this.repo = repo;
        this.authz = authz;
        this.svcCourse = new ListCourseService(authz,repo);
        this.service = new ListCourseEnrollmentsService(authz, courseEnrollmentRepository);
    }

    public ListAvailableCoursesController(CourseRepository repo, AuthorizationService authz) {
        this.repo = repo;
        this.authz = authz;
        this.svcCourse = new ListCourseService(authz,repo);
    }

    public Iterable<Course> findAll(){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return svcCourse.findAll();
    }

    public Iterable<Course> availableCoursesTeacher(){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.TEACHER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        Optional<EmailAddress> email = authz.session().map(s -> s.authenticatedUser().email());
        return svcCourse.availableCoursesTeacher(email.get());
    }

    public Iterable<Course> availableCoursesStudent(){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.STUDENT_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return svcCourse.availableCoursesStudent();
    }

    public Iterable<Course> coursesImEnrolled() {
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.STUDENT_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return service.coursesImEnrolled();
    }
}
