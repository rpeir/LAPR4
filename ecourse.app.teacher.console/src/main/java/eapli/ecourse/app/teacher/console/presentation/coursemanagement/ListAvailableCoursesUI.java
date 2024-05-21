package eapli.ecourse.app.teacher.console.presentation.coursemanagement;

import eapli.ecourse.app.teacher.console.presentation.coursemanagement.CoursePrinter;
import eapli.ecourse.coursemanagement.application.ListAvailableCoursesController;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;

public class ListAvailableCoursesUI extends AbstractUI {
    private ListAvailableCoursesController ctrl = new ListAvailableCoursesController(PersistenceContext.repositories().courses(), AuthzRegistry.authorizationService());

    /**
     * @return
     */
    @Override
    protected boolean doShow() {
        final Iterable<Course> availableCoursesStudent = ctrl.availableCoursesTeacher();
        if (!availableCoursesStudent.iterator().hasNext()) {
            System.out.println("There are no available Courses.");
        } else {
            ListWidget<Course> listWidget = new ListWidget<>("Available Courses:", availableCoursesStudent,new CoursePrinter());
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
