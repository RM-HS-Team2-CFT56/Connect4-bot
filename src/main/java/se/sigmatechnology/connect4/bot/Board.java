package se.sigmatechnology.connect4.bot;

/**
 * Created by msk and bek on 2016-11-08.
 */

import org.springframework.stereotype.Component;

/**
 * Board 6x7
 * <p>
 * 0.5  1.5  2.5  3.5  4.5  5.5  6.5
 * 0.4  1.4  2.4  3.4  4.4  5.4  6.4
 * 0.3  1.3  2.3  3.3  4.3  5.3  6.3
 * 0.2  1.2  2.2  3.2  4.2  5.2  6.2
 * 0.1  1.1  2.1  3.1  4.1  5.1  6.1
 * 0.0  1.0  2.0  3.0  4.0  5.0  6.0
 */
@Component
public class Board {

    private Type[][] board;

    private int board_column = 7;
    private int board_row = 6;

    public Board() {

        board = new Type[board_column][board_row];

        //Initialize all the entire board places with zero value.
        for (int y = 0; y < board_row; y++) {
            for (int x = 0; x < board_column; x++) {
                board[x][y] = Type.EMPTY;
            }
        }
    }

    public Board(int column, int row) {
        board_column = column;
        board_row = row;

        board = new Type[board_column][board_row];

        //Initialize all the entire board places with zero value.
        for (int y = 0; y < board_row; y++) {
            for (int x = 0; x < board_column; x++) {
                board[x][y] = Type.EMPTY;
            }
        }
    }

    //Put own disc to specific column of board
    public void putDisc(int column) {

        for (int y = 0; y < board_row; y++) {
            if (board[column][y] == Type.EMPTY) {

                board[column][y] = Type.BLUE;
                break;
            }

        }

    }

    //Put opponent disc to specific column of board
    public void opponentsDisc(int column) {
        for (int y = 0; y < board_row; y++) {
            if (board[column][y] == Type.EMPTY) {

                board[column][y] = Type.RED;
                break;
            }

        }

    }

    //Getters
    public int GetColumn() {
        return board_column;
    }

    public int GetRow() {
        return board_row;
    }

    public Type[][] getBoard() {
        return board;
    }
    public void setBoard(Type[][] newBoard) {
        board = newBoard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        sb.append("\\ 1 2 3 4 5 6 7");
        sb.append('\n');
        for (int row = board_row - 1; row >= 0; row--) {
            sb.append(board_row - row)
                    .append(" ");
            for (int column = 0; column < board_column; column++) {
                sb.append(board[column][row].toString())
                        .append(" ");
            }
            sb.append("\n");
        }
        sb.append('\n');
        return sb.toString();
    }

    public enum Type {

        BLUE("B"), RED("R"), EMPTY("0");

        String value;

        Type(String val) {
            value = val;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
