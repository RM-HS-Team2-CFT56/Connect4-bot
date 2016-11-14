package se.sigmatechnology.connect4.bot.model;

/**
 * Created by msk on 2016-11-10.
 */
public class ConnectResponse {

    private Long ID;
    private Boolean connected;
    private String message;

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    @Override
    public String toString() {
        return "ConnectResponse{" +
                "id='" + +'\'' +
                ", connected=" + connected +
                ", message='" + message + '\'' +
                '}';
    }

    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String Message) {
        this.message = Message;
    }


}
//        {
//        "id": "2",
//        "message": " Hej Max, you are  player two"
//        }