package eapli.ecourse.questionanswer.domain;

import eapli.ecourse.question.domain.Question;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

/**
 * The answer to a question of an exam
 * @param <A> the type of the answer
 * @param <Q> the type of the question
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class QuestionAnswer<A, Q extends Question> implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Embedded
    private QuestionFeedback questionFeedback;

    @ManyToOne
    private Question question;

    protected QuestionAnswer() {
        // for ORM only
    }

    public QuestionAnswer(Q question, QuestionFeedback feedback) {
        Preconditions.nonNull(question, "Question answer's question should not be null");
        Preconditions.nonNull(feedback, "Question answer's feedback should not be null");
        this.questionFeedback = feedback;
        this.question = question;
    }

    public abstract A answer();

    public Question question() {
        return this.question;
    }
    @Override
    public Long identity() {
        return id;
    }

    public QuestionFeedback feedback() {
        return questionFeedback;
    }


    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public String toString() {
        return question.toString();
    }

}
