package eapli.ecourse.app.teacher.console.presentation.questionmanagement;

import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.question.application.CreateQuestionController;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;


public class CreateQuestionUI extends AbstractUI {
    private final CreateQuestionController ctrl = new CreateQuestionController(AuthzRegistry.authorizationService(), PersistenceContext.repositories().questions());

    @Override
    protected boolean doShow() {
        String filePath = Console.readLine("Insert the path of the question file. Attention the questions have to follow the specific grammar.");
        try {
            ctrl.createQuestions(filePath);
            System.out.println("Questions created successfully!");
            return true;
        } catch (Exception e) {
            System.out.println("Error creating questions!");
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @return
     */
    @Override
    public String headline() {
        return "Create Questions";
    }

}
