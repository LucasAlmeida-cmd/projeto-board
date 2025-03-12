package br.com.board.Board.Model;

import br.com.board.Board.Enum.BoardColummEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COLUNA_QUADRO")
public class BoardColumm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    @Column(name = "column_order")
    private BoardColummEnum tipo;
    private int ordem;
    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "boardColumn")
    private List<CardModel> cards;

    public BoardColumm(String nome, BoardColummEnum tipo, int ordem, Board board, List<CardModel> cards) {
        this.nome = nome;
        this.tipo = tipo;
        this.ordem = ordem;
        this.board = board;
        this.cards = cards;
    }

    public BoardColumm(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BoardColummEnum getTipo() {
        return tipo;
    }

    public void setTipo(BoardColummEnum tipo) {
        this.tipo = tipo;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<CardModel> getCards() {
        return cards;
    }

    public void setCards(List<CardModel> cards) {
        this.cards = cards;
    }
}
