package eapli.ecourse.app.student.console.presentation.coursemanagement;

import eapli.framework.actions.Action;

public class ListStudentGradesAction implements Action {

    @Override
    public boolean execute() {
        return new ListStudentGradesUI().show();
    }
}
