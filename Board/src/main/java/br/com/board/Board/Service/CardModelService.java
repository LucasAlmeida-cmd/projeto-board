package br.com.board.Board.Service;

import br.com.board.Board.DTO.CardDetailsDTO;
import br.com.board.Board.Model.CardModel;
import br.com.board.Board.Repository.CardModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardModelService {

    @Autowired
    private CardModelRepository cardModelRepository;

    public void create(CardModel card){
        cardModelRepository.save(card);
    }

    public void delete(Long id){
        cardModelRepository.deleteById(id);
    }

    public List<CardModel> listarTodos(){
        return cardModelRepository.findAll();
    }


    public CardDetailsDTO getCardDetails(Long cardId) {
        return cardModelRepository.findCardDetailsById(cardId);
    }

    public CardModel buscarPorTitulo(String titulo){
        return cardModelRepository.findByTitle(titulo);
    }

    public CardModel uptade(String titulo, CardModel cardModel){
        CardModel existingCard = buscarPorTitulo(titulo);
        existingCard.setDescription(cardModel.getDescription());
        existingCard.setTitle(cardModel.getTitle());
        existingCard.setBoardColumn(cardModel.getBoardColumn());
        try {
            return cardModelRepository.save(existingCard);
        }catch (RuntimeException e){
            System.err.println("Erro ao atualizar o card: " + e.getMessage());
            throw new RuntimeException("Falha ao atualizar o card.", e);
        }

    }


}
