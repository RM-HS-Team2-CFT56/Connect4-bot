
package se.sigmatechnology.connect4.bot.model;

public class getLastTurnResponse {
	
	private Integer lastTurn;

    public Integer getLastTurn() {
        return lastTurn;
    }

    public void setLastTurn(int lastTurn) {
        this.lastTurn = lastTurn;
    }

    @Override
    public String toString() {
     
    	return "GetLastTurnResponse{" + "lastTurn='" + lastTurn + "\'}" ;
    }
	
}
