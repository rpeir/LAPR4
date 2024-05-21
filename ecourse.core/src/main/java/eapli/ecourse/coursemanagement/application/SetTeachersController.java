package eapli.ecourse.coursemanagement.application;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.ecourse.teacher.application.ListTeacherService;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

import java.util.Set;

public class SetTeachersController {
    private AuthorizationService authz;
    private CourseRepository courseRepository;

    private ListCourseService svcCourse;
    private ListTeacherService svcTeachers;

    public SetTeachersController(AuthorizationService authz, CourseRepository courseRepository, TeacherRepository teacherRepository){
        this.authz = authz;
        this.courseRepository = courseRepository;
        this.svcCourse = new ListCourseService(authz,courseRepository);
        this.svcTeachers = new ListTeacherService(authz,teacherRepository);
    }

    public Iterable<Course> availableCourses(){
        authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER);
        return svcCourse.availableCourses();
    }

    public Iterable<Teacher> availableTeachers(){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        return svcTeachers.availableTeachers();
    }

    public void addTeachers(Course course, Set<Teacher> teacherSet){
        if (!authz.isAuthenticatedUserAuthorizedTo(ECourseRoles.MANAGER_USER))
            throw new RuntimeException("You are not authorized to execute this functionality");
        course.addTeachers(teacherSet);
        courseRepository.save(course);
    }

}
