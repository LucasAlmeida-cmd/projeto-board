package br.com.board.Board.Model;


import jakarta.persistence.*;

@Entity
public class CardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "board_column_id")
    private BoardColumm boardColumn;

    public CardModel(String title, String description, BoardColumm boardColumn) {
        this.title = title;
        this.description = description;
        this.boardColumn = boardColumn;
    }

    public CardModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BoardColumm getBoardColumn() {
        return boardColumn;
    }

    public void setBoardColumn(BoardColumm boardColumn) {
        this.boardColumn = boardColumn;
    }


}
