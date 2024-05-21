package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.framework.actions.Action;

public class ListAvailableCourseAction implements Action {
    /**
     * @return
     */
    @Override
    public boolean execute() {
        return new ListAvailableCoursesUI().show();
    }
}
