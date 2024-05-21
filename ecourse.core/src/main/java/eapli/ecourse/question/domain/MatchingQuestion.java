package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.MatchingQuestionAnswer;
import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class MatchingQuestion extends Question {
    @ElementCollection
    private Map<String,String>  groupA;

    @ElementCollection
    private Map<Integer,String>  groupB;

    @ElementCollection
    private Map<String,Integer> mqSolution;

    public MatchingQuestion(String theme, String questionDescription, Map<String,String> groupA, Map<Integer,String> groupB, Map<String,Integer> solution) {
        super(theme, questionDescription);
        this.groupA = groupA;
        this.groupB = groupB;
        this.mqSolution = solution;
    }

    public Map<String, Integer> solution() {
        return new HashMap<>(mqSolution);
    }

    protected MatchingQuestion() {
        super();
        //Orm
    }

    @Override
    public String toString() {
        return super.toString() +
                "groupA: " + groupA +
                "\n groupB: " + groupB +
                "\n solution: " + mqSolution;
    }

    public Map<String, String> groupA() {
        return new HashMap<>(groupA);
    }

    public Map<Integer, String> groupB() {
        return new HashMap<>(groupB);
    }

    /**
     * Returns a MatchingQuestionAnswer with the given answer and with respective generated feedback
     * @param answer answer to the question
     * @param grade grade of the answer
     * @return MatchingQuestionAnswer
     */
    public MatchingQuestionAnswer answer(Map<String, Integer> answer, float grade) {
        validateAnswer(answer);
        StringBuilder feedback = new StringBuilder();
        boolean correct = true;
        for (var entry : answer.entrySet()) {
            if (mqSolution.get(entry.getKey()).equals(entry.getValue()))
                feedback.append(String.format("Correct answer for %s\n", entry.getKey()));
            else {
                correct = false;
                feedback.append(String.format("Wrong answer for %s. ", entry.getKey()));
                feedback.append(String.format("Correct answer is %s\n", mqSolution.get(entry.getKey())));
            }
        }
        var qFeedback = QuestionFeedback.valueOf(feedback.toString(), correct? grade : 0f);
        return new MatchingQuestionAnswer(this, qFeedback, answer);
    }


    private void validateAnswer(Map<String, Integer> answer) {
        Preconditions.nonNull(answer, "Answer cannot be null");
        Preconditions.ensure(answer.size() == mqSolution.size(), "Invalid number of answers in Matching Question");
        for (var entry : answer.entrySet()) {
            Preconditions.ensure(groupA.containsKey(entry.getKey()), "Invalid key in answer");
            Preconditions.ensure(groupB.containsKey(entry.getValue()), "Invalid value in answer");
        }
    }
}
