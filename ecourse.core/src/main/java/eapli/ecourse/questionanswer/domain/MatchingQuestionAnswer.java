package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.MatchingQuestion;
import eapli.framework.validations.Preconditions;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

@Entity
public class MatchingQuestionAnswer extends QuestionAnswer<Map<String,Integer>, MatchingQuestion> {
    @ElementCollection
    private Map<String, Integer> mqAnswer;

    protected MatchingQuestionAnswer() {
        // for ORM only
    }

    public MatchingQuestionAnswer(MatchingQuestion question, QuestionFeedback feedback, Map<String,Integer> answer) {
        super(question, feedback);
        Preconditions.nonNull(answer, "Question answer's answer should not be null");
        Preconditions.nonEmpty(answer.values(), "Question answer's answers should not be empty");
        this.mqAnswer = answer;
    }

    @Override
    public Map<String, Integer> answer() {
        return new HashMap<>(mqAnswer);
    }

}
