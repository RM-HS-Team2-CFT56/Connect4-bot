package se.sigmatechnology.connect4.bot;

import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import se.sigmatechnology.connect4.bot.ai.AI;

@SpringBootApplication(exclude = {EmbeddedServletContainerAutoConfiguration.class, WebMvcAutoConfiguration.class})
public class Main implements CommandLineRunner {

    private final static Logger LOG = LoggerFactory.getLogger(Main.class);

    @Autowired
    private AI ai;
    @Autowired
    private CommandLine cmd;

    public static void main(String... args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    public void gameLogic() throws Exception {
        if (cmd == null) {
            return;
        }
        LOG.info("Application started");
        LOG.info("AI initialized with {}", ai);
        GameClient gameClient = new GameClient(cmd.getOptionValue("url"));
        Board board = new Board();
        if (gameClient.connect("BOT")) {
            LOG.info("Connection successful");
            State state = gameClient.getState();
            LOG.info("State: {}", state);
            while (state != State.WON && state != State.LOST) {
                if (state == state.YOUR_TURN) {
                    int opponentTurn = gameClient.getLastTurn();
                    if (opponentTurn > 0) {
                        board.opponentsDisc(opponentTurn);
                    }
                    int column = ai.getNextTurn(board);
                    board.putDisc(column);
                    gameClient.enterDisk(column);
                } else if (state == State.WAITING_FOR_PLAYER || state == State.OPPONENTS_TURN) {
                    LOG.info("Waiting...");
                    Thread.sleep(1000);
                    continue;
                }
                state = gameClient.getState();
                LOG.info("State: {}", state);
            }
        } else {
            LOG.error("Connection failed");
        }
    }


    @Override
    public void run(String... strings) throws Exception {
        gameLogic();
    }
}
