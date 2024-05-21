package eapli.ecourse.exammanagment.application;

import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.examExecution.domain.ExamExecution;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Objects;
import java.util.Optional;

public class ListCourseGradesController {

    private AuthorizationService authz;
    private ExamRepository exams;
    private CourseRepository courses;
    private CourseEnrollmentRepository courseEnrollments;
    private TeacherRepository teachers;
    private ListExamsService listExamsService;

    public ListCourseGradesController() {
        this.authz = AuthzRegistry.authorizationService();
        this.exams = PersistenceContext.repositories().exams();
        this.courses = PersistenceContext.repositories().courses();
        this.courseEnrollments = PersistenceContext.repositories().courseEnrollments();
        this.teachers = PersistenceContext.repositories().teachers();
        this.listExamsService = new ListExamsService(authz, courseEnrollments, exams);
    }

    public Iterable<Course> findByTeacher() {
        SystemUser user= authz.session().get().authenticatedUser(); //get authenticated user
        Teacher teacher = null;
        Optional<Teacher> eUser=this.teachers.findByEmail(user.email());
        if(eUser.isPresent())
            teacher=eUser.get();
        else
            System.out.println("User not found");
        return courses.findByTeacher(Objects.requireNonNull(teacher).identity());
    }

    public Iterable<ExamExecution> findByCourse(Course course) {
        return listExamsService.findByCourse(course);
    }

}
