package se.sigmatechnology.connect4.bot;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by msk on 2016-11-08.
 */
public enum State {
    @JsonProperty OPPONENTS_TURN,
    @JsonProperty YOUR_TURN,
    @JsonProperty WAITING_FOR_PLAYER,
    @JsonProperty WON,
    @JsonProperty LOST,
    @JsonProperty DRAW
}
