package eapli.ecourse.coursemanagement.application;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
public class SetEnrollmentStateController {

    private AuthorizationService authz;
    private CourseRepository courseRepository;

    public SetEnrollmentStateController(AuthorizationService authz){
        this.authz = authz;
        this.courseRepository = PersistenceContext.repositories().courses();
    }

    /**
     * This method returns all courses
     * @return all courses
     */
    public Iterable<Course> allCourses(){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return courseRepository.findAll();
    }


    /**
     * This method changes the enrollment state of a course
     * @param state
     * @param course
     */
    public void changeEnrollmentState(String state, Course course){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        if (state == null){
            throw new IllegalArgumentException();
        }
        course.changeEnrollmentState(state);
        courseRepository.save(course);
    }

}
