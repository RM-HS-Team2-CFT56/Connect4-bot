package se.sigmatechnology.connect4.bot.model;

import se.sigmatechnology.connect4.bot.State;

public class StateResponse {

    private State state;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(State State) {
        this.state = State;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "StateResponse{" + "state='" + state + "\'}";
    }
}