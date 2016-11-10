package se.sigmatechnology.connect4.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import se.sigmatechnology.connect4.bot.model.ConnectResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by msk on 2016-11-08.
 */

public class GameClient {

    private final static Logger LOG = LoggerFactory.getLogger(GameClient.class);
    private static final String CONNECT_PATH = "/connect2Server"; // FIXME: 2016-11-10 temporary path, should be "/connect"
    private String url;

    public GameClient(String urlToConnect) {
        url = "http://" + urlToConnect;
    }

    public boolean connect(String name) {
        LOG.info("Trying to connect to game server {}", url);

        RestTemplate template = new RestTemplate();

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
        return State.LOST; //TODO: implement me
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
