package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.TrueOrFalseQuestion;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class TrueOrFalseQuestionAnswerTest {

    private final TrueOrFalseQuestion question = mock(TrueOrFalseQuestion.class);

    private final QuestionFeedback feedback = mock(QuestionFeedback.class);
    @Test
    public void ensureCanNotBeCreatedWithNullQuestion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrueOrFalseQuestionAnswer(null, feedback, true);
        });
    }

    @Test
    public void ensureCanNotBeCreatedWithNullFeedback() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TrueOrFalseQuestionAnswer(question, null, true);
        });
    }

    @Test
    public void ensureCanBeCreatedWithValidParameters() {
        new TrueOrFalseQuestionAnswer(question, feedback, true);
    }

}