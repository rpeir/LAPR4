package eapli.ecourse.app.student.console.presentation.examExecution;

import eapli.framework.actions.Action;

public class TakeExamAction implements Action {
    @Override
    public boolean execute() {
        return new TakeExamUI().doShow();
    }
}
