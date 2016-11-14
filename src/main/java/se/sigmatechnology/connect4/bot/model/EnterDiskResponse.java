package se.sigmatechnology.connect4.bot.model;
public class EnterDiskResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String Message) {
        this.message = Message;
    }

    @Override
    public String toString() {
        return "EnterDiskResponse{" + "message='" + message + "\'}" ;
    }
		
}
