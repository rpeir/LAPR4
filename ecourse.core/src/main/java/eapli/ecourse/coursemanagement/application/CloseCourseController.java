package eapli.ecourse.coursemanagement.application;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

import java.sql.SQLException;

public class CloseCourseController {
    private AuthorizationService authz;
    private CourseRepository courseRepository;
    private ListCourseService srvc;

    public CloseCourseController(AuthorizationService authz, CourseRepository courseRepository){
        this.authz = authz;
        this.courseRepository = courseRepository;
        this.srvc = new ListCourseService(authz,courseRepository);
    }

    public Iterable<Course> openCourses(){
        return srvc.openCourses();
    }

    public Course closeCourse(Course course){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        if (course == null){
            throw new IllegalArgumentException();
        }
        course.closeCourse();
        return courseRepository.save(course);
    }
}
