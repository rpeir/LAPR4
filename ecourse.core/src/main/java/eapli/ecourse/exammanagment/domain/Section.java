package eapli.ecourse.exammanagment.domain;

import eapli.ecourse.question.domain.Question;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * An Exam Section
 */
@Entity
public class Section implements DomainEntity<Long> {

    /**
     * Unique identifier for the section
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Description of the section
     */
    @Embedded
    private Description description;

    /**
     * Questions of the section
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Question> questions;

    @ElementCollection
    private Map<Question, Float> questionWeights;

    public Section(String description, Set<Question> questions, Map<Question, Float> questionWeights) {
        setDescription(description);
        setQuestions(questions);
        setQuestionGrades(questionWeights);
    }

    private void setQuestionGrades(Map<Question, Float> questionWeights) {
        Preconditions.nonNull(questionWeights);
        Preconditions.ensure(questionWeights.keySet().containsAll(questions), "All questions must have a grade");
        this.questionWeights = questionWeights;
    }

    private void setDescription(String description) {
        this.description = Description.valueOf(description);
    }

    private void setQuestions(Set<Question> questions) {
        Preconditions.nonNull(questions);
        Preconditions.nonEmpty(questions);
        this.questions = questions;
    }

    protected Section() {
        // for ORM only
    }
    @Override
    public boolean sameAs(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(description, section.description) && Objects.equals(questions, section.questions);

    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, questions);
    }

    public String description() {
        return this.description.toString();
    }

    @Override
    public String toString() {
        return description();
    }

    public Iterable<Question> questions() {
        return new HashSet<>(this.questions);
    }

    public float grade(Question question) {
        return this.questionWeights.get(question);
    }
}
