package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.ecourse.coursemanagement.application.RegisterCourseController;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class RegisterCourseUI extends AbstractUI {
    private RegisterCourseController ctrl = new RegisterCourseController(AuthzRegistry.authorizationService(), PersistenceContext.repositories().courses());

    @Override
    protected boolean doShow() {
        String courseCode = Console.readLine("Insert course code:");
        String courseTitle = Console.readLine("Insert course title:");
        String description = Console.readLine("Insert course description:");
        int minStudent = Console.readInteger("Insert the minimum number of student:");
        int maxStudent = Console.readInteger("Insert the maximum number of student:");
        String closeDate = Console.readLine("Insert date on dd-mm-yyyy format.");

        try {
            this.ctrl.registerCourse(courseCode,courseTitle,description,minStudent,maxStudent,closeDate);
            System.out.println("Congratulations,you create a course Successfully!");
        }catch ( IntegrityViolationException e){
            System.out.println("Arguments are already in use.");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Register Course";
    }
}
