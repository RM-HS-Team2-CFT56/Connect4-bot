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
    private static final String CONNECT_PATH = "/connect2Server"; // FIXME: 2016-11-10 temporary path, should be "/connect"
    private static final String GAMESTATE_PATH = "/game";
    private static final String PLAYER_NAME = "/game/Player";
    private static final String LAST_TURN = "/game/Turn";
    private String url;
    private int column;
    private RestTemplate template = new RestTemplate();

    @Autowired
    public GameClient(CommandLine commandLine) {
        url = "http://" + commandLine.getOptionValue("url");
    }

    public boolean connect(String name) {
        LOG.info("Trying to connect to game server {}", url);

        Map<String, String> request = new HashMap<String, String>();
        request.put("name", name);

        ConnectResponse response = template.postForObject(url + CONNECT_PATH, request, ConnectResponse.class);

        LOG.info(response.toString());

        if (response.getId() == null) {
            LOG.info(response.getMessage());
            return false;
        } else {
            LOG.info("I'm player {}", response.getId());
            return true;
        }

    }

    public State getState() {
        LOG.info("Trying to get game state");

        StateResponse response = template.postForObject(url + GAMESTATE_PATH, null, StateResponse.class);

        LOG.info(response.toString());

        if (response.getState() == null) {
            LOG.info(response.getState().toString());
            return response.getState();
        } else {
            LOG.info("Current game state {} ", response.getState());
            return response.getState();
        }


    }

    public String enterDisk(int column) {

        LOG.info("Insert disk at colomn {}", column);
        EnterDiskResponse response = template.postForObject(url + GAMESTATE_PATH + File.separator + column, null, EnterDiskResponse.class);

        LOG.info(response.toString());

        if (response.getMessage() == "OK") {
            LOG.info("Enter Disk", response.getMessage()); //FIXME missing {} in log
            return response.getMessage();
        } else {

            LOG.info(response.getMessage());
            return response.getMessage();
        }
    }

    public String getName() {

        LOG.info("Get name of player");
        getNameResponse response = template.getForObject(url + PLAYER_NAME, null, getNameResponse.class); //FIXME Class name should be CamelCase

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
        getLastTurnResponse response = template.getForObject(url + LAST_TURN, null, getLastTurnResponse.class);  //FIXME Class name should be CamelCase

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

