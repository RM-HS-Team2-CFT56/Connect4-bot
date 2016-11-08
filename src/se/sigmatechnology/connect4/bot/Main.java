package se.sigmatechnology.connect4.bot;

public class Main {

    public static void main(String[] args) {
        GameClient gameClient = new GameClient();
        Board board = new Board();
        if (gameClient.connect("BOT")) {
            String state = gameClient.getState();
            while (!state.equals("WON") ||
                    !state.equals("LOST")) {
                if (state.equals("TURN")) {
                    int opponentTurn = gameClient.getLastTurn();
                    if (opponentTurn > 0) {
                        board.opponentsDisc(opponentTurn);
                    }
                    int column = AI.getNextTurn(board);
                    board.putDisc(column);
                    gameClient.enterDisk(column);
                } else if (state.equals("WAIT")) {
                    continue;
                }
            }
            System.out.println(state);

        }

    }
}
