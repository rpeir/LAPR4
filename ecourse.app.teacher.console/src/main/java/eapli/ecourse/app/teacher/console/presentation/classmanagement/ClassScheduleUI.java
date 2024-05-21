package eapli.ecourse.app.teacher.console.presentation.classmanagement;

import eapli.ecourse.classmanagment.application.ClassScheduleController;
import eapli.ecourse.classmanagment.domain.Class;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

public class ClassScheduleUI extends AbstractUI {

    private final ClassScheduleController theController;

    public ClassScheduleUI(ClassScheduleController controller) {
        this.theController = controller;
    }

    public ClassScheduleUI() {
        theController = new ClassScheduleController();
    }
    @Override
    protected boolean doShow() {
        Iterable<Course> tCourses = theController.listCourses();
        if (!tCourses.iterator().hasNext()) {
            System.out.println("There are no courses available");
            return false;
        }
        SelectWidget<Course> selector = new SelectWidget<>("Select teacher course to schedule the class", tCourses);
        selector.show();
        if (selector.selectedOption() == 0) return false;
        Iterable<Class> courseSchedule = theController.courseSchedule(selector.selectedElement());
        if (!courseSchedule.iterator().hasNext()) {
            System.out.println("There are no classes scheduled for this course");
        } else {
            new ListWidget<>("Course schedule:", courseSchedule, new ClassPrinter()).show();
        }
        ClassDataWidget classData = new ClassDataWidget();
        classData.show();
        try {
            boolean toContinue = true;
            if (!theController.checkStudentDisponibility(selector.selectedElement(), classData.getDayOfWeek(), classData.getTimePeriod()))
                toContinue = Console.readBoolean("There are students with classes at the same time. Do you want to continue? (Y/N)");
            if (!toContinue) return false;
            ListWidget<Class> scheduledClasses = new ListWidget<>("Scheduled classes: ", theController.scheduleClass(classData.getTitle(), selector.selectedElement(), classData.getDayOfWeek(), classData.getTimePeriod()), new ClassPrinter()) ;
            scheduledClasses.show();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String headline() {
        return "Recurring Class Schedule";
    }
}
