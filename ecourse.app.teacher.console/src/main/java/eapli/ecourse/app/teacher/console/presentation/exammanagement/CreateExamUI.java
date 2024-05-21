package eapli.ecourse.app.teacher.console.presentation.exammanagement;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagment.application.CreateExamController;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.exammanagment.domain.FeedbackType;
import eapli.ecourse.exammanagment.domain.GradeType;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.Date;

public class CreateExamUI extends AbstractUI {

    private CreateExamController theController;

    public CreateExamUI() {
        this.theController = new CreateExamController();
    }

    public CreateExamUI(CreateExamController controller) {
        this.theController = controller;
    }

    @Override
    protected boolean doShow() {
        Iterable<Course> tCourses = theController.listCourses();
        if (!tCourses.iterator().hasNext()) {
            System.out.println("There are no courses available");
            return false;
        }
        SelectWidget<Course> selector = new SelectWidget<>("Select teacher course to create the exam", tCourses);
        selector.show();
        if (selector.selectedOption() == 0) return false;
        Date open = Console.readDate("Insert the date and time of the exam opening (dd-MM-yyyy HH:mm)", "dd-MM-yyyy HH:mm");
        Date close = Console.readDate("Insert the date and time of the exam closing (dd-MM-yyyy HH:mm)", "dd-MM-yyyy HH:mm");
        String filePath = Console.readLine("Insert the path of the exam file");
        try {
            Exam exam = theController.createExam(filePath, selector.selectedElement(), open, close);
            System.out.println("Exam created successfully!");
            return true;
        } catch (NoSuchFileException e) {
            System.out.printf("No such file \"%s\"!\n",e.getFile());
            return false;
        } catch (Exception e) {
            System.out.println("Error creating exam!");
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public String headline() {
        return "Create Exam";
    }
}
