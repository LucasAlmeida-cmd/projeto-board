package br.com.board.Board.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardColumm> columns;

    public Board(String nome, List<BoardColumm> columns) {
        this.nome = nome;
        this.columns = columns;
    }
    public Board(){}

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

    public List<BoardColumm> getColumns() {
        return columns;
    }

    public void setColumns(List<BoardColumm> columns) {
        this.columns = columns;
    }
}
