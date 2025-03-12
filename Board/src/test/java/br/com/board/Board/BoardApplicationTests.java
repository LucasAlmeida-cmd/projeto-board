package br.com.board.Board;

import br.com.board.Board.Enum.BoardColummEnum;
import br.com.board.Board.Model.Board;
import br.com.board.Board.Model.BoardColumm;
import br.com.board.Board.Model.CardModel;
import br.com.board.Board.Service.BlockService;
import br.com.board.Board.Service.BoardColummService;
import br.com.board.Board.Service.BoardService;
import br.com.board.Board.Service.CardModelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BoardApplicationTests {
	@Autowired
	private BoardService boardService;

	@Autowired
	private BoardColummService boardColummService;

	@Autowired
	private CardModelService cardModelService;

	@Autowired
	private BlockService blockService;

	@Test
	void adicionandoBoard() {
		List<BoardColumm> listaColumns = new ArrayList<>();
		Board board = new Board("Teste", listaColumns);
		boardService.saveBoard(board);
	}

	@Test
	void adicionandoColunasEmBoardsExistentes(){
		Board board = boardService.getBoardById(1L);
		List<CardModel> listaCard = new ArrayList<>();
		List<CardModel> listaCard2 = new ArrayList<>();
		List<CardModel> listaCard3 = new ArrayList<>();

		BoardColumm boardColumm = new BoardColumm("Teste", BoardColummEnum.INITIAL, 2, board, listaCard);
		BoardColumm boardColumm2 = new BoardColumm("Teste 2", BoardColummEnum.PENDING, 3, board, listaCard2);
		BoardColumm boardColumm3 = new BoardColumm("Teste 3", BoardColummEnum.FINAL, 4, board, listaCard3);

		boardColummService.create(boardColumm2);
		boardColummService.create(boardColumm3);
	}

	@Test
	void adicionandoCards(){
		BoardColumm boardColumm1 = boardColummService.findById(1L);
		CardModel cardModel1 = new CardModel("Tarefa 1 ", "Tarefa 1", boardColumm1);
		CardModel cardModel2 = new CardModel("Tarefa 2 ", "Tarefa 1", boardColumm1);
		CardModel cardModel3 = new CardModel("Tarefa 3 ", "Tarefa 1", boardColumm1);
		cardModelService.create(cardModel1);
		cardModelService.create(cardModel2);
		cardModelService.create(cardModel3);
	}

	@Test
	void bloqueandoCard(){
		blockService.block("Falta de tempo", 1L);
	}

	@Test
	void desbloqueandoCard(){
		blockService.unblock("Conseguimos", 1L);
	}



	@Test
	void buscando(){
		var card = cardModelService.getCardDetails(1L);

		System.out.println("Titulo: "+ card.getTitle() +
							"\nDescrição: "+ card.getDescription() +
							"\nRazão do bloqueio: "+ card.getBlockReason()+
				"\nRazão do desbloqueio: " + card.getUnblockReason());
	}



}
