package br.com.board.Board.Repository;

import br.com.board.Board.Model.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlockRepository extends JpaRepository<Block, Long> {


    Block findByCardIdAndUnblockReasonIsNull(Long cardId);
    Block findByCardIdAndUnblockedAtIsNull(Long cardId);

    Block findByCardId(Long cardId);
}
