package eapli.ecourse.boardManagement.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BOARD_ROW")
public class Row implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID",referencedColumnName = "id")
    private Board board;

    public Row(String title, Board board) {
        this.title = title;
        this.board = board;
    }
    protected Row() {
        // for ORM only
    }
    public String row_title(){
        return title;
    }
    public String toString(){
        return "Row: " + title + "\n";
    }

}
