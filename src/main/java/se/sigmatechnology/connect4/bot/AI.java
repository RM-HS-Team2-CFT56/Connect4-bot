package se.sigmatechnology.connect4.bot;

import java.lang.Math;

/**
 * Created by msk on 2016-11-08.
 */
public class AI {
	
	int AISelection;
	
	public AI(){
		AISelection = 0;
	}
	public AI(int ai) {
		AISelection = ai;
	}

    public int getNextTurn(Board board) {
    	switch(AISelection) {
    	case 1:
    		return randomSolution(board);
    	default:
    		return -1;
    	}
    	
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
    		if(board.getBoard()[column][i] == Board.type.EMPTY) {
    			return true;
    		}
    	}
		return false;
    }
}
