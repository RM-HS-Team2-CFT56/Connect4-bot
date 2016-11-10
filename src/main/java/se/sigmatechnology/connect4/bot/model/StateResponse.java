package se.sigmatechnology.connect4.bot.model;
import se.sigmatechnology.connect4.bot.State;

public class StateResponse {
	
    private State state;
   
    public State getState() {
        return state;
    }

    public void setMessage(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StateResponse{" + "state=" + state + '}';
    }
}