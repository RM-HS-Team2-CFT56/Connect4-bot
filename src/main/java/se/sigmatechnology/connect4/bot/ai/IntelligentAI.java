package se.sigmatechnology.connect4.bot.ai;

import se.sigmatechnology.connect4.bot.Board;

public class IntelligentAI extends AI {
	ColumnScore scores;
	Board.Type[][] playfield;
	int nrOfColumns;
	int nrOfRows;
	boolean initAI = true;
	
	@Override
	public int getNextTurn(Board board) {
		if(initAI)
			initAI(board);
        return startAI(board); 
    }
	
	private void initAI(Board board) {
		initAI = false;
		scores = new ColumnScore(board.getColumn());
		playfield = board.getBoard();
		nrOfColumns = board.getColumn();
		nrOfRows = board.getRow();
	}
	
	private int startAI(Board board) {
		scores.resetScores();
		int columnToReturn = -1;
		
		// Do this if it is the first move
		columnToReturn = checkIfFirstMove();
		if(columnToReturn != -1) {
			return columnToReturn;
		}
		
		// Do this if there is a winning move
		columnToReturn = checkWinningMoves();
		if(columnToReturn != -1) {
			return columnToReturn;
		}
		
		// Look for a move to make
		columnToReturn = lookForMove();
		if(columnToReturn != -1) {
			return columnToReturn;
		}
		
		
		return -1;
	}
	
	private int lookForMove() {
		for(int y = 0; y < nrOfColumns; y++) {
			for(int i = 0; i < nrOfRows; i++) {
				if(playfield[y][i] == Board.Type.EMPTY) {
					int score = 0;
					// Up
					if(i != 0) {
						if(playfield[y][i-1] == Board.Type.BLUE) {
							score++;
						}
					}
					// Left
					if(y != 0) {
						if(playfield[y-1][i] == Board.Type.BLUE) {
							score++;
						}
					}
					// Down
					if(i != nrOfRows-1) {
						if(playfield[y][i+1] == Board.Type.BLUE) {
							score++;
						}
					}
					// Right
					if(y != nrOfColumns-1) {
						if(playfield[y+1][i] == Board.Type.BLUE) {
							score++;
						}
					}
					// Diagonal Up & Left
					if(y != 0 && i != 0) {
						if(playfield[y-1][i-1] == Board.Type.BLUE) {
							score++;
						}
					}
					// Diagonal Up & Right
					if(y != nrOfColumns-1 && i != 0) {
						if(playfield[y+1][i-1] == Board.Type.BLUE) {
							score++;
						}
					}
					// Diagonal Down & Right
					if(y != nrOfColumns-1 && i != nrOfRows-1) {
						if(playfield[y+1][i+1] == Board.Type.BLUE) {
							score++;
						}
					}
					// Diagonal Down & Left
					if(y != 0 && i != nrOfRows-1) {
						if(playfield[y-1][i+1] == Board.Type.BLUE) {
							score++;
						}
					}
					
					scores.addScore(y, score);
					i = nrOfRows;
				}
			}
		}
		
		return scores.getColumnWithBestScore();
	}
	
	private int checkWinningMoves() {
		/*for(int y = 0; y < nrOfRows; y++) {
			for(int i = 0; i < nrOfColumns; i++) {
				if(playfield[y][i] == Board.Type.BLUE) {
					//TODO
				}
			}
		}*/
		
		return -1;
	}
	
	private int checkIfFirstMove() {
		boolean firstMove = true;
		for(int i = 0; i < nrOfColumns; i++) {
			if(!(playfield[i][0] == Board.Type.EMPTY)) {
				firstMove = false;
			}
		}
		if(firstMove) {
			return nrOfColumns/2;
		}
		return -1;
	}
	
	private class ColumnScore {
		int[] list;
		
		public ColumnScore(int length) {
			list = new int[length];
		}
		
		public void addScore(int column, int score)  {
			list[column] =+ score;
		}
		
		public void subScore(int column, int score) {
			list[column] =- score;
		}
		
		public int getScore(int column) {
			return list[column];
		}
		public int getColumnWithBestScore() {
			int column = 0;
			for(int i = 1; i < list.length; i++) {
				if(list[i] > list[i-1]) {
					column = i;
				}
			}
			return column;
		}
		public void resetScores() {
			for(int i = 0; i < list.length; i++) {
				list[i] = 0;
			}
		}
	}

}

