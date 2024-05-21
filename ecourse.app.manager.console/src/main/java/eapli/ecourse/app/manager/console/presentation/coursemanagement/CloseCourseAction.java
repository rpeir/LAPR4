package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.framework.actions.Action;

public class CloseCourseAction implements Action {
    /**
     * @return
     */
    @Override
    public boolean execute() {
       return new CloseCourseUI().show();
    }
}
