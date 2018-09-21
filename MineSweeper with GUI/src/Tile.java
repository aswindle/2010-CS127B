public class Tile {

	private final int EMPTY = 0;
	private final int NUMBER = 1;
	private final int MINE = 2;
	private int type;
	private boolean visible;
	private int neighbors;
	private boolean flagged;
	private int row;
	public int col;

	public Tile() {
		type = EMPTY;
		visible = false;
		neighbors = 0;
		flagged = false;
	}

	public void setType(int newType) {
		type = newType;
	}

	public void setNeighbors(int setNeighbor) {
		neighbors = setNeighbor;
	}

	public void setVisible() {
		visible = true;
	}

	public void setFlagged(boolean flag) {
		flagged = flag;
	}

	public boolean isVisible() {
		return visible;
	}

	public boolean isMine() {
		if (type == MINE) {
			return true;
		}
		return false;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public int getNeighbors() {
		return neighbors;
	}

	public int getType() {
		return type;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public void setCell(int r, int c){
		row = r;
		col = c;
	}
}
