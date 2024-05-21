package eapli.ecourse.exammanagment.application;

import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.exammanagment.repositories.ExamRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class ListCourseExamsController {

    private final AuthorizationService authz;
    private final ExamRepository exams;
    private final CourseRepository courses;

    /**
     * Contructor with Dependency Injection
     * @param authz authorization service
     * @param exams exam repository
     * @param courses course repository
     */
    public ListCourseExamsController(AuthorizationService authz, ExamRepository exams, CourseRepository courses) {
        this.authz = authz;
        this.exams = exams;
        this.courses = courses;
    }

    /**
     * Default constructor
     */
    public ListCourseExamsController() {
        authz = AuthzRegistry.authorizationService();
        exams = PersistenceContext.repositories().exams();
        courses = PersistenceContext.repositories().courses();
    }

    /**
     * Returns the courses of the teacher
     * @return courses
     */
    public Iterable<Course> listCourses() {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);

        return new ListCourseService(authz, courses).availableCoursesTeacher(authz.session().get().authenticatedUser().email());
    }


    /**
     * Returns the exams of the course
     * @param course course
     * @return exams
     */

    public Iterable<Exam> listExams(Course course) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);

        return exams.findByCourse(course);
    }

}
