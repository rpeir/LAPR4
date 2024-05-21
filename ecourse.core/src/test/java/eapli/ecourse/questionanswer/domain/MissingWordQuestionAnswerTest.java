package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.MissingWordQuestion;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MissingWordQuestionAnswerTest {

    private final MissingWordQuestion QUESTION = mock(MissingWordQuestion.class);

    private final QuestionFeedback FEEDBACK = mock(QuestionFeedback.class);

    @Test
    public void ensureCanNotBeCreatedWithNullAnswer() {
        assertThrows(IllegalArgumentException.class, () -> new MissingWordQuestionAnswer(QUESTION, FEEDBACK, null));
    }

    @Test
    public void ensureCanNotBeCreatedWithEmptyAnswer() {
        assertThrows(IllegalArgumentException.class, () -> new MissingWordQuestionAnswer(QUESTION, FEEDBACK, new HashMap<>()));
    }

    @Test
    public void ensureCanNotBeCreatedWithNullQuestion() {
        assertThrows(IllegalArgumentException.class, () -> new MissingWordQuestionAnswer(null, FEEDBACK, new HashMap<>()));
    }

    @Test
    public void ensureCanNotBeCreatedWithNullFeedback() {
        assertThrows(IllegalArgumentException.class, () -> new MissingWordQuestionAnswer(QUESTION, null, new HashMap<>()));
    }

    @Test
    public void ensureCanBeCreatedWithValidParameters() {
        HashMap<String, String> answer = new HashMap<>();
        answer.put("a", "b");
        new MissingWordQuestionAnswer(QUESTION, FEEDBACK, answer);
    }

}