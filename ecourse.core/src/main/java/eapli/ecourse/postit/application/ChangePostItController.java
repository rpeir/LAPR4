package eapli.ecourse.postit.application;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.boardManagement.updateevent.BoardUpdateEvent;
import eapli.ecourse.boardUpdate.domain.CellUpdateType;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.postit.domain.Content;
import eapli.ecourse.postit.domain.ContentType;
import eapli.ecourse.postit.domain.PostIt;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class ChangePostItController {
    private BoardSharedRepository boardSharedRepository;
    private BoardRepository boardRepository;
    private EventPublisher publisher;

    public ChangePostItController(BoardSharedRepository boardSharedRepository, BoardRepository boardRepository) {
        this.boardSharedRepository = boardSharedRepository;
        this.boardRepository = boardRepository;
        this.publisher = InProcessPubSub.publisher();
    }

    public ChangePostItController(){
        this.boardSharedRepository = PersistenceContext.repositories().boardShared();
        this.boardRepository = PersistenceContext.repositories().boards();
        this.publisher = InProcessPubSub.publisher();
    }

    public Iterable<Board> listBoardsWithWritePermission(EmailAddress email){
        Iterable<SharedBoard> boardsSharedWithPermission =boardSharedRepository.findBoardsWithWritePermission(email);
        List<Board> boardsWithPermission = new ArrayList<>();
        for(SharedBoard sharedBoard : boardsSharedWithPermission)
            boardsWithPermission.add(sharedBoard.board());
        return boardsWithPermission;
    }

    public void changePostIt(EmailAddress email, String selectedBoard, int row, int column, String type, byte[] content) {
        Board savedBoard;
        PostIt savedPostIt;
        Optional<Board> board = boardRepository.findByTitle(selectedBoard);
        if (board.isEmpty())
            return;
        else {
            PostIt postIt = board.get().getPostIt(row, column);
            if (postIt == null) {
                throw new IllegalArgumentException("There is no post it to edit in that postion!");
            }
            if (loggedUserIsNotOwner(postIt, email))
                throw new IllegalStateException("User is not the owner of the post it!");
            else
                postIt.changePostIt(new Content(ContentType.valueOf(type), content));
            board.get().addPostIt(postIt,row,column);
            savedBoard = boardRepository.save(board.get());
            savedPostIt = savedBoard.getPostIt(row, column);
        }
        this.publisher.publish(new BoardUpdateEvent(savedBoard, savedPostIt, Calendar.getInstance(), CellUpdateType.UPDATE, new Pair<>(row, column), new Pair<>(row, column)));
    }

    public void movePostIt(EmailAddress email,String selectedBoard, int row1, int column1, int row2, int column2) {
        Board savedBoard;
        PostIt savedPostIt;
        Optional<Board> board = boardRepository.findByTitle(selectedBoard);
        if (board.isEmpty())
            return;
        else {
            PostIt postIt = board.get().getPostIt(row1, column1);
            if (postIt == null)
                throw new IllegalArgumentException("There is no post it to edit in that postion!");
            if (loggedUserIsNotOwner(postIt, email))
                throw new IllegalStateException("User is not the owner of the post it!");
            if (board.get().postIts().get(new Pair<>(row2, column2)) != null)
                throw new IllegalStateException("There is already a post it in the end position!");
            else {
                board.get().removePostIt(row1,column1);
                board.get().addPostIt(postIt,row2,column2);
            }
            savedBoard = boardRepository.save(board.get());
            savedPostIt = savedBoard.getPostIt(row2, column2);
        }
        this.publisher.publish(new BoardUpdateEvent(savedBoard, savedPostIt, Calendar.getInstance(), CellUpdateType.MOVE,
                new Pair<>(row1, column1), new Pair<>(row2, column2)));
    }

    public void deletePostIt(EmailAddress email, String selectedBoard, int row, int column) {
        Board savedBoard;
        PostIt postIt;
        Optional<Board> board = boardRepository.findByTitle(selectedBoard);
        if (board.isEmpty())
            return;
        else {
            postIt = board.get().getPostIt(row, column);
            if (postIt == null)
                throw new IllegalArgumentException("There is no post it to edit in that postion!");
            if (loggedUserIsNotOwner(postIt, email))
                throw new IllegalStateException("User is not the owner of the post it!");
            else
                board.get().removePostIt(row,column);
            savedBoard = boardRepository.save(board.get());
        }
        this.publisher.publish(new BoardUpdateEvent(savedBoard, postIt, Calendar.getInstance(), CellUpdateType.DELETE, new Pair<>(row, column), new Pair<>(row, column)));
    }
    public boolean loggedUserIsNotOwner(PostIt postIt, EmailAddress email){
        return !postIt.isOwner(email);
    }

}
