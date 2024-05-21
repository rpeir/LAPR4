package eapli.ecourse.boardUpdate.domain;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.domain.State;
import eapli.ecourse.boardUpdate.dto.UpdateDTO;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.representations.dto.DTOable;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "update")
public abstract class Update implements AggregateRoot<Long>, DTOable<UpdateDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "updateId")
    private Long updateId;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Calendar timeUpdate;

    @OneToOne
    private ECourseUser user;

    @ManyToOne
    private Board board;

    private boolean undo;

    protected Update(){
        // for ORM only
    }

    public Update(ECourseUser user){
        this.user = user;
    }
    public Update(Calendar timeUpdate, ECourseUser user, Board board){
        this.timeUpdate = timeUpdate;
        this.user = user;
        this.board = board;
        this.undo = false;
    }
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public Long identity() {
        return updateId;
    }

    public Calendar timeUpdate(){
        return timeUpdate;
    }

    public boolean associateBoard(Board board){
        if (board == null|| board.board_state() == State.ARCHIVED){
            return false;
        }else{
            this.board = board;
            return true;
        }
    }
    public boolean boardMatches(Long boardID){
        return this.board.id().equals(boardID);
    }
    public Board board(){
        return board;
    }
    public ECourseUser user(){
        return user;
    }

    public void undo() {
        if (undo) throw new IllegalStateException("Update already undone");
        undo = true;
    }

    public boolean isUndone() {
        return undo;
    }
}
