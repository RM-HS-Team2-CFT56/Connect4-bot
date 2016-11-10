package se.sigmatechnology.connect4.bot;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    private final static Logger LOG = LoggerFactory.getLogger(Main.class);


    private static CommandLine parseOptions(String[] args) {
        Options options = new Options();
        //Common options
        options.addOption(
                Option.builder("url")
                        .desc("URL of game server")
                        .hasArg()
                        .required()
                        .build());
        options.addOption("help", "print this message");

        //AI options
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(
                Option.builder("randomAI")
                        .desc("AI that randomly selects column")
                        .build());
        options.addOptionGroup(optionGroup);
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (Exception e) {
            LOG.error("Error parsing parameters");
        }
        if (cmd == null || cmd.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar <jar_name> <opts>", options);
            return null;
        }
        return cmd;
    }

    public static void main(String[] args) throws Exception {
        CommandLine cmd = parseOptions(args);
        if (cmd == null) {
            return;
        }
        LOG.info("Application started");
        GameClient gameClient = new GameClient(cmd.getOptionValue("url"));
        Board board = new Board();
        if (gameClient.connect("BOT")) {
            LOG.info("Connection succesfull");
            State state = gameClient.getState();
            LOG.info("State: {}", state);
            while (state != State.WON && state != State.LOST) {
                if (state == state.YOUR_TURN) {
                    int opponentTurn = gameClient.getLastTurn();
                    if (opponentTurn > 0) {
                        board.opponentsDisc(opponentTurn);
                    }
                    int column = AI.getNextTurn(board);
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
}
