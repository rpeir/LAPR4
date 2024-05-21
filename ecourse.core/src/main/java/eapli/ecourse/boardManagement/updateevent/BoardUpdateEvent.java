package eapli.ecourse.boardManagement.updateevent;

import eapli.ecourse.boardManagement.domain.Board;
import eapli.ecourse.boardUpdate.domain.CellUpdateType;
import eapli.ecourse.postit.domain.Content;
import eapli.ecourse.postit.domain.PostIt;
import eapli.framework.domain.events.DomainEvent;
import org.antlr.v4.runtime.misc.Pair;

import java.util.Calendar;

public class BoardUpdateEvent implements DomainEvent {
    private Board board;
    private PostIt postIt;
    private Calendar occurredAt;

    private Calendar registeredAt;
    private CellUpdateType type;
    private Pair<Integer, Integer> initPosition;
    private Pair<Integer, Integer> endPosition;


    public BoardUpdateEvent(Board board, PostIt postIt, Calendar occurredAt, CellUpdateType type, Pair<Integer, Integer> initPosition, Pair<Integer, Integer> endPosition){
        this.occurredAt = occurredAt;
        this.registeredAt = Calendar.getInstance();
        this.board = board;
        this.postIt = postIt;
        this.type = type;
        this.initPosition = initPosition;
        this.endPosition = endPosition;
    }
    @Override
    public Calendar occurredAt() {
        return this.occurredAt;
    }

    @Override
    public Calendar registeredAt() {
        return this.registeredAt;
    }

    public Board board(){
        return this.board;
    }
    public PostIt postIt(){
        return this.postIt;
    }
    public String type(){
        return this.type.toString();
    }

    public Content content() {
        return this.postIt.content();
    }
    public Pair<Integer, Integer> initPosition(){
        return this.initPosition;
    }
    public Pair<Integer, Integer> endPosition(){
        return this.endPosition;
    }
}
