package se.sigmatechnology.connect4.bot.model;
public class EnterDiskResponse {

    private String Message;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    @Override
    public String toString() {
        return "EnterDiskResponse{" + "Message='" + Message + "\'}" ;
    }
		
}
