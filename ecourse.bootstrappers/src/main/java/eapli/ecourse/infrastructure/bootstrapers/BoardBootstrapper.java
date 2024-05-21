package eapli.ecourse.infrastructure.bootstrapers;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardManagement.domain.BoardBuilder;
import eapli.ecourse.boardManagement.domain.State;
import eapli.ecourse.boardManagement.repositories.BoardRepository;
import eapli.ecourse.infrastructure.persistence.PersistenceContext;
import eapli.ecourse.sharedBoardManagement.domain.SharedBoard;
import eapli.ecourse.sharedBoardManagement.domain.UserPermission;
import eapli.ecourse.sharedBoardManagement.repositories.BoardSharedRepository;
import eapli.ecourse.teacher.domain.Teacher;
import eapli.ecourse.teacher.repositories.TeacherRepository;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;


public class BoardBootstrapper implements Action {

    private final TeacherRepository teacherRepository = PersistenceContext.repositories().teachers();

    private final BoardRepository boardRepository = PersistenceContext.repositories().boards();

    private final BoardSharedRepository boardSharedRepository = PersistenceContext.repositories().boardShared();

    @Override
    public boolean execute() {
        try {
            create();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void create() {
        Optional<Teacher> teacher1 = teacherRepository.findByEmail(EmailAddress.valueOf("teacher1@email.org"));
        BoardBuilder bBuilder  = new BoardBuilder().withTitle("Board1").withState(State.ACTIVE).withOwner(teacher1.get()).withMaxColumns(10).withMaxRows(20);
        buildBoardColumnsRowsNames(bBuilder);
        Board board1 = bBuilder.build();

        bBuilder = new BoardBuilder().withTitle("Board2").withState(State.ACTIVE).withOwner(teacher1.get()).withMaxColumns(10).withMaxRows(20);
        buildBoardColumnsRowsNames(bBuilder);
        Board board2 = bBuilder.build();

        bBuilder = new BoardBuilder().withTitle("Board3").withState(State.ACTIVE).withOwner(teacher1.get()).withMaxColumns(10).withMaxRows(20);
        buildBoardColumnsRowsNames(bBuilder);
        Board board3 = bBuilder.build();

        board1 = boardRepository.save(board1);
        board2 = boardRepository.save(board2);
        board3 = boardRepository.save(board3);

        SharedBoard sharedBoard1 = new SharedBoard(UserPermission.WRITE, board1, teacher1.get().identity());
        SharedBoard sharedBoard2 = new SharedBoard(UserPermission.WRITE, board2, teacher1.get().identity());
        SharedBoard sharedBoard3 = new SharedBoard(UserPermission.WRITE, board3, teacher1.get().identity());

        boardSharedRepository.save(sharedBoard1);
        boardSharedRepository.save(sharedBoard2);
        boardSharedRepository.save(sharedBoard3);

    }

    private void buildBoardColumnsRowsNames(BoardBuilder bBuilder) {
        for (int i = 0; i < 10; i++) {
            bBuilder.withColumn(i, "Column" + i);
        }
        for (int i = 0; i < 20; i++) {
            bBuilder.withRow(i, "Row" + i);
        }
    }
}
