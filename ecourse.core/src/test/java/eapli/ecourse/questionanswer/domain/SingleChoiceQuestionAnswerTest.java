package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.SingleChoiceQuestion;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class SingleChoiceQuestionAnswerTest {

    private final SingleChoiceQuestion question = mock(SingleChoiceQuestion.class);

    private final QuestionFeedback feedback = mock(QuestionFeedback.class);

    @Test
    public void ensureCanNotBeCreatedWithNullAnswer() {
        assertThrows(IllegalArgumentException.class, () -> new SingleChoiceQuestionAnswer(question, feedback, null));
    }

    @Test
    public void ensureCanNotBeCreatedWithEmptyAnswer() {
        assertThrows(IllegalArgumentException.class, () -> new SingleChoiceQuestionAnswer(question, feedback, ""));
    }

    @Test
    public void ensureCanNotBeCreatedWithNullQuestion() {
        assertThrows(IllegalArgumentException.class, () -> new SingleChoiceQuestionAnswer(null, feedback, "answer"));
    }

    @Test
    public void ensureCanNotBeCreatedWithNullFeedback() {
        assertThrows(IllegalArgumentException.class, () -> new SingleChoiceQuestionAnswer(question, null, "answer"));
    }

    @Test
    public void ensureCanBeCreatedWithValidParameters() {
        new SingleChoiceQuestionAnswer(question, feedback, "answer");
    }
}