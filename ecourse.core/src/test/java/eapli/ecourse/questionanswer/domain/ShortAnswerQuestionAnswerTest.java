package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.ShortAnswerQuestion;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ShortAnswerQuestionAnswerTest {

    private final ShortAnswerQuestion question = mock(ShortAnswerQuestion.class);

    private final QuestionFeedback feedback = mock(QuestionFeedback.class);

    @Test
    public void ensureCanNotBeCreatedWithNullAnswer() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ShortAnswerQuestionAnswer(question, feedback, null);
        });
    }

    @Test
    public void ensureCanNotBeCreatedWithEmptyAnswer() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ShortAnswerQuestionAnswer(question, feedback, "");
        });
    }

    @Test
    public void ensureCanNotBeCreatedWithNullQuestion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ShortAnswerQuestionAnswer(null, feedback, "answer");
        });
    }

    @Test
    public void ensureCanNotBeCreatedWithNullFeedback() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ShortAnswerQuestionAnswer(question, null, "answer");
        });
    }

    @Test
    public void ensureCanBeCreatedWithValidParameters() {
        new ShortAnswerQuestionAnswer(question, feedback, "answer");
    }

}