package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.framework.actions.Action;

public class OpenCourseAction implements Action {

    @Override
    public boolean execute() {
        return new OpenCourseUI().show();
    }
}
