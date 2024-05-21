package eapli.ecourse.coursemanagement.application;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

public class ListCourseService {

    private AuthorizationService authz;
    private CourseRepository courseRepository;

    public ListCourseService(AuthorizationService authz, CourseRepository courseRepository) {
        this.authz = authz;
        this.courseRepository = courseRepository;
    }

    public Iterable<Course> closeCourses() {
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return courseRepository.closeCourses();
    }

    public Iterable<Course> openCourses() {
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return courseRepository.openCourses();
    }

    public Iterable<Course> availableCourses() {
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return courseRepository.availableCourses();
    }

    public Iterable<Course> findAll() {
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return courseRepository.findAll();
    }

    public Iterable<Course> availableCoursesTeacher(EmailAddress teacherId) {
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.TEACHER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return courseRepository.availableCoursesTeacher(teacherId);
    }

    public Iterable<Course> availableCoursesStudent() {
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.STUDENT_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return courseRepository.availableCoursesStudent();
    }

}
