package eapli.ecourse.sharedBoardManagement.domain;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.framework.general.domain.model.EmailAddress;

public class BoardSharedBuilder {
    private Board board;
    private UserPermission permission;
    private EmailAddress email;

    public BoardSharedBuilder withBoard(Board board){
        this.board=board;
        return this;
    }
    public BoardSharedBuilder withPermission(UserPermission permission){
        this.permission=permission;
        return this;
    }
    public BoardSharedBuilder withEmail(EmailAddress email){
        this.email=email;
        return this;
    }
    public SharedBoard build(){
        return new SharedBoard(permission, board, email);
    }
}
