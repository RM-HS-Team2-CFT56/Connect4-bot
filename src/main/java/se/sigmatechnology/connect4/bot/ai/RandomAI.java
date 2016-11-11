package se.sigmatechnology.connect4.bot.ai;

import se.sigmatechnology.connect4.bot.Board;

/**
 * Created by msk on 2016-11-08.
 */
public class RandomAI implements AI {

    public int getNextTurn(Board board) {
        return randomSolution(board);
    }

    private int randomSolution(Board board) {
        boolean found = false;
        int test = -1;

        while (found == false) {
            test = (int) (Math.random() * 6) + 1;

            if (checkColumn(board, test) == true) {
                found = true;
            }
        }

        return test;
    }

    private boolean checkColumn(Board board, int column) {
        for (int i = 0; i < 6; i++) {
            if (board.getBoard()[column][i] == Board.Type.EMPTY) {
                return true;
            }
        }
        return false;
    }
}
