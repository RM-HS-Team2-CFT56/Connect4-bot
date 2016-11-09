package se.sigmatechnology.connect4.bot;

/**
 * Created by msk on 2016-11-08.
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

    int [][] board;
    
    public Board() {
    	board = new int[6][7];
    }

    public void putDisc(int column){
        //TODO: implement me
    }

    public void opponentsDisc(int column){
        //TODO: implement me
    }

}
