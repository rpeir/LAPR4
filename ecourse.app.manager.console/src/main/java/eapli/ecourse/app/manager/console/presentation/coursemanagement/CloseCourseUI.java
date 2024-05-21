package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.ecourse.coursemanagement.application.CloseCourseController;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CloseCourseUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(CloseCourseUI.class);

    private CloseCourseController ctrl = new CloseCourseController(AuthzRegistry.authorizationService(), PersistenceContext.repositories().courses());


    @Override
    protected boolean doShow(){
        final Iterable<Course> openCourses = ctrl.openCourses();
        if (!openCourses.iterator().hasNext()) {
            System.out.println("There are no registered Courses.");
        } else {
            final SelectWidget<Course> selector = new SelectWidget<>("Select one of the open courses:",openCourses,new CoursePrinter());
            selector.show();
            Course courseToClose = selector.selectedElement();
            try {
                if (courseToClose != null){
                    ctrl.closeCourse(courseToClose);
                }
            }catch (ConcurrencyException ex){
                System.out.println("WARNING: It is not possible to close the course because it was changed by another user");
            } catch (final IntegrityViolationException ex) {
                LOGGER.error("Error performing the operation", ex);
                System.out.println("Unfortunatelly there was an unexpected error in the application. Please try again and if the problem persists, contact your system admnistrator.");
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Open Courses";
    }

}
