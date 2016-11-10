package se.sigmatechnology.connect4.bot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by msk and bek on 2016-11-08.
 */

/**
 *  Board 6x7
 * 
 *  0.5  1.5  2.5  3.5  4.5  5.5  6.5 
 *  0.4  1.4  2.4  3.4  4.4  5.4  6.4 
 *  0.3  1.3  2.3  3.3  4.3  5.3  6.3
 *  0.2  1.2  2.2  3.2  4.2  5.2  6.2
 *  0.1  1.1  2.1  3.1  4.1  5.1  6.1
 *  0.0  1.0  2.0  3.0  4.0  5.0  6.0
 * 
 */
public class Board {

    private type [][] board;
    
    private int board_column = 7;
    private int board_row =6;
       
    public enum type {
        BLUE, RED, EMPTY
    }
    
    public Board() {
    	 
    	board = new type [board_column][board_row];
    	
        //Initialize all the entire board places with zero value.
    	for(int y = 0; y < board_row; y++)
		{
			for(int x = 0; x < board_column; x++)
			{
				board[x][y] = type.EMPTY;
			}
		}
    }
   
    //Put own disc to specific column of board
    public void putDisc(int column ){
    	
    	for(int y = 0; y < board_row; y++)
		{
		    if(board[column][y] == type.EMPTY){ 	
    		 
		    	board[column][y] = type.BLUE;
		    	break;
		    }		    
			
		}
    	   	
    }
           
   //Put opponent disc to specific column of board
    public void opponentsDisc(int column){
    	for(int y = 0; y < board_row; y++)
		{
    		if(board[column][y] == type.EMPTY){ 	
       		 
		    	board[column][y] = type.RED;
		    	break;
		    }		
			
		}
        
    }
    
    public type[][] getBoard() {
    	return board;
    }

}
