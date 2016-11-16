package se.sigmatechnology.connect4.bot.ai;

import se.sigmatechnology.connect4.bot.Board;

/**
 * Created by msk on 2016-11-16.
 */
public class ColumnFillAI extends AI {

    int currentColumn = 0;

    @Override
    public int getNextTurn(Board board) {
        if (!checkColumn(board, currentColumn)) {
            currentColumn++;
        }
        return currentColumn;
    }

}

