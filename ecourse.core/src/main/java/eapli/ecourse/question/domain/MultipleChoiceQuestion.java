package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.MultipleChoiceQuestionAnswer;
import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class MultipleChoiceQuestion extends Question {

    @ElementCollection
    Map<String,String> options;
    @ElementCollection
    private Set<String> mcSolution;

    public MultipleChoiceQuestion(String theme, String questionDescription, Set<String> solution, Map<String,String> options) {
        super(theme, questionDescription);
        this.mcSolution = solution;
        this.options = options;
    }

    public Set<String> solution() {
        return new HashSet<>(mcSolution);
    }

    protected MultipleChoiceQuestion() {
        super();
    }

    public Map<String, String> options() {
        return options;
    }

    @Override
    public String toString() {
        return super.toString() +
                " \nOptions: " + options +
                "\nSolution: " + mcSolution;
    }

    /**
     * Returns a MultipleChoiceQuestionAnswer with the given answer and with respective generated feedback
     * @param answer answer to the question
     * @param grade grade of the answer
     * @return MultipleChoiceQuestionAnswer
     */
    public MultipleChoiceQuestionAnswer answer(Set<String> answer, float grade) {
        validateAnswer(answer);
        StringBuilder sbFeedback = new StringBuilder();
        boolean correct = true;
        for (String s : answer) {
            if (mcSolution.contains(s)) {
                sbFeedback.append("Correct answer: ").append(s).append("\n");
            } else {
                sbFeedback.append("Wrong answer: ").append(s).append("\n");
                correct = false;
            }
        }
        for (String s : mcSolution) {
            if (!answer.contains(s)) {
                sbFeedback.append("Missing answer: ").append(s).append("\n");
                correct = false;
            }
        }
        QuestionFeedback feedback = QuestionFeedback.valueOf(sbFeedback.toString(), correct? grade : 0f);
        return new MultipleChoiceQuestionAnswer(this, feedback, answer);
    }

    private void validateAnswer(Set<String> answer) {
        Preconditions.nonNull(answer, "Answer of multiple choice question should not be null");
        Preconditions.nonEmpty(answer, "Answer of multiple choice question should not be empty");
    }
}
