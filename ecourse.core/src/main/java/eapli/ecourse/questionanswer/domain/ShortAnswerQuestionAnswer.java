package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.ShortAnswerQuestion;
import eapli.framework.validations.Preconditions;

import javax.persistence.Entity;

@Entity
public class ShortAnswerQuestionAnswer extends QuestionAnswer<String, ShortAnswerQuestion> {

    private String saAnswer;

    @Override
    public String answer() {
        return saAnswer;
    }

    protected ShortAnswerQuestionAnswer() {
        // for ORM only
    }

    public ShortAnswerQuestionAnswer(ShortAnswerQuestion question, QuestionFeedback feedback, String answer) {
        super(question, feedback);
        Preconditions.nonNull(answer);
        Preconditions.nonEmpty(answer);
        this.saAnswer = answer;
    }
}
