package eapli.ecourse.boardUpdate.domain;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardUpdate.dto.UpdateDTO;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.postit.domain.PostIt;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.validations.Preconditions;
import eapli.ecourse.postit.domain.Content;
import org.antlr.v4.runtime.misc.Pair;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
public class CellUpdate extends Update {

    @ManyToOne
    @JoinColumn(name = "postItId", referencedColumnName = "postItId")
    private PostIt postIt;

    @Embedded
    private Content content;

    @Enumerated(EnumType.STRING)
    private CellUpdateType cellUpdateType;
    private Pair<Integer, Integer> initPosition;
    private Pair<Integer, Integer> endPosition;
    public CellUpdate(Calendar timeUpdate, PostIt postIt, Content content, CellUpdateType cellUpdateType, ECourseUser owner, Board board,Pair<Integer, Integer> initPosition, Pair<Integer, Integer> endPosition) {
        super(timeUpdate,owner,board);
        Preconditions.noneNull(postIt, content, cellUpdateType);
        this.postIt = postIt;
        this.content = content;
        this.cellUpdateType = cellUpdateType;
        this.initPosition = initPosition;
        this.endPosition = endPosition;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    protected CellUpdate(){
        super();
        //for ORM only
    }

    @Override
    public UpdateDTO toDTO() {
        return new UpdateDTO(this.identity().toString(),this.user().identity().toString(),
                this.timeUpdate().getTime().toString(),this.getClass().getSimpleName(),this.cellUpdateType.name(),
                this.initPosition.a, this.initPosition.b, this.endPosition.a, this.endPosition.b);
    }

    public PostIt postIt() {
        return postIt;
    }

    public CellUpdateType type() {
        return cellUpdateType;
    }

    public Content content() {
        return content;
    }

    public Pair<Integer, Integer> initPosition() {
        return initPosition;
    }

    public Pair<Integer, Integer> endPosition() {
        return endPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellUpdate that = (CellUpdate) o;
        return Objects.equals(postIt, that.postIt) && Objects.equals(content, that.content) && cellUpdateType == that.cellUpdateType && Objects.equals(initPosition, that.initPosition) && Objects.equals(endPosition, that.endPosition);
    }
}
