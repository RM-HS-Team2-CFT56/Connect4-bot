package se.sigmatechnology.connect4.bot.model;

public class getNameResponse {
	private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "GetPlayerNameResponse{" + "playerName='" + playerName + "\'}" ;
    }
}
