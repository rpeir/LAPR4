package eapli.ecourse.classmanagment.application;

import eapli.ecourse.classmanagment.domain.Class;
import eapli.ecourse.classmanagment.repositories.ClassRepository;
import eapli.ecourse.classmanagment.service.ScheduleService;
import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.application.ListCourseService;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.time.domain.model.TimeInterval;

import java.time.DayOfWeek;
import java.util.Optional;

@UseCaseController
public class ClassScheduleController {

    private final AuthorizationService authz;
    private final CourseEnrollmentRepository courseEnrollments;
    private final ClassRepository classes;

    private final CourseRepository courses;
    private final Teacher teacher;

    public ClassScheduleController() {
        authz = AuthzRegistry.authorizationService();
        courseEnrollments = PersistenceContext.repositories().courseEnrollments();
        classes = PersistenceContext.repositories().classes();
        courses = PersistenceContext.repositories().courses();

        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);
        if (authz.session().isPresent()) {
            teacher = PersistenceContext.repositories().teachers().findByEmail(authz.session().get().authenticatedUser().email()).get();
        } else {
            throw new IllegalStateException("User is not authenticated");
        }
    }

    public ClassScheduleController(AuthorizationService authz, CourseEnrollmentRepository courseEnrollments, ClassRepository classes, TeacherRepository teachers, CourseRepository courses) {
        this.authz = authz;
        this.courseEnrollments = courseEnrollments;
        this.classes = classes;
        this.courses = courses;

        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);
        if (authz.session().isPresent()) {
            teacher = teachers.findByEmail(authz.session().get().authenticatedUser().email()).get();
        } else {
            throw new IllegalStateException("User is not authenticated");
        }
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
     * Returns the class schedule of the selected course
     * @param course the course to be checked
     * @return course's classes
     */
    public Iterable<Class> courseSchedule(Course course) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);
        return classes.findByCourse(course);
    }

    /**
     * Checks if all the students of the course are available at that day of the week and time period
     * @param course the course to check
     * @param date the day of the week
     * @param timePeriod the period of time
     * @return if all the students are avaliable
     */
    public boolean checkStudentDisponibility(Course course, DayOfWeek date, TimeInterval timePeriod) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);
        Optional<CourseEnrollment> opt = courseEnrollments.findByCourse(course);
        if (opt.isEmpty()) throw new IllegalStateException("Do not exist course enrollment of course " + course.identity());
        return (new ScheduleService(authz, classes)).checkCourseStudentDisponibility(course, date, timePeriod, opt.get());
    }

    /**
     * Schedule the class
     * @param title class title
     * @param course class' course
     * @param date day of the week
     * @param timePeriod the period of time
     * @return the created classes
     */
    public Iterable<Class> scheduleClass(String title, Course course, DayOfWeek date, TimeInterval timePeriod) {
        authz.ensureAuthenticatedUserHasAnyOf(ECourseRoles.TEACHER_USER);
        Optional<CourseEnrollment> ce = courseEnrollments.findByCourse(course);
        if (ce.isEmpty()) throw new IllegalStateException("Do not exist course enrollment of course " + course.identity());
        return ((new ScheduleService(authz, classes)).scheduleClass(title, course, date, timePeriod, ce.get(), teacher));
    }
}
