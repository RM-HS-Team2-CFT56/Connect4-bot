package se.sigmatechnology.connect4.bot;

import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import se.sigmatechnology.connect4.bot.model.ConnectResponse;
import se.sigmatechnology.connect4.bot.model.StateResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by msk on 2016-11-08.
 */
@Component
public class GameClient {

    private final static Logger LOG = LoggerFactory.getLogger(GameClient.class);
    private static final String CONNECT_PATH = "/connect2Server"; // FIXME: 2016-11-10 temporary path, should be "/connect"
    private static final String GAMESTATE_PATH = "/game";
    private String url;

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

//        RestTemplate template = new RestTemplate();

        StateResponse response = template.postForObject(url + GAMESTATE_PATH, null, StateResponse.class);

        LOG.info(response.toString());

        return response.getState();

    }

    public String enterDisk(int column) {
        return "";//TODO: implement me
    }

    public List<String> getNames() {
        return null;//TODO: implement me
    }

    public int getLastTurn() {
        return -1;//TODO: implement me
    }

}
