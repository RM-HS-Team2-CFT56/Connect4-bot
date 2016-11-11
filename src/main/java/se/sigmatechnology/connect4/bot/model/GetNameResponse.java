package se.sigmatechnology.connect4.bot.model;

public class GetNameResponse {
	private String PlayerName;

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String PlayerName) {
        this.PlayerName = PlayerName;
    }

    @Override
    public String toString() {
        return "GetPlayerNameResponse{" + "PlayerName='" + PlayerName + "\'}" ;
    }
}
