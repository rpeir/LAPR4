package eapli.ecourse.courseenrollement.application;

import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.courseenrollement.domain.EnrollmentApplication;
import eapli.ecourse.courseenrollement.repositories.CourseEnrollmentRepository;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.coursemanagement.repositories.CourseRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.student.repositories.StudentRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ApproveRejectApplicationsController {

    private AuthorizationService authz;
    private CourseEnrollmentRepository courseEnrollmentRepository;
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public ApproveRejectApplicationsController(AuthorizationService authz){
        this.authz = authz;
        this.courseEnrollmentRepository = PersistenceContext.repositories().courseEnrollments();
        this.courseRepository = PersistenceContext.repositories().courses();
        this.studentRepository = PersistenceContext.repositories().students();
    }
    //list courses first
    public Iterable<Course> validCourses(){
        return courseRepository.enrollOrInProgressCourses();
    }
    // then list pending applications of the course
    public Optional<CourseEnrollment> findByCourse(Course course) {
        return courseEnrollmentRepository.findByCourse(course);
    }
    public Set<EnrollmentApplication> listPendingApprovals(CourseEnrollment courseEnrollment) {
        Set<EnrollmentApplication> courseEnrollmentApplications = courseEnrollment.enrollmentApplications();
        Set<EnrollmentApplication> pendingApplications = new HashSet<>();
        for (EnrollmentApplication enrollmentApplication : courseEnrollmentApplications) {
            if (enrollmentApplication.isPending())
                pendingApplications.add(enrollmentApplication);
        }
        return pendingApplications;
    }
    // then list the info of the selected application
    public List<String> enrollmentApplicationInfo(CourseEnrollment courseEnrollment, EnrollmentApplication enrollmentApplication) {
        return courseEnrollment.info(enrollmentApplication);
    }
    // check if it saves without mentioning the course enrollment directly in the method
    public void processApproval(CourseEnrollment courseEnrollment,EnrollmentApplication enrollmentApplication, boolean approved) {
        if (approved)
            enrollmentApplication.acceptApplication();
        else
            enrollmentApplication.rejectApplication();
        courseEnrollmentRepository.save(courseEnrollment);
    }
}
