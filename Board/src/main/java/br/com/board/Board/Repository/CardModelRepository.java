package br.com.board.Board.Repository;

import br.com.board.Board.DTO.CardDetailsDTO;
import br.com.board.Board.Model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CardModelRepository extends JpaRepository<CardModel, Long> {

    public CardModel findByTitle(String title);



    @Query("SELECT new br.com.board.Board.DTO.CardDetailsDTO(" +
            "cm.id, cm.title, cm.description, b.blockedAt, b.blockReason, b.unblockReason, cm.boardColumn.id, bc.nome, " +
            "(SELECT CAST(COUNT(b2.id) AS LONG) FROM Block b2 WHERE b2.card.id = cm.id)) " +
            "FROM CardModel cm " +
            "LEFT JOIN Block b ON b.card.id = cm.id " +
            "JOIN BoardColumm bc ON bc.id = cm.boardColumn.id " +
            "WHERE cm.id = :id")
    CardDetailsDTO findCardDetailsById(@Param("id") Long id);


}
