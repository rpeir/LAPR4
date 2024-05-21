package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import eapli.ecourse.questionanswer.domain.SingleChoiceQuestionAnswer;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class SingleChoiceQuestionTest {

    private static final String DEFAULT_THEME = "Theme";
    private static final String DEFAULT_DESCRIPTION = "Question Description";
    private static final float DEFAULT_GRADE = 4.0f;

    private SingleChoiceQuestion setup() {
        Map<String, String> options = Map.of("a", "Option 1", "b", "Option 2", "c", "Option 3");
        return new SingleChoiceQuestion(DEFAULT_THEME,
                DEFAULT_DESCRIPTION, options, "a");
    }

    @Test
    public void ensureCorrectAnswerHasGradeFour() {
        SingleChoiceQuestion question = setup();

        SingleChoiceQuestionAnswer answer = question.answer("a", DEFAULT_GRADE);
        QuestionFeedback feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE, feedback.grade(), 0.00);
    }

    @Test
    public void ensureIncorrectAnswerHasGradeZero() {
        SingleChoiceQuestion question = setup();

        SingleChoiceQuestionAnswer answer = question.answer("b", DEFAULT_GRADE);
        QuestionFeedback feedback = answer.feedback();
        assertEquals(0.0f, feedback.grade(), 0.00);
    }


}