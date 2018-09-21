import java.util.Random;

public class MineSweeper implements MineSweeperModel {

	private final int EMPTY = 0;
	private final int NUMBER = 1;
	private final int MINE = 2;
	private Tile[][] board;
	private boolean lost;
	private boolean won;
	private int numMines;
	private int rows;
	private int cols;
	private int nonMines;
	private int tilesVisible;

	public MineSweeper(boolean[][] booleanBoard) {
		lost = false;
		won = false;
		rows = booleanBoard.length;
		cols = booleanBoard[0].length;
		board = new Tile[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Tile();
				board[i][j].setCell(i, j);
			}
		}
		numMines = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (booleanBoard[row][col] == true) {
					board[row][col].setType(MINE);
					numMines++;
				}
			}
		}
		nonMines = rows * cols - numMines;
		tilesVisible = 0;
		countNeighbors();

	}

	public MineSweeper(int newRows, int newColumns, int totalMines) {
		lost = false;
		won = false;
		rows = newRows;
		cols = newColumns;
		board = new Tile[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Tile();
				board[i][j].setCell(i, j);
			}
		}
		Random generator = new Random();
		int minesPlaced = 1;
		if (totalMines > 0) {
			while (minesPlaced <= totalMines) {
				int r = generator.nextInt(rows);
				int c = generator.nextInt(cols);
				if (board[r][c].getType() != MINE) {
					board[r][c].setType(MINE);
					minesPlaced++;
				}
			}
		}
		numMines = totalMines;
		nonMines = rows * cols - numMines;
		tilesVisible = 0;
		countNeighbors();
	}

	public void click(int row, int col) {
		OurStack<Tile> stack = new LinkedStack<Tile>();
		Tile current = board[row][col];
		if (current.getType() == MINE) {
			lost = true;
		}
		if (current.isVisible() == true || current.isFlagged() == true) {
			return;
		} else if (current.getType() == NUMBER) {
			current.setVisible();
			tilesVisible++;
			return;
		} else {
			current.setVisible();
			stack.push(current);
			tilesVisible++;
			while (stack.isEmpty() == false) {
				current = stack.pop();
				row = current.getRow();
				col = current.getCol();
				if (current.getType() == EMPTY) {
					// check top left
					if (row - 1 >= 0 && col - 1 >= 0) {
						if (board[row - 1][col - 1].isVisible() == false
								&& board[row - 1][col - 1].isFlagged() == false) {
							board[row - 1][col - 1].setVisible();
							tilesVisible++;
							stack.push(board[row - 1][col - 1]);
						}
					}
					// check left
					if (col - 1 >= 0) {
						if (board[row][col - 1].isVisible() == false
								&& board[row][col - 1].isFlagged() == false) {
							board[row][col - 1].setVisible();
							tilesVisible++;
							stack.push(board[row][col - 1]);
						}
					}
					// check bottom-left
					if (row + 1 < rows && col - 1 >= 0) {
						if (board[row + 1][col - 1].isVisible() == false
								&& board[row + 1][col - 1].isFlagged() == false) {
							board[row + 1][col - 1].setVisible();
							tilesVisible++;
							stack.push(board[row + 1][col - 1]);
						}
					}
					// check bottom
					if (row + 1 < rows) {
						if (board[row + 1][col].isVisible() == false
								&& board[row + 1][col].isFlagged() == false) {
							board[row + 1][col].setVisible();
							tilesVisible++;
							stack.push(board[row + 1][col]);
						}
					}
					// check bottom-right
					if (row + 1 < rows && col + 1 < cols) {
						if (board[row + 1][col + 1].isVisible() == false
								&& board[row + 1][col + 1].isFlagged() == false) {
							board[row + 1][col + 1].setVisible();
							tilesVisible++;
							stack.push(board[row + 1][col + 1]);
						}
					}
					// check right
					if (col + 1 < cols) {
						if (board[row][col + 1].isVisible() == false
								&& board[row][col + 1].isFlagged() == false) {
							board[row][col + 1].setVisible();
							tilesVisible++;
							stack.push(board[row][col + 1]);
						}
					}
					// check top-right
					if (row - 1 >= 0 && col + 1 < cols) {
						if (board[row - 1][col + 1].isVisible() == false
								&& board[row - 1][col + 1].isFlagged() == false) {
							board[row - 1][col + 1].setVisible();
							tilesVisible++;
							stack.push(board[row - 1][col + 1]);
						}
					}
					// check top
					if (row - 1 >= 0) {
						if (board[row - 1][col].isVisible() == false
								&& board[row - 1][col].isFlagged() == false) {
							board[row - 1][col].setVisible();
							tilesVisible++;
							stack.push(board[row - 1][col]);
						}
					}

				}// end if EMPTY
			}// end while loop
		}// end empty else
	}// end click method

	public int getAdjacentMines(int row, int column) {
		return board[row][column].getNeighbors();
	}

	public String toString() {
		String toString = "+";
		for (int i = 0; i < cols; i++) {
			toString += "-";
		}
		toString += "+" + '\n';
		for (int r = 0; r < rows; r++) {
			toString += "|";
			for (int c = 0; c < cols; c++) {
				if (board[r][c].isFlagged()) {
					toString += "F";
				} else if (board[r][c].isVisible()) {
					if (board[r][c].getType() == EMPTY) {
						toString += "0";
					} else {
						toString += board[r][c].getNeighbors();
					}
				} else {
					toString += " ";
				}
			}
			toString += "|" + '\n';
		}
		toString += "+";
		for (int i = 0; i < rows; i++) {
			toString += "-";
		}
		toString += "+";

		return toString;
	}

	public int getTotalMineCount() {
		return numMines;
	}

	public boolean isMine(int row, int column) {
		return board[row][column].isMine();
	}

	public boolean isVisible(int row, int column) {
		return board[row][column].isVisible();
	}

	public boolean isFlagged(int row, int column) {
		return board[row][column].isFlagged();
	}

	public void toggleFlagged(int row, int column) {
		Tile toggled = board[row][column];
		boolean flagged = toggled.isFlagged();
		if (flagged) {
			toggled.setFlagged(false);
		} else {
			toggled.setFlagged(true);
		}
	}

	public boolean lost() {
		return lost;
	}

	public boolean won() {
		if (tilesVisible == nonMines) {
			won = true;
		}
		return won;
	}

	private void countNeighbors() {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				int neighbors = 0;
				// check top left
				if (row - 1 >= 0 && col - 1 >= 0) {
					if (board[row - 1][col - 1].getType() == MINE) {
						neighbors++;
					}
				}
				// check left
				if (col - 1 >= 0) {
					if (board[row][col - 1].getType() == MINE) {
						neighbors++;
					}
				}
				// check bottom-left
				if (row + 1 < rows && col - 1 >= 0) {
					if (board[row + 1][col - 1].getType() == MINE) {
						neighbors++;
					}
				}
				// check bottom
				if (row + 1 < rows) {
					if (board[row + 1][col].getType() == MINE) {
						neighbors++;
					}
				}
				// check bottom-right
				if (row + 1 < rows && col + 1 < cols) {
					if (board[row + 1][col + 1].getType() == MINE) {
						neighbors++;
					}
				}
				// check right
				if (col + 1 < cols) {
					if (board[row][col + 1].getType() == MINE) {
						neighbors++;
					}
				}
				// check top-right
				if (row - 1 >= 0 && col + 1 < cols) {
					if (board[row - 1][col + 1].getType() == MINE) {
						neighbors++;
					}
				}
				// check top
				if (row - 1 >= 0) {
					if (board[row - 1][col].getType() == MINE) {
						neighbors++;
					}
				}
				board[row][col].setNeighbors(neighbors);
				if (neighbors > 0 && board[row][col].getType() != MINE) {
					board[row][col].setType(NUMBER);
				}
			}
		}

	}
}