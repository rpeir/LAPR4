package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.MissingWordQuestionAnswer;
import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.*;

@Entity
public class MissingWordQuestion extends Question {

    @ElementCollection
    Map<String, ArrayList<String>> optionsMap;
    @ElementCollection
    Map<String, String> msSolutions;

    private String missingPhrase;

    public MissingWordQuestion(String theme, String questionDescription, Map<String, ArrayList<String>> optionsMap, Map<String, String> solutions, String missingPhrase) {
        super(theme, questionDescription);
        Preconditions.nonNull(optionsMap);
        Preconditions.nonNull(solutions);
        Preconditions.nonNull(missingPhrase);
        Preconditions.nonEmpty(missingPhrase);
        this.optionsMap = optionsMap;
        this.msSolutions = solutions;
        this.missingPhrase = missingPhrase;
    }

    public Map<String, String> solution() {
        return new HashMap<>(msSolutions);
    }

    protected MissingWordQuestion() {
        super();
        //ORM
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nOptionsMap: " + optionsMap +
                "\nsolutions: " + msSolutions;
    }

    public String missingPhrase() {
        return missingPhrase;
    }

    public Map<String, ArrayList<String>> options() {
        return new HashMap<>(optionsMap);
    }

    /**
     * Returns a MissingWordQuestionAnswer with the given answer and with respective generated feedback
     * @param answers answer to the question
     * @param grade grade of the answer
     * @return MissingWordQuestionAnswer
     */
    public MissingWordQuestionAnswer answer(Map<String, String> answers, float grade) {
        validateAnswers(answers);

        float gradePerAnswer = grade / msSolutions.size(), gradeSum = 0f;
        StringBuilder sbFeedback = new StringBuilder();
        for (var entry : answers.entrySet()) {
            if (msSolutions.get(entry.getKey()).equals(entry.getValue())) {
                sbFeedback.append("Correct answer for ").append(entry.getKey()).append("\n");
                gradeSum += gradePerAnswer;
            } else {
                sbFeedback.append("Wrong answer for ").append(entry.getKey()).append(". ");
                sbFeedback.append("Correct answer should be ").append(msSolutions.get(entry.getKey())).append("\n");
            }
        }
        QuestionFeedback feedback = QuestionFeedback.valueOf(sbFeedback.toString(), gradeSum);
        return new MissingWordQuestionAnswer(this, feedback, answers);
    }

    private void validateAnswers(Map<String, String> answers) {
        Preconditions.nonNull(answers, "Answers cannot be null");
        Preconditions.ensure(answers.size() == msSolutions.size(), "Answers must have the same size as solutions");
        for (String key : answers.keySet()) {
            Preconditions.ensure(msSolutions.containsKey(key), "Answers must have the same keys as solutions");
        }
    }
}
