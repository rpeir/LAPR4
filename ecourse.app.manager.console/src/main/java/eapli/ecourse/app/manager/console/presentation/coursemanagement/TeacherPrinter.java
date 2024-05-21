package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.ecourse.teacher.domain.Teacher;
import eapli.framework.visitor.Visitor;

public class TeacherPrinter implements Visitor<Teacher> {
    /**
     * @param visitee
     */
    @Override
    public void visit(Teacher visitee) {
            System.out.printf("%-30s",visitee.identity());
    }
}
