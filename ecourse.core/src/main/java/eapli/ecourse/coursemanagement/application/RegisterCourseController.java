package eapli.ecourse.coursemanagement.application;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

public class RegisterCourseController {
    private final AuthorizationService authz;
    private final CourseRepository repo;

    public RegisterCourseController(AuthorizationService authz, CourseRepository repo) {
        this.authz = authz;
        this.repo = repo;
    }




    public Course registerCourse(String courseCode, String courseTitle, String description, int minStudents, int maxStudents, String closeDate) {
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        Course newCourse = new Course(courseCode, courseTitle, minStudents, maxStudents, description,closeDate);
        return repo.save(newCourse);
    }
}
