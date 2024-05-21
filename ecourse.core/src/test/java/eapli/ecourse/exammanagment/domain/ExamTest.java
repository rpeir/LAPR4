package eapli.ecourse.exammanagment.domain;

import eapli.ecourse.coursemanagement.domain.Course;
import eapli.ecourse.question.domain.Question;
import org.junit.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ExamTest {

    private Exam exam;

    private SummativeExamBuilder builder;

    void setUp() {
        builder = new SummativeExamBuilder();
        builder.withTitle("Exam Title");
        builder.withExamHeader("Exam Header", GradeType.NONE, FeedbackType.NONE);
        Set<Question> questions = new HashSet<>();
        Map<Question, Float> questionWeights = new HashMap<>();
        Question q = mock(Question.class);
        questions.add(q);
        questionWeights.put(q, 20f);
        builder.withSection("Section Description", questions, questionWeights);
        Date openDate = new Date(2030, Calendar.JANUARY,10,10,0);
        Date closeDate = new Date(2030,Calendar.JANUARY,10,15,0);
        builder.withOpenDate(openDate);
        builder.withCloseDate(closeDate);
        builder.withCourse(mock(Course.class));
    }

    @Test
    public void ensureOpenDateAreNotNull() {
        setUp();
        builder.withOpenDate(null);
        assertThrows(IllegalArgumentException.class, () -> builder.build());
    }

    @Test
    public void ensureCloseDateAreNotNull() {
        setUp();
        builder.withCloseDate(null);
        assertThrows(IllegalArgumentException.class, () -> builder.build());
    }

    @Test
    public void ensureExamDatesAreValid() {
        setUp();
        builder.withOpenDate(new Date(2030, Calendar.JANUARY,10,10,0));
        builder.withCloseDate(new Date(2030,Calendar.JANUARY,10,15,0));
        builder.build();
    }

    @Test
    public void ensureExamOpenDateIsNotAfterCloseDate() {
        setUp();
        builder.withOpenDate(new Date(2030, Calendar.JANUARY,10,10,0));
        builder.withCloseDate(new Date(2030,Calendar.JANUARY,10,9,0));
        assertThrows(IllegalArgumentException.class, () -> builder.build());
    }

    @Test
    public void ensureExamCloseDateIsNotBeforeOpenDate() {
        setUp();
        builder.withOpenDate(new Date(2030, Calendar.JANUARY,10,11,0));
        builder.withCloseDate(new Date(2030,Calendar.JANUARY,10,10,0));
        assertThrows(IllegalArgumentException.class, () -> builder.build());
    }

    @Test
    public void ensureExamOpenDateIsNotBeforeToday() {
        setUp();
        builder.withOpenDate(new Date(0, Calendar.JANUARY,10,10,0));
        builder.withCloseDate(new Date(2030,Calendar.JANUARY,10,15,0));
        assertThrows(IllegalArgumentException.class, () -> builder.build());
    }

    @Test
    public void ensureTwoExamsAreNotTheSame() {
        setUp();
        // Create a copy of the exam with different attributes
        SummativeExamBuilder copyBuilder = new SummativeExamBuilder();
        copyBuilder.withTitle("Exam Title 2");
        copyBuilder.withExamHeader("Exam Header 2", GradeType.NONE, FeedbackType.NONE);
        Set<Question> questions = new HashSet<>();
        Map<Question, Float> questionWeights = new HashMap<>();
        Question q = mock(Question.class);
        questions.add(q);
        questionWeights.put(q, 20f);
        copyBuilder.withSection("Section Description", questions, questionWeights);
        Date openDate = new Date(2030, Calendar.JANUARY,10,10,0);
        Date closeDate = new Date(2030,Calendar.JANUARY,10,15,0);
        copyBuilder.withOpenDate(openDate);
        copyBuilder.withCloseDate(closeDate);
        copyBuilder.withCourse(mock(Course.class));
        Exam copy = copyBuilder.build();
        Exam exam = builder.build();
        assertFalse(exam.sameAs(copy));
    }

    @Test
    public void ensureExamWithDifferentTitleAreNotTheSame() {
        setUp();
        // Create a copy of the exam with different title
        SummativeExamBuilder copyBuilder = new SummativeExamBuilder();
        copyBuilder.withTitle("Exam Title 2");
        copyBuilder.withExamHeader("Exam Header 2", GradeType.NONE, FeedbackType.NONE);
        Set<Question> questions = new HashSet<>();
        Map<Question, Float> questionWeights = new HashMap<>();
        Question q = mock(Question.class);
        questions.add(q);
        questionWeights.put(q, 20f);
        copyBuilder.withSection("Section Description", questions, questionWeights);
        Date openDate = new Date(2030, Calendar.JANUARY, 10, 10, 0);
        Date closeDate = new Date(2030, Calendar.JANUARY, 10, 15, 0);
        copyBuilder.withOpenDate(openDate);
        copyBuilder.withCloseDate(closeDate);
        copyBuilder.withCourse(mock(Course.class));
        Exam copy = copyBuilder.build();
        Exam exam = builder.build();
        assertFalse(exam.sameAs(copy));
    }


}