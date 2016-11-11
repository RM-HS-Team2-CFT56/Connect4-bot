package se.sigmatechnology.connect4.bot.model;

/**
 * Created by msk on 2016-11-10.
 */
public class ConnectResponse {
    private Integer ID;
    private String Message;

    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    @Override
    public String toString() {
        return "ConnectResponse{" +
                "ID=" + ID +
                ", Message='" + Message + '\'' +
                '}';
    }
}
