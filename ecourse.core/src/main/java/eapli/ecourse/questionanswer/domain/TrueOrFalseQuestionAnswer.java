package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.TrueOrFalseQuestion;

import javax.persistence.Entity;

@Entity
public class TrueOrFalseQuestionAnswer extends QuestionAnswer<Boolean, TrueOrFalseQuestion> {

    private boolean tfAnswer;
    @Override
    public Boolean answer() {
        return tfAnswer;
    }

    public TrueOrFalseQuestionAnswer() {
        // for ORM only
    }

    public TrueOrFalseQuestionAnswer(TrueOrFalseQuestion question, QuestionFeedback feedback, boolean answer) {
        super(question, feedback);
        this.tfAnswer = answer;
    }
}
