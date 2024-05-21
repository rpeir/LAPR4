package eapli.ecourse.boardManagement.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BOARD_COLUMN")
public class Column implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "BOARD_ID",referencedColumnName = "id")
    private Board board;

    public Column(String title, Board board) {
        this.title = title;
        this.board = board;
    }

    public Column() {
        // for ORM only
    }
    public String column_title(){
        return title;
    }
    public String toString(){
        return "Column: " + title + "\n";
    }

}
