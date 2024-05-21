package eapli.ecourse.boardUpdate.domain;

import eapli.ecourse.boardUpdate.dto.UpdateDTO;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class BoardUpdate extends Update {
    @Embedded
    private BoardChange boardChange;

    @Enumerated(EnumType.STRING)
    private BoardUpdateType boardUpdateType;

    protected BoardUpdate(){
        super();
        //for ORM only
    }

    public BoardUpdate(BoardChange boardChange, BoardUpdateType boardUpdateType, ECourseUser user){
        super(user);
        Preconditions.noneNull(boardChange, boardUpdateType);
        this.boardChange = boardChange;
        this.boardUpdateType = boardUpdateType;
    }

    @Override
    public UpdateDTO toDTO() {
        return new UpdateDTO(this.identity().toString(),this.user().identity().toString(),this.timeUpdate().getTime().toString(),this.getClass().getSimpleName(),this.boardUpdateType.name());
    }
}
