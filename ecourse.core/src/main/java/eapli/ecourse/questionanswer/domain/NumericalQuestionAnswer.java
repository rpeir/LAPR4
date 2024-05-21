package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.NumericalQuestion;

import javax.persistence.Entity;

@Entity
public class NumericalQuestionAnswer extends QuestionAnswer<Integer, NumericalQuestion> {

    private int nAnswer;
    @Override
    public Integer answer() {
        return nAnswer;
    }

    protected NumericalQuestionAnswer() {
        // for ORM only
    }

    public NumericalQuestionAnswer(NumericalQuestion question, QuestionFeedback feedback, int answer) {
        super(question, feedback);
        this.nAnswer = answer;
    }
}
