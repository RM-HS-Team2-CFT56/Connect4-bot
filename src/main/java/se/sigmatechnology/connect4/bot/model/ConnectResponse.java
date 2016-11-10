package se.sigmatechnology.connect4.bot.model;

/**
 * Created by msk on 2016-11-10.
 */
public class ConnectResponse {
    private Integer id;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ConnectResponse{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
