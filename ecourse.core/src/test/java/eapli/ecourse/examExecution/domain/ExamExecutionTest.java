package eapli.ecourse.examExecution.domain;

import eapli.ecourse.exammanagment.domain.Exam;
import eapli.ecourse.question.domain.Question;
import eapli.ecourse.questionanswer.domain.QuestionAnswer;
import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import eapli.ecourse.student.domain.Student;
import org.junit.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExamExecutionTest {

    private Student student1;
    private Exam exam1;
    private List<QuestionAnswer> questionAnswers;
    private ExamExecution examExecution1;
    private ExamExecution examExecution2;


    @Before
    public void setUp() {
        student1 = mock(Student.class);
        exam1 = mock(Exam.class);
        Exam exam2 = mock(Exam.class);

        Question question1 = mock(Question.class);
        Question question2 = mock(Question.class);

        QuestionAnswer questionAnswer1 = mock(QuestionAnswer.class);
        QuestionFeedback questionFeedback = mock(QuestionFeedback.class);
        when(questionFeedback.feedback()).thenReturn("Feedback1");
        when(questionFeedback.grade()).thenReturn(10F);
        when(questionAnswer1.feedback()).thenReturn(questionFeedback);
        when(questionAnswer1.question()).thenReturn(question1);

        QuestionAnswer questionAnswer2 = mock(QuestionAnswer.class);
        QuestionFeedback questionFeedback2 = mock(QuestionFeedback.class);
        when(questionFeedback2.feedback()).thenReturn("Feedback2");
        when(questionFeedback2.grade()).thenReturn(0F);
        when(questionAnswer2.feedback()).thenReturn(questionFeedback2);
        when(questionAnswer2.question()).thenReturn(question2);
        questionAnswers = new ArrayList<>();
        questionAnswers.add(questionAnswer1);
        questionAnswers.add(questionAnswer2);

        examExecution1 = new ExamExecution(Calendar.getInstance(), student1, exam1, questionAnswers);

        examExecution2 = new ExamExecution(Calendar.getInstance(), student1, exam2, questionAnswers);
    }

    @Test
    public void calculateGrade() {
        Assert.assertEquals(10F, examExecution1.calculateGrade(), 0.01);
        Assert.assertNotEquals(5F, examExecution1.calculateGrade(), 0.01);
    }

    @Test
    public void equalsTest() {
        Assert.assertEquals(examExecution1, examExecution1);
        Assert.assertNotEquals(null, examExecution1);
        Assert.assertNotEquals(examExecution1, new Object());
        Assert.assertNotEquals(examExecution1, examExecution2);
    }

    @Test
    public void ensureExamExecutionIsNotCreatedWithNullBeginDate() {
        assertThrows(IllegalArgumentException.class, () -> new ExamExecution(null, student1, exam1, questionAnswers));
    }

    @Test
    public void ensureExamExecutionIsNotCreatedWithNullStudent() {
        assertThrows(IllegalArgumentException.class, () -> new ExamExecution(Calendar.getInstance(), null, exam1, questionAnswers));
    }

    @Test
    public void ensureExamExecutionIsNotCreatedWithNullExam() {
        assertThrows(IllegalArgumentException.class, () -> new ExamExecution(Calendar.getInstance(), student1, null, questionAnswers));
    }

    @Test
    public void feedback() {
        Assert.assertEquals("Question: null\nFeedback1\n\nQuestion: null\nFeedback2\n\n", examExecution1.feedback());
        Assert.assertNotEquals("Test", examExecution1.feedback());
    }
}