package eapli.ecourse.app.manager.console.presentation.coursemanagement;


import eapli.ecourse.coursemanagement.application.OpenCourseController;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OpenCourseUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(OpenCourseUI.class);

    private OpenCourseController ctrl = new OpenCourseController(AuthzRegistry.authorizationService(), PersistenceContext.repositories().courses());


    @Override
    protected boolean doShow(){
        final Iterable<Course> closedCourses = ctrl.closedCourses();
        if (!closedCourses.iterator().hasNext()) {
            System.out.println("There are no registered Courses.");
        } else {
            final SelectWidget<Course> selector = new SelectWidget<>("Select one of the closed courses:",closedCourses,new CoursePrinter());
            selector.show();
            Course courseToOpen = selector.selectedElement();
            try {
                if (courseToOpen != null){
                    ctrl.openCourse(courseToOpen);
                }
            }catch (ConcurrencyException ex){
                System.out.println("WARNING: It is not possible to open the course because it was changed by another user");
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
