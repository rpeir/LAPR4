package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.MatchingQuestion;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MatchingQuestionAnswerTest {

    private final MatchingQuestion QUESTION = mock(MatchingQuestion.class);

    private final QuestionFeedback FEEDBACK = mock(QuestionFeedback.class);

    @Test
    public void ensureCanNotBeCreatedWithNullAnswer() {
        assertThrows(IllegalArgumentException.class, () -> new MatchingQuestionAnswer(QUESTION, FEEDBACK, null));
    }

    @Test
    public void ensureCanNotBeCreatedWithEmptyAnswer() {
        assertThrows(IllegalArgumentException.class, () -> new MatchingQuestionAnswer(QUESTION, FEEDBACK, new HashMap<>()));
    }

    @Test
    public void ensureCanNotBeCreatedWithNullQuestion() {
        assertThrows(IllegalArgumentException.class, () -> new MatchingQuestionAnswer(null, FEEDBACK, new HashMap<>()));
    }

    @Test
    public void ensureCanNotBeCreatedWithNullFeedback() {
        assertThrows(IllegalArgumentException.class, () -> new MatchingQuestionAnswer(QUESTION, null, new HashMap<>()));
    }


    @Test
    public void ensureCanBeCreatedWithValidParameters() {
        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("a", 1);
        new MatchingQuestionAnswer(QUESTION, FEEDBACK, answer);
    }
}