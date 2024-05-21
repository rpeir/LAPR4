package eapli.ecourse.coursemanagement.application;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;


public class OpenCourseController {

    private AuthorizationService authz;
    private CourseRepository courseRepository;
    private ListCourseService srvc;

    public OpenCourseController(AuthorizationService authz, CourseRepository courseRepository){
        this.authz = authz;
        this.courseRepository = courseRepository;
        this.srvc = new ListCourseService(authz,courseRepository);
    }

    public Iterable<Course> closedCourses(){
        return srvc.closeCourses();
    }

    public Course openCourse(Course course){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        if (course == null){
            throw new IllegalArgumentException();
        }
        course.openCourse();
        return courseRepository.save(course);
    }
}
