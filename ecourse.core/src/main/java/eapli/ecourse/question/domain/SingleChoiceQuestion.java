package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import eapli.ecourse.questionanswer.domain.SingleChoiceQuestionAnswer;

import javax.persistence.*;
import java.util.Map;

@Entity
public class SingleChoiceQuestion extends Question {
    @ElementCollection
    Map<String,String> options;
    @Column
    private String scSolution;

    public SingleChoiceQuestion(String theme, String questionDescription,Map<String,String> options, String solution) {
        super(theme, questionDescription);
        this.options = options;
        this.scSolution = solution;
    }
    public Map<String,String> options() {
        return options;
    }
    public String solution() {
        return this.scSolution;
    }

    protected SingleChoiceQuestion() {
        super();
        //orm
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nOptions=" + options +
                "\nSolution='" + scSolution;
    }

    public SingleChoiceQuestionAnswer answer(String answer, float grade) {
        QuestionFeedback feedback;
        if (answer.equals(scSolution))
            feedback = QuestionFeedback.valueOf("Correct", grade);
        else
            feedback = QuestionFeedback.valueOf("Incorrect", 0);
        return new SingleChoiceQuestionAnswer(this, feedback, answer);
    }
}
