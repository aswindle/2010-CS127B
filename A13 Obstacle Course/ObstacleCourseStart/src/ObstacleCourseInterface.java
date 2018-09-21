public interface ObstacleCourseInterface {

    /*
     * THE RECURSIVE-BACKTRACKING method which exhaustively searches the maze
     * for an exit. Returns: TRUE to the caller if at the current level, it
     * found an exit OR false, if it can't go anywhere else from the current
     * position
     */
    public boolean findTheExit(int row, int col);

    /*
     * Used to determine whether you can move into array[row][col]. It can only
     * move into that cell if it is not a wall and the position has not already
     * been tried. Returns true if you can move in, false if not.
     */
    public boolean possible(int row, int col);

    /*
     * Returns the start row for the pacman. Determined by reading in the input
     * file and searching for the 'S'
     */

    /* Return a textual representation of the maze */
    public String toString();

    // Some getter methods needed by the GUI and unit test

    /*
     * Returns the start row for this obstacle course. Determined by reading in
     * the input file and searching for the 'S'.
     */
    public int getStartRow();

    /*
     * Returns the start column for the start position. Determined by reading in
     * the input file and searching for the 'S'.
     */
    public int getStartColumn();

    /*
     * Returns the row of the found exit. Return -1 before trying or and if no
     * exit was found after trying. There may be more than exit, but this method
     * must return the row where the exit was found that terminates findTheExit.
     */
    public int getExitRow();

    /*
     * Returns the column of the found exit. Return -1 before trying or and if no
     * exit was found after trying. There may be more than exit, but this method
     * must return the row where the exit was found that terminates findTheExit.
     */
    public int getExitColumn();
}