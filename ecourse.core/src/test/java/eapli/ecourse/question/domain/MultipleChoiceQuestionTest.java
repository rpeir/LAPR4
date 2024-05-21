package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.MultipleChoiceQuestionAnswer;
import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class MultipleChoiceQuestionTest {

    private final static String DEFAULT_THEME = "THEME";
    private final static String DEFAULT_DESCRIPTION = "DESCRIPTION";
    private final static float DEFAULT_GRADE = 4.0f;

    private MultipleChoiceQuestion setUp() {
        Map<String, String> options = Map.of("1", "A", "2", "B", "3", "C");
        Set<String> solution = Set.of("1", "2");

        return new MultipleChoiceQuestion(
                DEFAULT_THEME, DEFAULT_DESCRIPTION, solution,options);
    }

    @Test
    public void ensureCorrectAnswerHasGradeFour() {
        MultipleChoiceQuestion question = setUp();
        Set<String> answer = Set.of("1", "2");

        MultipleChoiceQuestionAnswer questionAnswer = question.answer(answer, DEFAULT_GRADE);

        QuestionFeedback feedback = questionAnswer.feedback();
        assertEquals(DEFAULT_GRADE, feedback.grade(), 0.0f);
    }

    @Test
    public void ensureAllCorrectAnswersButOneWrongHasGradeZero() {
        MultipleChoiceQuestion question = setUp();
        Set<String> answer = Set.of("1","2","3");

        MultipleChoiceQuestionAnswer questionAnswer = question.answer(answer, DEFAULT_GRADE);

        QuestionFeedback feedback = questionAnswer.feedback();
        assertEquals(0.0f, feedback.grade(), 0.0f);
    }

    @Test
    public void ensureOnlyOneCorrectAnswerHasGradeZero() {
        MultipleChoiceQuestion question = setUp();
        Set<String> answer = Set.of("1");

        MultipleChoiceQuestionAnswer questionAnswer = question.answer(answer, DEFAULT_GRADE);

        QuestionFeedback feedback = questionAnswer.feedback();
        assertEquals(0.0f, feedback.grade(), 0.0f);
    }

    @Test
    public void ensureNoCorrectAnswersHasGradeZero() {
        MultipleChoiceQuestion question = setUp();
        Set<String> answer = Set.of("3");

        MultipleChoiceQuestionAnswer questionAnswer = question.answer(answer, DEFAULT_GRADE);

        QuestionFeedback feedback = questionAnswer.feedback();
        assertEquals(0.0f, feedback.grade(), 0.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAnswerWithNullValueThrowsException() {
        MultipleChoiceQuestion question = setUp();

        question.answer(null, DEFAULT_GRADE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAnswerWithEmptyValueThrowsException() {
        MultipleChoiceQuestion question = setUp();

        question.answer(Set.of(), DEFAULT_GRADE);
    }

}