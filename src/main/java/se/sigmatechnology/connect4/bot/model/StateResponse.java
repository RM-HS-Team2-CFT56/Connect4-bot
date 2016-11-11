package se.sigmatechnology.connect4.bot.model;
import se.sigmatechnology.connect4.bot.State;

public class StateResponse {
	
    private State State;
   
    public State getState() {
        return State;
    }

    public void setMessage(State State) {
        this.State = State;
    }

    @Override
    public String toString() {
    	 return "StateResponse{" + "State='" + State + "\'}" ;
    }
}