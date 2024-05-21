package eapli.ecourse.boardManagement.domain;

import eapli.ecourse.ecourseusermanagement.domain.ECourseUser;

import java.util.ArrayList;
import java.util.List;

public class BoardBuilder {
    private int maxColumns;
    private int maxRows;
    private List<String> rows;
    private List<String> columns;
    private String title;
    private ECourseUser owner;
    private State state;

    public BoardBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BoardBuilder withOwner(ECourseUser owner) {
        this.owner = owner;
        return this;
    }
    public BoardBuilder withState(State state) {
        this.state = state;
        return this;
    }
    public BoardBuilder withRow(int index, String rowTitle){
        this.rows.add(index, rowTitle);
        return this;
    }
    public BoardBuilder withColumn(int index, String columnTitle){
        this.columns.add(index, columnTitle);
        return this;
    }
    public BoardBuilder withMaxColumns(int maxColumns){
        this.maxColumns = maxColumns;
        this.columns = new ArrayList<>(maxColumns);
        return this;
    }
    public BoardBuilder withMaxRows(int maxRows){
        this.maxRows = maxRows;
        this.rows = new ArrayList<>(maxRows);
        return this;
    }
    public Board build() {
        Board board = new Board(title, state, owner);
        List<Row> rowsToAdd = new ArrayList<>();
        for(String row : rows){
            rowsToAdd.add(createRow(row, board));
        }
        board.setRows(rowsToAdd);
        List<Column> columnsToAdd = new ArrayList<>();
        for(String column : columns){
            columnsToAdd.add(createColumn(column, board));
        }
        board.setColumns(columnsToAdd);
        return board;
    }

    private Row createRow(String rowTitle, Board board){
        return new Row(rowTitle, board);
    }

    private Column createColumn(String columnTitle, Board board){
        return new Column(columnTitle, board);
    }
}

