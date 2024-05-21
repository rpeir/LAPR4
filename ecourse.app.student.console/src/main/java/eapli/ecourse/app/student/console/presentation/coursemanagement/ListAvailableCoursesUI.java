package eapli.ecourse.app.student.console.presentation.coursemanagement;

import eapli.ecourse.coursemanagement.application.ListAvailableCoursesController;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;

public class ListAvailableCoursesUI extends AbstractUI {

    private ListAvailableCoursesController ctrl = new ListAvailableCoursesController(PersistenceContext.repositories().courses(), AuthzRegistry.authorizationService(),PersistenceContext.repositories().courseEnrollments());

    /**
     * @return
     */
    @Override
    protected boolean doShow() {
        final Iterable<Course> availableCoursesStudent = ctrl.availableCoursesStudent();
        if (!availableCoursesStudent.iterator().hasNext()) {
            System.out.println("There are no Courses available for enrollments.");
        } else {
            ListWidget<Course> listWidget = new ListWidget<>("Courses you can apply for:", availableCoursesStudent,new CoursePrinter());
            listWidget.show();
        }

        final Iterable<Course> coursesImEnrolled = ctrl.coursesImEnrolled();
        if (!coursesImEnrolled.iterator().hasNext()) {
            System.out.println("You are not enrolled in any course");
        } else {
            ListWidget<Course> listWidget = new ListWidget<>("Courses that you are enrolled:", coursesImEnrolled,new CoursePrinter());
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
