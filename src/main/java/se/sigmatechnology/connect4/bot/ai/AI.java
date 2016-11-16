package se.sigmatechnology.connect4.bot.ai;

import se.sigmatechnology.connect4.bot.Board;

/**
 * Created by msk on 2016-11-10.
 */
public abstract class AI {

    public abstract int getNextTurn(Board board);

    protected boolean checkColumn(Board board, int column) {
        for (int i = 0; i < 6; i++) {
            if (board.getBoard()[column][i] == Board.Type.EMPTY) {
                return true;
            }
        }
        return false;
    }
}
