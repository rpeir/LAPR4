package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.MissingWordQuestion;
import eapli.framework.validations.Preconditions;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

@Entity
public class MissingWordQuestionAnswer extends QuestionAnswer<Map<String,String>, MissingWordQuestion> {

    @ElementCollection
    private Map<String, String> mwAnswer;

    protected MissingWordQuestionAnswer() {
        // for ORM only
    }

    public MissingWordQuestionAnswer(MissingWordQuestion question, QuestionFeedback feedback, Map<String,String> answer) {
        super(question, feedback);
        Preconditions.nonNull(answer, "Question answer's answer should not be null");
        Preconditions.nonEmpty(answer.values(), "Question answer's answers should not be empty");
        this.mwAnswer = answer;
    }

    @Override
    public Map<String, String> answer() {
        return new HashMap<>(mwAnswer);
    }

}
