package eapli.ecourse.boardManagement.domain;

import eapli.ecourse.boardUpdate.domain.Update;
import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;
import eapli.ecourse.postit.domain.PostIt;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.validations.Preconditions;
import org.antlr.v4.runtime.misc.Pair;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "board")
public class Board implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @javax.persistence.Column(unique = true)
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "board", fetch = FetchType.EAGER)
    private Set<Column> columns;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "board", fetch = FetchType.EAGER)
    private Set<Row> rows;

    @Enumerated(EnumType.STRING)
    private State state;
    @ManyToOne
    private ECourseUser owner;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @MapKeyColumn(name = "postIt")
    private Map<Pair<Integer, Integer>, PostIt> postIts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "board", fetch = FetchType.EAGER)
    private List<Update> history;

    public Board(String title, State state, ECourseUser owner) {
        Preconditions.noneNull(title, state, owner);
        this.title = title;
        this.owner = owner;
        this.state = state;
        this.history = new ArrayList<>();
        this.postIts = new HashMap<>();
    }

    protected void setRows(List<Row> rows) {
        this.rows = new HashSet<>(rows);
    }

    protected void setColumns(List<Column> columns) {
        this.columns = new HashSet<>(columns);
    }

    public Board() {
        // for ORM only
    }

    public ECourseUser owner() {
        return owner;
    }

    public String board_title() {
        return title;
    }

    public State board_state() {
        return state;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public Long id() {
        return identity();
    }

    @Override
    public Long identity() {
        return this.id;
    }

    public void archive() {
        this.state = State.ARCHIVED;
    }

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public Map<Pair<Integer, Integer>, PostIt> postIts() {
        return this.postIts;
    }

    public int getNumberOfColumns() {
        return this.columns.size();
    }

    public int getNumberOfRows() {
        return this.rows.size();
    }


    @Override
    public String toString() {
        return
                "Id=" + id + "\n" +
                        "Title='" + title + "\n" +
                        "Columns=" + columns + "\n" +
                        "Rows=" + rows + "\n" +
                        "State=" + state + "\n" +
                        "Owner=" + owner + "\n" +
                        "PostIts=" + postIts + "\n" +
                        "History=" + history
                ;
    }

    public boolean isFree(int row, int column){
        Pair<Integer, Integer> position = new Pair<>(row,column);
        return !postIts.containsKey(position);
    }

    public void addPostIt(PostIt newPostIt, int row, int column) {
        if (row <= 0 || column <= 0)
            throw new IllegalArgumentException("Column and Row of boards cannot be less than 1");
        if (row > getNumberOfRows() || column > getNumberOfColumns())
            throw new IllegalArgumentException("Rows and Columns cannot be greater than the max");
        Pair<Integer, Integer> position = new Pair<>(row, column);
        this.postIts.put(position, newPostIt);
    }

    public PostIt getPostIt(int row, int column) {
        return this.postIts.get(new Pair<>(row,column));
    }

    public List<Update> history() {
        return this.history.stream().filter(u -> !u.isUndone()).collect(Collectors.toList());
    }

    public PostIt removePostIt(int row, int column) {
        Pair<Integer, Integer> position = new Pair<>(row, column);
        return this.postIts.remove(position);
    }
}
