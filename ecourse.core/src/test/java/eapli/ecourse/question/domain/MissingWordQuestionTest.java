package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.MissingWordQuestionAnswer;
import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MissingWordQuestionTest {

    private static final String DEFAULT_QUESTION_THEME = "THEME";
    private static final String DEFAULT_QUESTION_DESCRIPTION = "DESCRIPTION";
    private static final float DEFAULT_QUESTION_GRADE = 4f;
    private static final String DEFAULT_MISSING_PHRASE = "MissingPhrase";

    private MissingWordQuestion setup() {
        Map<String, ArrayList<String>> options = new HashMap<>();
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Fish");
        options1.add("Animal");
        options.put("[[A]]", options1);
        ArrayList<String> options2 = new ArrayList<>();
        options2.add("Pink");
        options2.add("Yellow");
        options.put("[[B]]", options2);
        Map<String, String> solutions = new HashMap<>();
        solutions.put("[[A]]", "Fish");
        solutions.put("[[B]]", "Pink");

        return new MissingWordQuestion(
                DEFAULT_QUESTION_THEME, DEFAULT_QUESTION_DESCRIPTION,
                options, solutions, DEFAULT_MISSING_PHRASE);
    }

    @Test
    public void ensureAllWrongAnswerHasGradeZero() {
        MissingWordQuestion question = setup();

        Map<String, String> answer = new HashMap<>();
        answer.put("[[A]]", "Animal");
        answer.put("[[B]]", "Yellow");

        MissingWordQuestionAnswer mwAnswer = question.answer(answer, DEFAULT_QUESTION_GRADE);
        QuestionFeedback feedback = mwAnswer.feedback();

        assertEquals(0f, feedback.grade(), 0f);
    }

    @Test
    public void ensureAllCorrectAnswerHasGradeFour() {
        MissingWordQuestion question = setup();

        MissingWordQuestionAnswer mwAnswer = question.answer(new HashMap<>(question.solution()), DEFAULT_QUESTION_GRADE);
        QuestionFeedback feedback = mwAnswer.feedback();

        assertEquals(DEFAULT_QUESTION_GRADE, feedback.grade(), 0f);
    }

    @Test
    public void ensureOneCorrectAnswerHasGradeTwo() {
        MissingWordQuestion question = setup();

        Map<String, String> answer = new HashMap<>();
        answer.put("[[A]]", "Fish");
        answer.put("[[B]]", "Yellow");

        MissingWordQuestionAnswer mwAnswer = question.answer(answer, DEFAULT_QUESTION_GRADE);
        QuestionFeedback feedback = mwAnswer.feedback();

        assertEquals(DEFAULT_QUESTION_GRADE/2, feedback.grade(), 0f);

        answer = new HashMap<>();
        answer.put("[[A]]", "Animal");
        answer.put("[[B]]", "Pink");

        mwAnswer = question.answer(answer, DEFAULT_QUESTION_GRADE);
        feedback = mwAnswer.feedback();

        assertEquals(DEFAULT_QUESTION_GRADE/2, feedback.grade(), 0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAnswerWithTooMuchAnswersFail() {
        MissingWordQuestion question = setup();

        Map<String, String> answer = new HashMap<>();
        answer.put("[[A]]", "Fish");
        answer.put("[[B]]", "Yellow");
        answer.put("[[C]]", "Pink");

        question.answer(answer, DEFAULT_QUESTION_GRADE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAnswerWithTooFewAnswersFail() {
        MissingWordQuestion question = setup();

        Map<String, String> answer = new HashMap<>();
        answer.put("[[A]]", "Fish");

        question.answer(answer, DEFAULT_QUESTION_GRADE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAnswerWithInvalidAnswersFail() {
        MissingWordQuestion question = setup();

        Map<String, String> answer = new HashMap<>();
        answer.put("[[C]]", "Fish");
        answer.put("[[B]]", "Pink");

        question.answer(answer, DEFAULT_QUESTION_GRADE);
    }

}