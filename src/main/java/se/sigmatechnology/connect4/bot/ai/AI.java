package se.sigmatechnology.connect4.bot.ai;

import se.sigmatechnology.connect4.bot.Board;

/**
 * Created by msk on 2016-11-10.
 */
public interface AI {
    int getNextTurn(Board board);
}
