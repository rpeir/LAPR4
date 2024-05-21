package eapli.ecourse.app.student.console.presentation.exammanagement;

import eapli.ecourse.app.student.console.presentation.courseenrollment.RequestEnrollmentCourseUI;
import eapli.framework.actions.Action;

public class ListFutureExamsAction implements Action {
    /**
     * @return
     */
    @Override
    public boolean execute() {
        return new ListFutureExamsUI().show();
    }
}
