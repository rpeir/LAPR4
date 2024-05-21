package eapli.ecourse.app.teacher.console.presentation.exammanagement;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.exammanagment.application.CreateFormativeExamController;
import eapli.ecourse.exammanagment.domain.Exam;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.nio.file.NoSuchFileException;


public class CreateFormativeExamUI extends AbstractUI {

    private CreateFormativeExamController theController;

    public CreateFormativeExamUI() {
        this.theController = new CreateFormativeExamController();
    }

    public CreateFormativeExamUI(CreateFormativeExamController controller) {
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
        String filePath = Console.readLine("Insert the path of the exam file");
        try {
            Exam exam = theController.createExam(filePath, selector.selectedElement());
            System.out.println("Exam created successfully!");
            return true;
        } catch (NoSuchFileException e) {
            System.out.println("File not found!");
            return false;
        } catch (Exception e) {
            System.out.println("Error creating exam!");
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String headline() {
        return "Create Formative Exam";
    }
}
