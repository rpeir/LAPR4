package eapli.ecourse.app.student.console.presentation.coursemanagement;

import eapli.ecourse.examExecution.domain.ExamExecution;
import eapli.ecourse.exammanagment.application.ListStudentGradesController;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;

public class ListStudentGradesUI extends AbstractUI {

    private ListStudentGradesController controller = new ListStudentGradesController();
    @Override
    protected boolean doShow() {
        ListWidget<ExamExecution> listStudentGrades = new ListWidget<>("Student Grades", controller.listStudentGrades());
        listStudentGrades.show();
        return true;
    }

    @Override
    public String headline() {
        return "List Student Grades";
    }
}
