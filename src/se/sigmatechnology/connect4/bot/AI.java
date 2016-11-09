package se.sigmatechnology.connect4.bot;

import java.lang.Math;

/**
 * Created by msk on 2016-11-08.
 */
public class AI {
	
	public AI(){
		
	}

    public int getNextTurn(Board board) {
    	return randomSolution(board);
    }
    
    private int randomSolution(Board board) {
    	boolean found = false;
    	int test = -1;
    	
    	while(found == false) {
    		test = (int) (Math.random() * 6 ) + 1;
    		
    		if(checkColumn(board, test) == true) {
    			found = true;
    		}
    	}
    	
        return test;
    }
    
    private boolean checkColumn(Board board, int column) {
    	for(int i = 0; i < 6; i++) {
    		/*if(board[column][i] == Board.Type.EMPTY) {
    			return true;
    		}*/
    	}
		return false;
    }
}
