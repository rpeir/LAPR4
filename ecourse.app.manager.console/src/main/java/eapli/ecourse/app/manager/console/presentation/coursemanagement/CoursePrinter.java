package eapli.ecourse.app.manager.console.presentation.coursemanagement;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.framework.visitor.Visitor;

public class CoursePrinter implements Visitor<Course> {
    /**
     * @param visitee
     */
    @Override
    public void visit(Course visitee) {
        System.out.printf("%-30s",visitee.identity());

    }
}
