package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.ecourse.coursemanagement.application.SetEnrollmentStateController;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Set;

/**
 * UI for changing the enrollment state of a course
 *
 * NOTE: this class is in the manager.console project because it is a manager
 * functionality. If it was a regular user functionality, it would be in the
 * app.user.console project.
 */
public class SetEnrollmentStateUI extends AbstractUI {

    private static final Logger LOGGER = LogManager.getLogger(SetEnrollmentStateUI.class);
    private SetEnrollmentStateController ctrl = new SetEnrollmentStateController(AuthzRegistry.authorizationService());

    /**
     * @return
     */
    @Override
    protected boolean doShow(){
        final Iterable<Course> courses = ctrl.allCourses();
        if (!courses.iterator().hasNext()) {
            System.out.println("There are no registered Courses.");
        } else {
            // show the list of courses
            final SelectWidget<Course> selector = new SelectWidget<>("Select one of the courses:",courses,new CoursePrinter());
            selector.show();
            // get the selected course
            Course course = selector.selectedElement();
            // show the list of states to select
            final SelectWidget<String> state = new SelectWidget<>("Select the enrollment state:", Set.of("open enrollments","close enrollments"));
            state.show();
            try {
                if (course != null){
                    // change the enrollment state of the selected course
                    ctrl.changeEnrollmentState(state.selectedElement(),course);
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
        return "Open/Close Enrollments in Course";
    }
}
