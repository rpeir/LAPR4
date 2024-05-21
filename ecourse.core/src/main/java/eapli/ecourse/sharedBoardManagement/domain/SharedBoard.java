package eapli.ecourse.sharedBoardManagement.domain;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"board_id","email"}))
public class SharedBoard implements AggregateRoot<Long> {
    @Id
    @GeneratedValue
    Long id;
    @Enumerated(EnumType.STRING)
    UserPermission userPermission;
    @OneToOne
    Board board;
    @Embedded
    EmailAddress email;

    public SharedBoard(UserPermission userPermission, Board board,EmailAddress email) {
        Preconditions.noneNull(userPermission,board,email);
        this.userPermission = userPermission;
        this.board = board;
        this.email = email;
    }

    public SharedBoard() {
        //for ORM
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public Long identity() {
        return id;
    }

    public EmailAddress email() {
        return this.email;
    }

    public Object userPermission() {
        return this.userPermission;
    }

    public Board board() {
        return this.board;
    }
}
