package se.sigmatechnology.connect4.bot.model;

/**
 * Created by msk on 2016-11-10.
 */
public class ConnectResponse {
    private Integer id;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ConnectResponse{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
