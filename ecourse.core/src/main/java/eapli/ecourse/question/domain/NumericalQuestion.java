package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.NumericalQuestionAnswer;
import eapli.ecourse.questionanswer.domain.QuestionFeedback;

import javax.persistence.*;

@Entity
public class NumericalQuestion extends Question {

    @Column
    private int nqSolution;

    @Column
    private int acceptanceError;

    public NumericalQuestion(String theme, String questionDescription, int solution, int acceptanceError) {
        super(theme, questionDescription);
        this.acceptanceError = acceptanceError;
        this.nqSolution = solution;
    }


    public Integer solution() {
        return nqSolution;
    }

    protected NumericalQuestion() {
        super();
        //orm
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSolution: " + nqSolution +
                "\nAcceptanceError: " + acceptanceError;
    }

    /**
     * Returns a NumericalQuestionAnswer with the given answer and with respective generated feedback
     * @param answer answer to the question
     * @param grade grade of the answer
     * @return NumericalQuestionAnswer
     */
    public NumericalQuestionAnswer answer(int answer, float grade) {
        String feedback;
        boolean correct;
        if (Math.abs(answer - nqSolution) <= acceptanceError) {
            feedback = "Correct answer";
            correct = true;
        } else {
            feedback = String.format("Wrong answer (%d). The correct answer is between [%d,%d]", answer, nqSolution -acceptanceError, nqSolution +acceptanceError);
            correct = false;
        }
        QuestionFeedback questionFeedback = QuestionFeedback.valueOf(feedback, correct?grade:0f);
        return new NumericalQuestionAnswer(this, questionFeedback, answer);
    }
}
