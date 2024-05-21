package eapli.ecourse.app.student.console.presentation.examExecution;

import eapli.ecourse.app.student.console.presentation.StudentBaseUI;
import eapli.ecourse.examExecution.application.TakeExamController;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.exammanagment.domain.SummativeExam;
import eapli.framework.presentation.console.SelectWidget;

import java.util.Date;
import java.util.List;

public class TakeExamUI extends StudentBaseUI {

    private final TakeExamController theController = new TakeExamController();
    @Override
    protected boolean doShow() {
        try {
            Exam exam = selectExam();
            if (exam == null) return false;
            return takeExam(exam);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    private Exam selectExam() {
        List<Exam> exams = theController.availableExams();
        if (exams.isEmpty()) {
            System.out.println("There are no exams available for you to take");
            return null;
        }
        final SelectWidget<Exam> examSelector = new SelectWidget<>("Select an exam to take", exams);
        examSelector.show();
        if (examSelector.selectedOption() == 0) return null;
        return examSelector.selectedElement();
    }

    private boolean takeExam(Exam exam) {
        try {
            Thread t = new Thread(new TakeExamService(exam));
            t.start();
            if (exam instanceof SummativeExam)
                t.join(((SummativeExam) exam).closeDate().getTime() - new Date().getTime());
            else
                t.join();
            return true;
        } catch(InterruptedException e) {
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return false;
        }

    }


}
