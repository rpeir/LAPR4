package eapli.ecourse.app.teacher.console.presentation.coursemanagement;

import eapli.framework.actions.Action;

public class ListAvailableCoursesAction implements Action {

    @Override
    public boolean execute() {
        return new ListAvailableCoursesUI().show();
    }
}
