package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.SingleChoiceQuestion;
import eapli.framework.validations.Preconditions;

import javax.persistence.Entity;

@Entity
public class SingleChoiceQuestionAnswer extends QuestionAnswer<String, SingleChoiceQuestion> {

    private String scAnswer;

    @Override
    public String answer() {
        return scAnswer;
    }

    public SingleChoiceQuestionAnswer() {
        // for ORM only
    }

    public SingleChoiceQuestionAnswer(SingleChoiceQuestion question, QuestionFeedback feedback, String answer) {
        super(question, feedback);
        Preconditions.nonNull(answer);
        Preconditions.nonEmpty(answer);
        this.scAnswer = answer;
    }

}
