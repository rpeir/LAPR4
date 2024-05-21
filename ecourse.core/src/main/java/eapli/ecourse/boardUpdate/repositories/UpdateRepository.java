package eapli.ecourse.boardUpdate.repositories;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardUpdate.domain.Update;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface UpdateRepository extends DomainRepository<Long, Update> {
    Iterable<Update> findByBoardID(Long boardID);
    List<Update> findLastTwoByPostIt(Long postItID);
    List<Update> findLastTwoByBoardAndPosition(Long boardID, int row, int column);
}
