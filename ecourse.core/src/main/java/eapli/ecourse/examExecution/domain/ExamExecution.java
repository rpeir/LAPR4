package eapli.ecourse.examExecution.domain;

import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.questionanswer.domain.QuestionAnswer;
import eapli.ecourse.student.domain.Student;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "examExecution")
public class ExamExecution implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "examExecutionId")
    private Long examExecutionId;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar beginDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionAnswer> questionAnswers;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Exam exam;

    private Float grade;

    protected ExamExecution(){
        // ORM
    }
    protected ExamExecution(Calendar beginDate, Student student, Exam exam, List<QuestionAnswer> questionAnswers){
        Preconditions.noneNull(beginDate,student,exam);
        this.questionAnswers = questionAnswers;
        this.student= student;
        this.beginDate = beginDate;
        this.exam = exam;
        this.grade = calculateGrade();
    }

    protected Float calculateGrade(){
        float grade = 0f;
        for(QuestionAnswer questionAnswer : this.questionAnswers){
            grade += questionAnswer.feedback().grade();
        }
        return grade;
    }
    public Exam exam(){
        return this.exam;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamExecution examExecution = (ExamExecution) o;
            return Objects.equals(examExecutionId, examExecution.examExecutionId) && Objects.equals(beginDate, examExecution.beginDate) && Objects.equals(questionAnswers, examExecution.questionAnswers) && Objects.equals(student, examExecution.student) && Objects.equals(exam, examExecution.exam) && Objects.equals(grade, examExecution.grade);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return this.examExecutionId;
    }
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        String gradeString = df.format(this.grade);
        return "Exam Execution: " + "student: " + this.student.mechanographicNumber() + " Exam: " + this.exam.toString() + " Date: " + beginDateString() + " Grade: " + gradeString + "\n";
    }
    public String beginDateString() {
        Date date = this.beginDate.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formatter.format(date);
    }
    public Student student() {
        return this.student;
    }

    public float grade() {
        return this.grade;
    }
    public String feedback() {
        StringBuilder sb = new StringBuilder();
        for (QuestionAnswer answer : this.questionAnswers) {
            sb.append("Question: ");
            sb.append(answer.question().questionDescription()).append("\n");
            sb.append(answer.feedback().feedback()).append("\n\n");
        }
        return sb.toString();
    }
}
