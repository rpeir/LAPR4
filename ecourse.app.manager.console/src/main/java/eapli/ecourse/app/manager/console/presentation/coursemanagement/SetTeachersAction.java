package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.framework.actions.Action;

public class SetTeachersAction implements Action {
    /**
     * @return
     */
    @Override
    public boolean execute() {
        return new SetTeachersUI().show();
    }
}
