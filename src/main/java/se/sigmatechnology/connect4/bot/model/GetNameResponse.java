package se.sigmatechnology.connect4.bot.model;

public class GetNameResponse {
	private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String PlayerName) {
        this.playerName = PlayerName;
    }

    @Override
    public String toString() {
        return "GetPlayerNameResponse{" + "playerName='" + playerName + "\'}" ;
    }
}
