package eapli.ecourse.app.manager.console.courseenrollment;

import eapli.framework.actions.Action;

public class ApproveRejectApplicationAction implements Action {
    /**
     * @return
     */
    @Override
    public boolean execute() {
        return new ApproveRejectApplicationUI().show();
    }
}
