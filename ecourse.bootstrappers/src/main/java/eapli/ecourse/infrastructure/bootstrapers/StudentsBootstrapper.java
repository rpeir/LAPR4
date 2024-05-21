package eapli.ecourse.infrastructure.bootstrapers;

import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.courseenrollement.domain.EnrollmentApplication;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.ecourseusermanagement.domain.TPN;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.student.domain.Student;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.ecourse.usermanagement.domain.ECourseRoles;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class StudentsBootstrapper extends SystemUsersBootstrapperBase implements Action {
    private static final Logger LOGGER = LogManager.getLogger(StudentsBootstrapper.class);
    private static final HashSet<Role> STUDENT_ROLE = new HashSet<>();
    private final StudentRepository students = PersistenceContext.repositories().students();
    private final CourseEnrollmentRepository enrollments = PersistenceContext.repositories().courseEnrollments();
    private final CourseRepository courses = PersistenceContext.repositories().courses();

    public StudentsBootstrapper() {
        STUDENT_ROLE.add(ECourseRoles.STUDENT_USER);
    }

    @Override
    public boolean execute() {
        try {
            create();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Student registerStudent1() {
        return register("student1@email.org", "StudentPassword10", "Student", "One", new Date(), "111111111");
    }

    private Student registerStudent2() {
        return register("student2@email.org", "StudentPassword10", "Student", "Two", new Date(), "222222222");
    }

    private Student registerStudent3() {
        return register("student3@email.org", "StudentPassword10", "Student", "Three", new Date(), "333333333");
    }

    private void create() {
        Student student1 = registerStudent1();
        Student student2 = registerStudent2();
        Student student3 = registerStudent3();

        //Course and Course Enrollment
        Course course = courses.save(new Course("COURSE1", "Course One",  1, 100,"Course One Test", "31-12-2023"));
        course.changeEnrollmentState("open enrollments");
        course = courses.save(course);

        CourseEnrollment courseEnrollment = new CourseEnrollment(course);
        courseEnrollment = enrollments.save(courseEnrollment);

        // Add apllication for student 3
        courseEnrollment.addApplication(student1);
        courseEnrollment = enrollments.save(courseEnrollment);

        Set<EnrollmentApplication> newset = courseEnrollment.enrollmentApplications();
        for (EnrollmentApplication ap : newset) {
            ap.acceptApplication();
            courseEnrollment.addApplication(ap);
            enrollments.save(courseEnrollment);
        }

        /*
        ApproveRejectApplicationsController approveRejectApplicationsController = new ApproveRejectApplicationsController(AuthzRegistry.authorizationService());
        Set<EnrollmentApplication> enrollmentApplicationsSet = approveRejectApplicationsController.listPendingApprovals(courseEnrollment);

        Set<EnrollmentApplication> changed = courseEnrollment.enrollmentApplications();
        for (EnrollmentApplication ap : changed) {
            approveRejectApplicationsController.processApproval(courseEnrollment, ap, true);
            courseEnrollmentRepository.save(courseEnrollment);
        }*/
    }

    private Student register(String email, String password, String firstName, String lastName, Date date, String tpn) {
        try {
            SystemUser systemUser = registerUser(email, password, firstName, lastName, email, STUDENT_ROLE);
            Student student = students.save(new Student(systemUser, EmailAddress.valueOf(email), firstName + " " + lastName, lastName, date, new TPN(tpn)));
            LOGGER.debug("»»» {}", email);
            return student;
        } catch (IntegrityViolationException | ConcurrencyException ex){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)",email);
            LOGGER.trace("Assuming existing record",ex);
            return students.findByEmail(email).get();
        }
    }

}

