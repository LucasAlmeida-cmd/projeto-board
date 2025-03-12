package br.com.board.Board.Service;

import br.com.board.Board.Model.Board;
import br.com.board.Board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    public Board getBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    public void updateBoard(Board board) {
        boardRepository.save(board);
    }
}
