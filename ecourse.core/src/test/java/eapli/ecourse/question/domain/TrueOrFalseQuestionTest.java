package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import eapli.ecourse.questionanswer.domain.TrueOrFalseQuestionAnswer;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrueOrFalseQuestionTest {

    private static final String DEFAULT_THEME = "Theme";
    private static final String DEFAULT_DESCRIPTION = "Description";
    private static final float DEFAULT_GRADE = 4.0f;

    private TrueOrFalseQuestion setup() {
        return new TrueOrFalseQuestion(DEFAULT_THEME, DEFAULT_DESCRIPTION, "true");
    }

    @Test
    public void ensureCorrectAnswerIsCorrect() {
        TrueOrFalseQuestion question = setup();

        TrueOrFalseQuestionAnswer answer = question.answer(true, DEFAULT_GRADE);
        QuestionFeedback feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE, feedback.grade(), 0.0);
    }

    @Test
    public void ensureIncorrectAnswerIsIncorrect() {
        TrueOrFalseQuestion question = setup();

        TrueOrFalseQuestionAnswer answer = question.answer(false, DEFAULT_GRADE);
        QuestionFeedback feedback = answer.feedback();
        assertEquals(0.0, feedback.grade(), 0.0);
    }

}