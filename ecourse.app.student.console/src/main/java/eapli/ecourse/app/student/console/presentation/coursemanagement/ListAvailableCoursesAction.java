package eapli.ecourse.app.student.console.presentation.coursemanagement;

import eapli.framework.actions.Action;

public class ListAvailableCoursesAction implements Action {
    /**
     * @return
     */
    @Override
    public boolean execute() {
        return new ListAvailableCoursesUI().show();
    }
}
