package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.NumericalQuestion;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class NumericalQuestionAnswerTest {

    private final NumericalQuestion question = mock(NumericalQuestion.class);

    private final QuestionFeedback feedback = mock(QuestionFeedback.class);

    @Test
    public void ensureCanNotBeCreatedWithNullQuestion() {
        assertThrows(IllegalArgumentException.class, () -> new NumericalQuestionAnswer(null, feedback, 1));
    }

    @Test
    public void ensureCanNotBeCreatedWithNullFeedback() {
        assertThrows(IllegalArgumentException.class, () -> new NumericalQuestionAnswer(question, null, 1));
    }

    @Test
    public void ensureCanBeCreatedWithValidParameters() {
        new NumericalQuestionAnswer(question, feedback, 1);
    }

}