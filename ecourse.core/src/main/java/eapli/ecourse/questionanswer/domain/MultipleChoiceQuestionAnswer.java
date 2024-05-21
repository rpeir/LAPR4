package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.MultipleChoiceQuestion;
import eapli.framework.validations.Preconditions;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MultipleChoiceQuestionAnswer extends QuestionAnswer<Set<String>, MultipleChoiceQuestion> {

    @ElementCollection
    private Set<String> mcAnswer;
    @Override
    public Set<String> answer() {
        return new HashSet<>(mcAnswer);
    }

    protected MultipleChoiceQuestionAnswer() {
        // for ORM only
    }

    public MultipleChoiceQuestionAnswer(MultipleChoiceQuestion question, QuestionFeedback feedback, Set<String> answer) {
        super(question, feedback);
        Preconditions.nonNull(answer);
        Preconditions.nonEmpty(answer);
        this.mcAnswer = answer;
    }

}
