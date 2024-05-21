package eapli.ecourse.app.student.console.presentation.courseenrollment;

import eapli.ecourse.app.student.console.presentation.coursemanagement.CoursePrinter;
import eapli.ecourse.courseenrollement.application.RequestEnrollmentCourseController;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestEnrollmentCourseUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(RequestEnrollmentCourseUI.class);
    private RequestEnrollmentCourseController ctrl = new RequestEnrollmentCourseController(AuthzRegistry.authorizationService());

    /**
     * @return
     */
    @Override
    protected boolean doShow() {
        // list available courses first
        final Iterable<Course> availableCoursesStudent = ctrl.availableCourses();
        if (!availableCoursesStudent.iterator().hasNext()) {
            System.out.println("There are no available Courses.");
        } else {
            final SelectWidget<Course> selector = new SelectWidget<>("Select one of the courses:",availableCoursesStudent,new CoursePrinter());
            selector.show();
            Course course = selector.selectedElement();
            try {
                if (course != null){
                    // request enrollment in a course
                    ctrl.addApplication(course);
                }
            }catch (ConcurrencyException ex){
                System.out.println("WARNING: It is not possible to edit the course enrollment details because it was changed by another user");
            } catch (final IntegrityViolationException ex) {
                LOGGER.error("Error performing the operation", ex);
                System.out.println("Unfortunately there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
            }
        }
        return true;
    }

    /**
     * @return
     */
    @Override
    public String headline() {
        return "Request Enrollment in a Course";
    }
}
