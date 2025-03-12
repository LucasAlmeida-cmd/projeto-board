package br.com.board.Board.Service;

import br.com.board.Board.Model.BoardColumm;
import br.com.board.Board.Repository.BoardColummRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardColummService {

    @Autowired
    private BoardColummRepository boardColummRepository;

    public BoardColumm create(BoardColumm boardColumm) {
        return boardColummRepository.save(boardColumm);
    }

    public BoardColumm findById(Long id) {
        return boardColummRepository.findById(id).orElse(null);
    }

    public BoardColumm update(BoardColumm boardColumm) {
        return boardColummRepository.save(boardColumm);
    }

    public void delete(Long id) {
        boardColummRepository.deleteById(id);
    }

    public List<BoardColumm> findAll() {
        return boardColummRepository.findAll();
    }









}
