package eapli.ecourse.examExecution.domain;

import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.questionanswer.domain.QuestionAnswer;
import eapli.ecourse.student.domain.Student;
import eapli.framework.util.Factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExamExecutionBuilder implements Factory<ExamExecution> {

    private final Calendar beginDate = Calendar.getInstance();

    private List<QuestionAnswer> questionAnswers = new ArrayList<>();

    private Student student;

    private Exam exam;

    public ExamExecutionBuilder() {}

    public ExamExecutionBuilder ofStudent(Student student) {
        this.student = student;
        return this;
    }

    public ExamExecutionBuilder withQuestionAnswer(QuestionAnswer qa) {
        this.questionAnswers.add(qa);
        return this;
    }

    public ExamExecutionBuilder ofExam(Exam exam) {
        this.exam = exam;
        return this;
    }

    @Override
    public ExamExecution build() {
        return new ExamExecution(beginDate, student, exam, questionAnswers);
    }
}
