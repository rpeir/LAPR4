package eapli.ecourse.app.manager.console.courseenrollment;

import eapli.ecourse.courseenrollement.domain.EnrollmentApplication;
import eapli.ecourse.coursemanagement.domain.Course;
import eapli.framework.visitor.Visitor;

public class EnrollmentApplicationPrinter implements Visitor<EnrollmentApplication> {

    /**
     * @param visitee
     */
    @Override
    public void visit(EnrollmentApplication visitee) {
        System.out.printf("%-30s",visitee.identity());

    }
}
