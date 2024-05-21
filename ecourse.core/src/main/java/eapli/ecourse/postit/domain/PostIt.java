package eapli.ecourse.postit.domain;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;
import org.antlr.v4.runtime.misc.Pair;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Pattern;

@Entity
@Table(name = "postIt")
public class PostIt implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postItId")
    private Long postItId;

    @ManyToOne
    private ECourseUser owner;

    @Embedded
    private Content content;

    public PostIt(@NotNull Content content, @NotNull ECourseUser owner) {
        Preconditions.nonNull(content);
        Preconditions.nonNull(owner);
        this.content = content;
        this.owner = owner;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    protected PostIt() {
        //ORM
    }


    @Override
    public Long identity() {
        return this.postItId;
    }

    public Content content() {
        return this.content;
    }

    public void changePostIt(Content content) {
        this.content = content;
    }

    public String toString() {
        return this.content.toString();
    }

    public boolean isOwner(EmailAddress ownerEmail) {
        return this.owner.identity().equals(ownerEmail);
    }

    public ECourseUser owner() {
        return this.owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostIt postIt = (PostIt) o;
        return Objects.equals(postItId, postIt.postItId) && Objects.equals(owner, postIt.owner) && Objects.equals(content, postIt.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postItId, owner, content);
    }
}
