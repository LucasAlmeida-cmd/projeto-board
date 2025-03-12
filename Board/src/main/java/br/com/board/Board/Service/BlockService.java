package br.com.board.Board.Service;

import br.com.board.Board.Model.Block;
import br.com.board.Board.Model.CardModel;
import br.com.board.Board.Repository.BlockRepository;
import br.com.board.Board.Repository.CardModelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class BlockService {

    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    private CardModelRepository cardModelRepository;

    public void block(String reason, Long cardId) {
        CardModel card = cardModelRepository.findById(cardId)
                .orElseThrow(() -> new EntityNotFoundException("Card not found"));

        Block block = blockRepository.findByCardId(cardId);

        if (block == null) {

            block = new Block();
            block.setCard(card);
        } else {

            if (block.getUnblockedAt() != null) {

                block.setUnblockedAt(null);
                block.setUnblockReason(null);
            }
        }


        block.setBlockedAt(OffsetDateTime.now());
        block.setBlockReason(reason);


        blockRepository.save(block);
    }





    public void unblock(String reason, Long cardId) {
        CardModel card = cardModelRepository.findById(cardId)
                .orElseThrow(() -> new EntityNotFoundException("Card not found"));

        Block block = blockRepository.findByCardIdAndUnblockedAtIsNull(cardId);

        if (block == null) {
            throw new EntityNotFoundException("Block not found for the card");
        }

        block.setUnblockedAt(OffsetDateTime.now());
        block.setUnblockReason(reason);
        block.setBlockReason(null);
        block.setBlockedAt(null);

        blockRepository.save(block);
    }


    public void delete(Long id){
        blockRepository.deleteById(id);
    }



}
