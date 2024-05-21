package eapli.ecourse.app.teacher.console.presentation.questionmanagement;

import eapli.framework.actions.Action;

public class CreateQuestionAction implements Action {
    /**
     * @return
     */
    @Override
    public boolean execute() {
        return new CreateQuestionUI().show();
    }
}
