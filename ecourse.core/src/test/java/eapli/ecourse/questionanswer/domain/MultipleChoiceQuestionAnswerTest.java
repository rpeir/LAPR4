package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.MultipleChoiceQuestion;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

public class MultipleChoiceQuestionAnswerTest {

    private final MultipleChoiceQuestion question = mock(MultipleChoiceQuestion.class);

    private final QuestionFeedback feedback = mock(QuestionFeedback.class);

    @Test
    public void ensureCanNotBeCreatedWithNullAnswer() {
        assertThrows(IllegalArgumentException.class, () -> new MultipleChoiceQuestionAnswer(question, feedback, null));
    }

    @Test
    public void ensureCanNotBeCreatedWithEmptyAnswer() {
        assertThrows(IllegalArgumentException.class, () -> new MultipleChoiceQuestionAnswer(question, feedback, new HashSet<>()));
    }

    @Test
    public void ensureCanNotBeCreatedWithNullQuestion() {
        assertThrows(IllegalArgumentException.class, () -> new MultipleChoiceQuestionAnswer(null, feedback, new HashSet<>()));
    }

    @Test
    public void ensureCanNotBeCreatedWithNullFeedback() {
        assertThrows(IllegalArgumentException.class, () -> new MultipleChoiceQuestionAnswer(question, null, new HashSet<>()));
    }

    @Test
    public void ensureCanBeCreatedWithValidParameters() {
        Set<String> answer = new HashSet<>();
        answer.add("answer");
        assertDoesNotThrow(() -> new MultipleChoiceQuestionAnswer(question, feedback, answer));
    }

}