package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.QuestionAnswer;
import eapli.ecourse.questionanswer.domain.QuestionFeedback;
import eapli.ecourse.questionanswer.domain.ShortAnswerQuestionAnswer;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.*;
import java.util.regex.Pattern;

@Entity
public class ShortAnswerQuestion extends Question {
    @ElementCollection
    private Map<String,Integer> saSolution;
    public ShortAnswerQuestion(String theme, String questionDescription, Map<String, Integer> solution) {
        super(theme, questionDescription);
        this.saSolution = solution;
    }

    public Map<String, Integer> solution() {
        return new HashMap<>(saSolution);
    }

    protected ShortAnswerQuestion() {
        super();
        //orm
    }

    @Override
    public String toString() {
        return super.toString() + saSolution;
    }

    public ShortAnswerQuestionAnswer answer(String answer, float grade){
        Pattern regex;
        QuestionFeedback feedback = QuestionFeedback.valueOf("Incorrect", 0);

        // Sort the solutions by grade value
        Comparator<Map.Entry<String, Integer>> comparator = (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue());
        Set<Map.Entry<String, Integer>> sortedSolutions = new TreeSet<>(comparator);
        sortedSolutions.addAll(saSolution.entrySet());

        for (Map.Entry<String,Integer> entry : sortedSolutions) {
            String key = entry.getKey();
            key = key.replace("*","[a-zA-Z0-9 ]*");
            regex = Pattern.compile(key);
            if (regex.matcher(answer).find()) {
                if (entry.getValue() == 100)
                    feedback = QuestionFeedback.valueOf("Correct", (entry.getValue()/100f) * grade);
                else
                    feedback = QuestionFeedback.valueOf("Partially Correct", (entry.getValue()/100f) * grade);
                break;
            }
        }
        return new ShortAnswerQuestionAnswer(this, feedback, answer);
    }
}
