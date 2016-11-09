package se.sigmatechnology.connect4.bot;

public class Main {


    GameClient gameClient;

    public static void main(String[] args) throws Exception {
        GameClient gameClient = new GameClient();
        Board board = new Board();
        if (gameClient.connect("BOT")) {
            State state = gameClient.getState();
            while (state != State.WON && state != State.LOST) {
                System.out.println(state);
                if (state == state.YOUR_TURN) {
                    int opponentTurn = gameClient.getLastTurn();
                    if (opponentTurn > 0) {
                        board.opponentsDisc(opponentTurn);
                    }
                    int column = AI.getNextTurn(board);
                    board.putDisc(column);
                    gameClient.enterDisk(column);
                } else if (state.equals("WAIT")) {
                    Thread.sleep(1000);
                    continue;
                }
            }


        }

    }
}
