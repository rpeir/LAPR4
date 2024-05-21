package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.MatchingQuestionAnswer;
import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MatchingQuestionTest {

    private static final String DEFAULT_QUESTION_THEME = "THEME";
    private static final String DEFAULT_QUESTION_DESCRIPTION = "DESCRIPTION";
    private static final float DEFAULT_QUESTION_GRADE = 4f;

    private MatchingQuestion setup() {
        Map<String, String> groupA = new HashMap<>();
        groupA.put("a","Salmon");
        groupA.put("b", "Lion");
        Map<Integer, String> groupB = new HashMap<>();
        groupB.put(1,"Animal");
        groupB.put(2, "Fish");
        Map<String, Integer> solution = new HashMap<>();
        solution.put("a",2);
        solution.put("b",1);

        return new MatchingQuestion(DEFAULT_QUESTION_THEME,
                DEFAULT_QUESTION_DESCRIPTION, groupA, groupB, solution);
    }

    @Test
    public void ensureWrongAnswerHasGradeZero() {
        MatchingQuestion question = setup();

        Map<String, Integer> answer = new HashMap<>();
        answer.put("a",1);
        answer.put("b",2);

        MatchingQuestionAnswer mqAnswer = question.answer(answer, DEFAULT_QUESTION_GRADE);
        QuestionFeedback feedback = mqAnswer.feedback();

        assertEquals(0f, feedback.grade(), 0f);
    }

    @Test
    public void ensureCorrectAnswerHasGradeFour() {
        MatchingQuestion question = setup();

        MatchingQuestionAnswer mqAnswer = question.answer(new HashMap<>(question.solution()), DEFAULT_QUESTION_GRADE);
        QuestionFeedback feedback = mqAnswer.feedback();

        assertEquals(DEFAULT_QUESTION_GRADE, feedback.grade(), 0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAnswerWithTooMuchAnswersFail() {
        MatchingQuestion question = setup();

        Map<String, Integer> answer = new HashMap<>();
        answer.put("a",2);
        answer.put("b",1);
        answer.put("c",1);

        question.answer(answer, DEFAULT_QUESTION_GRADE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAnswerWithTooFewAnswersFail() {
        MatchingQuestion question = setup();

        Map<String, Integer> answer = new HashMap<>();
        answer.put("a",2);

        question.answer(answer, DEFAULT_QUESTION_GRADE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEmptyAnswerFails() {
        MatchingQuestion question = setup();

        Map<String, Integer> answer = new HashMap<>();

        question.answer(answer, DEFAULT_QUESTION_GRADE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNullAnswerFails() {
        MatchingQuestion question = setup();

        question.answer(null, DEFAULT_QUESTION_GRADE);
    }

    @Test
    public void ensureMatchingQuestionAnswerSameAs() {
        MatchingQuestion question = setup();

        Map<String, Integer> answer = new HashMap<>();
        answer.put("a", 2);
        answer.put("b", 1);

        float grade = 4.0f;

        MatchingQuestionAnswer mqAnswer1 = question.answer(answer, grade);
        MatchingQuestionAnswer mqAnswer2 = question.answer(answer, grade);

        assertTrue(mqAnswer1.sameAs(mqAnswer2));
        assertTrue(mqAnswer2.sameAs(mqAnswer1));

        Map<String, Integer> answer2 = new HashMap<>();
        answer2.put("a", 1);
        answer2.put("b", 1);

        float grade2 = 0.0f;

        MatchingQuestionAnswer mqAnswer2_1 = question.answer(answer2, grade2);
        MatchingQuestionAnswer mqAnswer2_2 = question.answer(answer2, grade2);

        assertTrue(mqAnswer2_1.sameAs(mqAnswer2_2));
        assertTrue(mqAnswer2_2.sameAs(mqAnswer2_1));
    }

    @Test
    public void ensureMatchingQuestionSameAs() {
        MatchingQuestion question = setup();
        MatchingQuestion question2 = setup();

        assertTrue(question.sameAs(question2));
        assertTrue(question2.sameAs(question));
    }

    @Test
    public void ensureMatchingQuestionSameAsNull() {
        MatchingQuestion question = setup();

        assertFalse(question.sameAs(null));
    }

}