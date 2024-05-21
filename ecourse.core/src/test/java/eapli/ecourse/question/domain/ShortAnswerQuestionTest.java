package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import eapli.ecourse.questionanswer.domain.ShortAnswerQuestionAnswer;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ShortAnswerQuestionTest {

    private static final String DEFAULT_THEME = "THEME";
    private static final String DEFAULT_DESCRIPTION = "DESCRIPTION";
    private static final float DEFAULT_GRADE = 4.0f;
    private ShortAnswerQuestion setup() {
        Map<String, Integer> solution = new HashMap<>();
        solution.put("Test*", 100);
        solution.put("T*", 50);
        solution.put("*", 0);
        return new ShortAnswerQuestion(DEFAULT_THEME, DEFAULT_DESCRIPTION, solution);
    }

    @Test
    public void ensurePhrasesWithWildcardsAreCorrectlyMatched() {
        ShortAnswerQuestion question = setup();

        ShortAnswerQuestionAnswer answer = question.answer("Test", DEFAULT_GRADE);
        QuestionFeedback feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE, feedback.grade(), 0.00);

        answer = question.answer("Test hello", DEFAULT_GRADE);
        feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE, feedback.grade(), 0.00);

        answer = question.answer("To", DEFAULT_GRADE);
        feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE/2, feedback.grade(), 0.00);

        answer = question.answer("Tes", DEFAULT_GRADE);
        feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE/2, feedback.grade(), 0.00);
    }

    @Test
    public void ensurePhrasesWithWrongWildcardsAreNotMatched() {
        ShortAnswerQuestion question = setup();

        ShortAnswerQuestionAnswer answer = question.answer("hello", DEFAULT_GRADE);
        QuestionFeedback feedback = answer.feedback();
        assertEquals(0, feedback.grade(), 0.00);

        answer = question.answer("t", DEFAULT_GRADE);
        feedback = answer.feedback();
        assertEquals(0, feedback.grade(), 0.00);
    }

    @Test
    public void ensureSimilarPossibleAnswersAreCorrectlyGraded() {
        ShortAnswerQuestion question = setup();

        ShortAnswerQuestionAnswer answer = question.answer("Test", DEFAULT_GRADE);
        QuestionFeedback feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE, feedback.grade(), 0.00);

        answer = question.answer("Test hello", DEFAULT_GRADE);
        feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE, feedback.grade(), 0.00);
    }

}