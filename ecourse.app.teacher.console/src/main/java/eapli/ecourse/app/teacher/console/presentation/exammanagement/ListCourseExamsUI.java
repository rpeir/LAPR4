package eapli.ecourse.app.teacher.console.presentation.exammanagement
        ;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagment.application.ListCourseExamsController;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

public class ListCourseExamsUI extends AbstractUI {

    private ListCourseExamsController theController;

    public ListCourseExamsUI() {
        this.theController = new ListCourseExamsController();
    }

    public ListCourseExamsUI(ListCourseExamsController controller) {
        this.theController = controller;
    }
    @Override
    protected boolean doShow() {
        SelectWidget<Course> selector = new SelectWidget<>("Select teacher's course to list the exams", theController.listCourses());
        selector.show();
        if (selector.selectedOption() == 0) return false;
        Course selected = selector.selectedElement();
        ListWidget<Exam> listExams = new ListWidget<>(selected + " exams", theController.listExams(selector.selectedElement()), new ExamPrinter());
        listExams.show();
        return true;
    }

    @Override
    public String headline() {
        return "List Course Exams";
    }

}
