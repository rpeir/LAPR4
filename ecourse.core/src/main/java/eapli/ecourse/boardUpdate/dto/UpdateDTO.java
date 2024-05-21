package eapli.ecourse.boardUpdate.dto;

import eapli.framework.representations.dto.DTO;

import java.io.Serializable;

@DTO
public class UpdateDTO implements Serializable {
    public String updateId;
    public String user;
    public String timeUpdate;

    public String updateType;
    public String subtype;
    public int initRow;
    public int initCol;
    public int endRow;
    public int endCol;


    public UpdateDTO(String updateId, String user, String timeUpdate, String updateType, String subtype) {
        this.updateId = updateId;
        this.user = user;
        this.timeUpdate = timeUpdate;
        this.updateType = updateType;
        this.subtype = subtype;
    }

    public UpdateDTO(String updateId, String user, String timeUpdate, String updateType, String subtype, int initRow, int initCol, int endRow, int endCol) {
        this.updateId = updateId;
        this.user = user;
        this.timeUpdate = timeUpdate;
        this.updateType = updateType;
        this.subtype = subtype;
        this.initRow = initRow;
        this.initCol = initCol;
        this.endRow = endRow;
        this.endCol = endCol;
    }

    public UpdateDTO() {
    }
}
