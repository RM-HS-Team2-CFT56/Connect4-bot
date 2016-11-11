
package se.sigmatechnology.connect4.bot.model;

public class GetLastTurnResponse {
	
	private Integer Column;

    public Integer getLastTurn() {
        return Column;
    }

    public void setLastTurn(int Column) {
        this.Column = Column;
    }

    @Override
    public String toString() {
     
    	return "GetLastTurnResponse{" + "Column='" + Column + "\'}" ;
    }
	
}
