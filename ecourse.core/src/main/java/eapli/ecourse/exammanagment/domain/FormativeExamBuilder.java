package eapli.ecourse.exammanagment.domain;

public class FormativeExamBuilder extends ExamBuilder {

    @Override
    public Exam build() {
        return new FormativeExam(this.title, this.examHeader, this.sections, this.course);
    }
}
