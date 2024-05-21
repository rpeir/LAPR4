package eapli.ecourse.question.domain;

import eapli.ecourse.questionanswer.domain.QuestionAnswer;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Question implements AggregateRoot<Long> {
    /**
     * ORM primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;

    @Column
    @Embedded
    private QuestionTheme theme;

    @Column
    private String questionDescription;

    protected Question() {
        //orm
    }

    /**
     * @param other
     * @return
     */
    @Override
    public boolean sameAs(Object other) {
        Question question = (Question) other;
        return this.equals(question) && this.questionDescription.equals(questionDescription);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    /**
     * @return
     */
    @Override
    public Long identity() {
        return questionId;
    }

    public Question(String theme, String questionDescription) {
        this.theme = new QuestionTheme(theme);
        this.questionDescription = questionDescription;
    }

    @Override
    public String toString() {
        return String.format("Question:\n Theme: %s \n Description: %s \n", theme, questionDescription);
    }

    public String theme() {
        return theme.questionSubject();
    }

    public String questionDescription() {
        return questionDescription;
    }
}
