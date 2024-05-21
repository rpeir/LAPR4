package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import eapli.ecourse.questionanswer.domain.TrueOrFalseQuestionAnswer;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TrueOrFalseQuestion extends Question {
    @Column
    boolean tfSolution;

    public TrueOrFalseQuestion(String theme, String questionDescription, String solution) {
        super(theme, questionDescription);
        this.tfSolution = buildSolution(solution);
    }

    public Boolean solution() {
        return tfSolution;
    }

    protected TrueOrFalseQuestion() {
        super();
        //orm
    }

    @Override
    public String toString() {
            return super.toString() +
                "\nSolution:" + tfSolution;
    }

    private boolean buildSolution(String solution) {
        solution = solution.toLowerCase();
        return solution.equals("true");
    }


    public TrueOrFalseQuestionAnswer answer(boolean answer, float value) {
        QuestionFeedback feedback;
        if (answer == tfSolution)
            feedback = QuestionFeedback.valueOf("Correct", value);
        else
            feedback = QuestionFeedback.valueOf("Incorrect", 0);
        return new TrueOrFalseQuestionAnswer(this, feedback, answer);
    }
}
