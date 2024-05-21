package eapli.ecourse.app.manager.console.presentation.coursemanagement;


import eapli.framework.actions.Action;

public class RegisterCourseAction implements Action {


    @Override
    public boolean execute() {
        return new RegisterCourseUI().show();
    }
}
