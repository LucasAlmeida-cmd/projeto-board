package br.com.board.Board.Repository;

import br.com.board.Board.Model.BoardColumm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardColummRepository extends JpaRepository<BoardColumm, Long> {
}
