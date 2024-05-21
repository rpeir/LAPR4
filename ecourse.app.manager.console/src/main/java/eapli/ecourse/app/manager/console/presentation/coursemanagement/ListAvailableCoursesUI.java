package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.ecourse.coursemanagement.application.ListAvailableCoursesController;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;

public class ListAvailableCoursesUI extends AbstractUI {

    private ListAvailableCoursesController ctrl = new ListAvailableCoursesController(PersistenceContext.repositories().courses(), AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow(){
        final Iterable<Course> openCourses = ctrl.findAll();
        if (!openCourses.iterator().hasNext()) {
            System.out.println("There are no registered Courses.");
        } else {
            ListWidget<Course> listWidget = new ListWidget<>("Available Courses:", openCourses,new CoursePrinter());
            listWidget.show();

        }
        return true;
    }

    /**
     * @return
     */
    @Override
    public String headline() {
        return "List Available Courses";
    }
}
