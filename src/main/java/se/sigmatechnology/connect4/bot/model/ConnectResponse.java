package se.sigmatechnology.connect4.bot.model;

/**
 * Created by msk on 2016-11-10.
 */
public class ConnectResponse {

    private Long id;
    private Boolean connected;
    private String message;

    @Override
    public String toString() {
        return "ConnectResponse{" +
                "ID=" + id +
                ", connected=" + connected +
                ", message='" + message + '\'' +
                '}';
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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