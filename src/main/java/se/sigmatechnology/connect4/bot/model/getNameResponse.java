package se.sigmatechnology.connect4.bot.model;

import java.util.List;

public class getNameResponse {
	private List<String> playerName;

    public List<String> getPlayerName() {
        return playerName;
    }

    public void setPlayerName(List<String> playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "GetPlayerNameResponse{" + "playerName='" + playerName + "\'}" ;
    }
}
