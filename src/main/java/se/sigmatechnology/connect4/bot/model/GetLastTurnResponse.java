package se.sigmatechnology.connect4.bot.model;

public class GetLastTurnResponse {

    private Integer column;

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    @Override
    public String toString() {

        return "GetLastTurnResponse{" + "column='" + column + "\'}";
    }

}
