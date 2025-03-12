package br.com.board.Board;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

	//Comando no SQL para verificar integridade dos dados:

//	SELECT b.ID AS Board_ID, b.NOME AS Board_Nome,
//	bc.ID AS Coluna_ID, bc.NOME AS Coluna_Nome,
//	c.ID AS Card_ID, c.TITLE AS Card_Titulo
//	FROM BOARD b
//	LEFT JOIN COLUNA_QUADRO bc ON b.ID = bc.BOARD_ID
//	LEFT JOIN CARD_MODEL c ON bc.ID = c.BOARD_COLUMN_ID;

//	@Override
//	public void run(String... args) throws Exception {
//
//	}
}
