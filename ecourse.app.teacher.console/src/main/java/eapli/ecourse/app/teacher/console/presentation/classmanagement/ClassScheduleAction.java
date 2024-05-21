package eapli.ecourse.app.teacher.console.presentation.classmanagement;

import eapli.framework.actions.Action;

public class ClassScheduleAction implements Action {
    @Override
    public boolean execute() {
        return new ClassScheduleUI().show();
    }
}
