package eapli.ecourse.questionanswer.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class QuestionFeedback implements ValueObject {

    private String description;

    private float grade;

    protected QuestionFeedback() {
        // for ORM only
    }

    protected QuestionFeedback(String description, float grade) {
        Preconditions.noneNull(description);
        Preconditions.ensure(grade >= 0f);
        this.description = description;
        this.grade = grade;
    }

    public static QuestionFeedback valueOf(String description, float grade) {
        return new QuestionFeedback(description, grade);
    }

    public float grade() {
        return this.grade;
    }

    public String feedback() {
        return this.description;
    }
}
