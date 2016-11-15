package se.sigmatechnology.connect4.bot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import se.sigmatechnology.connect4.bot.ai.AI;
import se.sigmatechnology.connect4.bot.ai.IntelligentAI;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AITest {
	
	
	@Test
	public void IntelligentFirstMoveTest() throws Exception {
		AI ai = new IntelligentAI();
		Board board = new Board();
		
		assertEquals(ai.getNextTurn(board), 3);
	}
	
	@Test
	public void IntelligentSecondMoveTest() throws Exception {
		AI ai = new IntelligentAI();
		Board board = new Board();
		Board.Type[][] newBoard = board.getBoard();
		newBoard[3][0] = Board.Type.RED;
		board.setBoard(newBoard);
		
		assertEquals(ai.getNextTurn(board), 0);
	}
}
