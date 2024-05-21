package eapli.ecourse.app.manager.console.courseenrollment;

import eapli.ecourse.app.manager.console.presentation.coursemanagement.CoursePrinter;
import eapli.ecourse.app.manager.console.presentation.coursemanagement.SetEnrollmentStateUI;
import eapli.ecourse.courseenrollement.application.ApproveRejectApplicationsController;
import eapli.ecourse.courseenrollement.domain.CourseEnrollment;
import eapli.ecourse.courseenrollement.domain.EnrollmentApplication;
import eapli.ecourse.coursemanagement.application.SetEnrollmentStateController;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import static ch.qos.logback.classic.pattern.Util.match;

public class ApproveRejectApplicationUI extends AbstractUI {

    private static final Logger LOGGER = LogManager.getLogger(ApproveRejectApplicationUI.class);
    private ApproveRejectApplicationsController ctrl = new ApproveRejectApplicationsController(AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        String accept = "accept";
        String reject = "reject";
        final Iterable<Course> courses = ctrl.validCourses();
        if (!courses.iterator().hasNext()) {
            System.out.println("There are no open Courses.");
        } else {
            // show the list of courses
            final SelectWidget<Course> selector = new SelectWidget<>("Select one of the courses:",courses,new CoursePrinter());
            selector.show();
            // get the selected course
            Course course = selector.selectedElement();
            // get the course enrollment of the selected course
            Optional<CourseEnrollment> option = ctrl.findByCourse(course);
            if (option.isEmpty()){throw new IllegalArgumentException("The course does not have an enrollment yet");};
            CourseEnrollment courseEnrollment = option.get();
            final Iterable<EnrollmentApplication> enrollmentApplications = ctrl.listPendingApprovals(courseEnrollment);
            // show the list of pending applications of the selected course
            final SelectWidget<EnrollmentApplication> applications = new SelectWidget<>("Select one of the pending applications:",enrollmentApplications,new EnrollmentApplicationPrinter());
            applications.show();
            EnrollmentApplication application = applications.selectedElement();
            // show the list of states to select
            final SelectWidget<String> status = new SelectWidget<>("Select the action:", Set.of(accept,reject));
            status.show();
            try {
                if (application != null && accept.equals(status.selectedElement())){
                    // change the status of the selected application
                    ctrl.processApproval(courseEnrollment, application, true);
                }else if (application != null && reject.equals(status.selectedElement())){
                    // change the status of the selected application
                    ctrl.processApproval(courseEnrollment, application, false);
                }
            }catch (ConcurrencyException ex){
                System.out.println("WARNING: It is not possible to edit the course details because it was changed by another user");
            } catch (final IntegrityViolationException ex) {
                LOGGER.error("Error performing the operation", ex);
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Approve/Reject Student Enrollment Application";
    }
}
