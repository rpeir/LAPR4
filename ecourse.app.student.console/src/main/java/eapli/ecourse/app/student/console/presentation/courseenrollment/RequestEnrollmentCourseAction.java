package eapli.ecourse.app.student.console.presentation.courseenrollment;

import eapli.framework.actions.Action;

public class RequestEnrollmentCourseAction implements Action {
    /**
     * @return
     */
    @Override
    public boolean execute() {
        return new RequestEnrollmentCourseUI().show();
    }
}
