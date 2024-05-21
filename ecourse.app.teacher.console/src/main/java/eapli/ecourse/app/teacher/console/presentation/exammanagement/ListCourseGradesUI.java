package eapli.ecourse.app.teacher.console.presentation.exammanagement;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.examExecution.domain.ExamExecution;
import eapli.ecourse.exammanagment.application.ListCourseGradesController;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ListCourseGradesUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(ListCourseGradesUI.class);
    private ListCourseGradesController controller = new ListCourseGradesController();

    @Override
    protected boolean doShow() {
        //list teacher courses
        final Iterable<Course> courses = controller.findByTeacher();
        if (!courses.iterator().hasNext()) {
            System.out.println("Teacher is not assigned to any course.");
        } else {
            try {
                final SelectWidget<Course> selector = new SelectWidget<>("Select one of the courses:", courses);
                selector.show();
                Course course = selector.selectedElement();
                if (course != null) {
                    // list course grades
                    ListWidget<ExamExecution> listCourseGrades = new ListWidget<>("Course Grades", controller.findByCourse(course));
                    listCourseGrades.show();
                }
            }catch (Exception ex) {
                LOGGER.error("Error performing the operation", ex);
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "List Course Grades";
    }
}