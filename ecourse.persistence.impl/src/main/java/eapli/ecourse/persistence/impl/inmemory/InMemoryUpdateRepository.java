package eapli.ecourse.persistence.impl.inmemory;

import eapli.ecourse.boardUpdate.domain.CellUpdate;
import eapli.ecourse.boardUpdate.domain.Update;
import eapli.ecourse.boardUpdate.repositories.UpdateRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import org.antlr.v4.runtime.misc.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class InMemoryUpdateRepository extends InMemoryDomainRepository<Update, Long> implements UpdateRepository {
    static {
        InMemoryInitializer.init();
    }
    @Override
    public Iterable<Update> findByBoardID(Long boardID) {
        return match(c -> c.board().id().equals(boardID));
    }

    @Override
    public List<Update> findLastTwoByPostIt(Long postItID) {
        List<Update> list = (List<Update>) match(c -> (c instanceof CellUpdate) && (((CellUpdate) c).postIt().identity().equals(postItID)));
        list.sort(Comparator.comparing(Update::timeUpdate).reversed());
        return list.subList(0,Integer.min(2,list.size()));
    }

    @Override
    public List<Update> findLastTwoByBoardAndPosition(Long boardID, int row, int column) {
        Pair<Integer, Integer> pair = new Pair<>(row, column);
        List<Update> list = (List<Update>) match(c -> (c instanceof CellUpdate) && (((CellUpdate) c).board().id().equals(boardID)) && (((CellUpdate) c).endPosition().equals(pair)));
        list.sort(Comparator.comparing(Update::timeUpdate).reversed());
        return list.subList(0,Integer.min(2,list.size()));
    }

}
