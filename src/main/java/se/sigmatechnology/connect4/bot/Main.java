package se.sigmatechnology.connect4.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    private final static Logger LOG = LoggerFactory.getLogger(Main.class);

    @Autowired
    GameClient gameClient;

    public static void main(String[] args) throws Exception {
        LOG.info("Application started");
        GameClient gameClient = new GameClient();
        Board board = new Board();
        if (gameClient.connect("BOT")) {
            State state = gameClient.getState();
            while (state != State.WON && state != State.LOST) {
                System.out.println(state);
                if (state == state.YOUR_TURN) {
                    int opponentTurn = gameClient.getLastTurn();
                    if (opponentTurn > 0) {
                        board.opponentsDisc(opponentTurn);
                    }
                    int column = AI.getNextTurn(board);
                    board.putDisc(column);
                    gameClient.enterDisk(column);
                } else if (state == State.WAITING_FOR_PLAYER || state == State.OPPONENTS_TURN) {
                    Thread.sleep(1000);
                    continue;
                }
                state = gameClient.getState();
            }
        }
    }
}
