package eapli.ecourse.app.teacher.console.presentation.exammanagement;

import eapli.framework.actions.Action;

public class ListCourseExamsAction implements Action {

        @Override
        public boolean execute() {
            return new ListCourseExamsUI().show();
        }
}
