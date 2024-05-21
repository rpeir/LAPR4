package eapli.ecourse.postit.application;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.boardUpdate.domain.CellUpdate;
import eapli.ecourse.boardUpdate.domain.CellUpdateType;
import eapli.ecourse.boardUpdate.domain.Update;
import eapli.ecourse.boardUpdate.repositories.UpdateRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.postit.domain.PostIt;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;

import java.util.List;

/**
 * Service to undo the last change made to a postit
 */
public class UndoLastChangePostItService {

    private final UpdateRepository updatesRepo;
    private final BoardRepository boardsRepo;

    public UndoLastChangePostItService(UpdateRepository updates, BoardRepository boards) {
        this.updatesRepo = updates;
        this.boardsRepo = boards;
    }

    public UndoLastChangePostItService() {
        this.updatesRepo = PersistenceContext.repositories().updates();
        this.boardsRepo = PersistenceContext.repositories().boards();
    }

    /**
     * Undo the last change made to a postit
     * @param board board where the postit is
     * @param row row of the postit to undo
     * @param column column of the postit to undo
     * @param email email of the user that wants to undo the last change
     * @throws IllegalStateException if there are no updates for the postit, or if other error occurs
     * @throws IllegalArgumentException if the postit is not of the user, or it is not possible to undo the last change
     */
    public void undoLastChangePostIt(Board board, int row, int column, EmailAddress email) {
        List<Update> updates = updatesRepo.findLastTwoByBoardAndPosition(board.id(), row, column);

        if (updates.isEmpty()) throw new IllegalStateException(String.format("No updates found for postit at row %d and column %d on board %s", row, column, board.board_title()));

        CellUpdate updateToRestore = (CellUpdate) updates.get(Integer.min(1, updates.size() - 1)); // if there are only one update, restore it, if there are more, restore the second last
        CellUpdate lastUpdate = (CellUpdate) updates.get(0);
        Preconditions.ensure(updateToRestore.postIt().isOwner(email), String.format("%s is not the owner of the post-it (%d-%d)", email, row, column));

        switch (lastUpdate.type()) {
            case INSERT:
                Preconditions.ensure(!board.isFree(row, column), String.format("Does not exist a postit at row %d and column %d on board %s", row, column, board.board_title()));
                Preconditions.ensure(board.getPostIt(row, column).isOwner(email), String.format("%s is not the owner of the post-it (%d-%d)", email, row, column));
                if (board.removePostIt(row, column) == null)
                    throw new IllegalArgumentException(String.format("Tried to removed not found postit at row %d and column %d on board %s",
                            row, column, board.board_title()));
                break;
            case UPDATE:
                Preconditions.ensure(!board.isFree(row, column), String.format("Does not exist a postit at row %d and column %d on board %s", row, column, board.board_title()));
                PostIt postit = board.getPostIt(row, column);
                Preconditions.ensure(postit.isOwner(email), String.format("%s is not the owner of the post-it (%d-%d)", email, row, column));
                postit.changePostIt(updateToRestore.content());
                break;
            case DELETE:
                if (!board.isFree(row, column))
                    throw new IllegalArgumentException(
                            String.format("Tried to reinsert postit in occupied position at row %d and column %d on board %s",
                                    row, column, board.board_title()));
                board.addPostIt(updateToRestore.postIt(), updateToRestore.initPosition().a, updateToRestore.initPosition().b);
                break;
            case MOVE:
                if (!board.isFree(updateToRestore.initPosition().a, updateToRestore.initPosition().b))
                    throw new IllegalArgumentException(
                            String.format("Tried to move postit to occupied position at row %d and column %d on board %s",
                                    updateToRestore.initPosition().a, updateToRestore.initPosition().b, board.board_title()));
                if (board.removePostIt(row, column) == null) throw new IllegalStateException(String.format("Tried to removed not found postit at row %d and column %d on board %s", row, column, board.board_title()));
                board.addPostIt(updateToRestore.postIt(), updateToRestore.initPosition().a, updateToRestore.initPosition().b);
                break;
        }
        boardsRepo.save(board);
        lastUpdate.undo();
        updatesRepo.save(lastUpdate);
    }
}
