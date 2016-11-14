
package se.sigmatechnology.connect4.bot.model;

public class GetLastTurnResponse {
	
	private Integer column;

    public Integer getLastTurn() {
        return column;
    }

    public void setLastTurn(int Column) {
        this.column = Column;
    }

    @Override
    public String toString() {
     
    	return "GetLastTurnResponse{" + "column='" + column + "\'}" ;
    }
	
}
