package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.framework.actions.Action;

public class SetEnrollmentStateAction implements Action {
    /**
     * @return
     */
    @Override
    public boolean execute() {
        return new SetEnrollmentStateUI().show();
    }
}
