package eapli.ecourse.boardUpdate.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
@Embeddable
public class BoardChange implements ValueObject {
    private String changeDescription;

    public BoardChange(String changeDescription) {
        this.changeDescription = changeDescription;
    }

    public BoardChange() {
    }

}
