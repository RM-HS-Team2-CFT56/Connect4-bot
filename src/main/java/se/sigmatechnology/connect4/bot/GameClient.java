package se.sigmatechnology.connect4.bot;

import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import se.sigmatechnology.connect4.bot.model.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by msk on 2016-11-08.
 */
@Component
public class GameClient {
    private final static Logger LOG = LoggerFactory.getLogger(GameClient.class);
    private static final String CONNECT_PATH = "/Connect";
    private static final String GAME_STATE_PATH = "/getState";
    private static final String GET_NAME = "/GetName";
    private static final String GET_LAST_TURN = "/GetLastTurn";
    private static final String ENTER_DISK = "/enterDisc";
    private String url;

    private RestTemplate template = new RestTemplate();

    @Autowired
    public GameClient(CommandLine commandLine) {
        url = "http://" + commandLine.getOptionValue("url");
    }

    public boolean connect(String name) {
        LOG.info("Trying to connect to game server {}", url);

        Map<String, String> request = new HashMap<String, String>();
        request.put("playerName", name);

        ConnectResponse response = template.postForObject(url + CONNECT_PATH, request, ConnectResponse.class);

        LOG.info(response.toString());

        if (!response.getConnected()) {
            LOG.info(response.getMessage());
            return false;
        } else {
            LOG.info("I'm player {}", response.getId());
            return true;
        }

    }

    public State getState() {
        LOG.info("Trying to get game state");

        StateResponse response = template.getForObject(url + GAME_STATE_PATH, StateResponse.class);

        LOG.info("{} - {}", response.getState(), response.getMessage());

        return State.WAITING_FOR_PLAYER;


    }

    public String enterDisk(int column) {

        LOG.info("Insert disk at colomn {}", column);
        EnterDiskResponse response = template.postForObject(url + ENTER_DISK + File.separator + column, null, EnterDiskResponse.class);

        LOG.info(response.toString());

        if (response.getMessage() == "OK") {
            LOG.info("Enter Disk {}", response.getMessage());
            return response.getMessage();
        } else {

            LOG.info(response.getMessage());
            return response.getMessage();
        }
    }

    public String getName() {

        LOG.info("Get name of player");
        GetNameResponse response = template.getForObject(url + GET_NAME, null, GetNameResponse.class);

        LOG.info(response.toString());

        if (response.getPlayerName() == null) {
            LOG.info(response.getPlayerName().toString());
            return response.getPlayerName();
        } else {
            LOG.info("Player name is {} ", response.getPlayerName());
            return response.getPlayerName();
        }

    }

    public int getLastTurn() {

        LOG.info("Get name last Turn");
        GetLastTurnResponse response = template.getForObject(url + GET_LAST_TURN, null, GetLastTurnResponse.class);
        LOG.info(response.toString());

        if (response.getLastTurn() == null) {
            LOG.info(response.getLastTurn().toString());
            return response.getLastTurn();
        } else {
            LOG.info("Last Turn is {} ", response.getLastTurn());
            return response.getLastTurn();
        }

    }

}

