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
    private final static int SECOND = 1000;

    @Autowired
    private AI ai;
    @Autowired
    private CommandLine cmd;
    @Autowired
    private GameClient gameClient;
    @Autowired
    private Board board;


    public static void main(String... args) throws Exception {
        Logger root = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

        SpringApplication.run(Main.class, args);
    }

    public void run(String... strings) throws Exception {
        if (cmd == null) {
            return;
        }
        LOG.info("Application started");
        LOG.info("Using AI {}", ai);

        String name = getName();
        LOG.info("My name is {}", name);
        if (gameClient.connect(name)) {
            boolean checkLastTurn = false;
            LOG.info("Connection successful");
            State state = waitUntilSecondPlayerConnected();
            getOpponentsName();
            while (state != State.WON && state != State.LOST && state != State.DRAW) {
                if (state == state.YOUR_TURN) {
                    LOG.info("It's my turn");
                    updateBoardWithOpponentsDecision();
                    checkLastTurn = false;
                    makeMineDecision();
                    LOG.info("Board state {}", board.toString());
                } else if (state == State.OPPONENTS_TURN) {
                    checkLastTurn = true;
                    LOG.info("Waiting for opponent...");
                    Thread.sleep(SECOND);
                }
                state = gameClient.getState();
                LOG.debug("State: {}", state);
            }
            if (checkLastTurn) {
                updateBoardWithOpponentsDecision();
            }
            LOG.info("Result: {}", state);
            LOG.info("Final state {}", board.toString());
        } else {
            LOG.error("Connection failed");
        }
    }

    private State waitUntilSecondPlayerConnected() throws InterruptedException {
        State state;
        while ((state = gameClient.getState()) == State.WAITING_FOR_PLAYER) {
            LOG.debug("State: {}", state);
            LOG.info("Waiting for player 2...");
            Thread.sleep(SECOND);

        }
        return state;
    }

    private void getOpponentsName() {
        String opponentsName = gameClient.getName();
        LOG.info("Opponent {}", opponentsName);
    }

    private void updateBoardWithOpponentsDecision() {
        int opponentTurn = gameClient.getLastTurn();
        if (opponentTurn < 0) {
            LOG.info("It's first turn");
        } else {
            LOG.info("Opponents choice {}", opponentTurn);
            board.opponentsDisc(opponentTurn);
        }
    }

    private void makeMineDecision() {
        int column = ai.getNextTurn(board);
        LOG.info("My Choice {}", column);
        board.putDisc(column);
        gameClient.enterDisk(column);
    }


    private String getName() {
        String name = cmd.getOptionValue("name");
        if (name == null || name.isEmpty()) {
            return "BOT";
        } else {
            return name;
        }
    }
}
