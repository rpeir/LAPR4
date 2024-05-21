package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.NumericalQuestionAnswer;
import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumericalQuestionTest {

    private final static String DEFAULT_THEME = "THEME";
    private final static String DEFAULT_DESCRIPTION = "DESCRIPTION";
    private final static int DEFAULT_SOLUTION = 10;
    private final static int DEFAULT_ACCEPTANCE_ERROR = 1;
    private final static float DEFAULT_GRADE = 4.0f;

    private NumericalQuestion setup() {
        return new NumericalQuestion(DEFAULT_THEME, DEFAULT_DESCRIPTION,
                DEFAULT_SOLUTION, DEFAULT_ACCEPTANCE_ERROR);
    }

    @Test
    public void ensureCorrectAnswerIsCorrect() {
        NumericalQuestion question = setup();

        NumericalQuestionAnswer answer = question.answer(DEFAULT_SOLUTION, DEFAULT_GRADE);

        QuestionFeedback feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE, feedback.grade(), 0.0);
    }

    @Test
    public void ensureAnswerWithWrongSolutionIsWrong() {
        NumericalQuestion question = setup();

        NumericalQuestionAnswer answer = question.answer(DEFAULT_SOLUTION + DEFAULT_ACCEPTANCE_ERROR + 1, DEFAULT_GRADE);

        QuestionFeedback feedback = answer.feedback();
        assertEquals(0.0f, feedback.grade(), 0.0);
    }

    @Test
    public void ensureAnswerWithAcceptedSolutionIsCorrect() {
        NumericalQuestion question = setup();

        NumericalQuestionAnswer answer = question.answer(DEFAULT_SOLUTION + DEFAULT_ACCEPTANCE_ERROR, DEFAULT_GRADE);

        QuestionFeedback feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE, feedback.grade(), 0.0);

        answer = question.answer(DEFAULT_SOLUTION - DEFAULT_ACCEPTANCE_ERROR, DEFAULT_GRADE);
        feedback = answer.feedback();
        assertEquals(DEFAULT_GRADE, feedback.grade(), 0.0);
    }

}