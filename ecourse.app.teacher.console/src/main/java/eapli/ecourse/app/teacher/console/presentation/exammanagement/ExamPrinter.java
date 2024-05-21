package eapli.ecourse.app.teacher.console.presentation.exammanagement;

import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.exammanagment.domain.SummativeExam;
import eapli.framework.visitor.Visitor;

public class ExamPrinter implements Visitor<Exam>{
    /**
     * @param visitee
     */
    @Override
    public void visit(Exam visitee) {
        if (visitee instanceof SummativeExam) {
            SummativeExam s = (SummativeExam) visitee;
            System.out.printf("%s (%s : %s)", s.title(), s.openDate(), s.closeDate());
        } else {
            System.out.printf("%s, Formative", visitee.title());
        }
    }
}
