/**
 * ObstacleCourse: A type that reads a text file representing an obstacle
 * course from which to escape. This does not find the shorted path.    
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ObstacleCourse implements ObstacleCourseInterface {

  public static void main(String[] args) {
    ObstacleCourse oc = new ObstacleCourse("left.txt");
    System.out.print(oc);
    System.out.println("Start row: " + oc.getStartRow());
    System.out.println("Start row: " + oc.getStartColumn());
    oc.findTheExit(oc.getStartRow(), oc.getStartColumn());
    System.out.println("\n-------After findTheExit---------\n");
    System.out.println(" Exit row: " + oc.getExitRow());
    System.out.println(" Exit col: " + oc.getExitColumn());
    System.out.println(oc);
  }

  protected char[][] course;

  private int sRow;

  private int sCol;

  private int foundRow;

  private int foundCol;

  private static final char PART_OF_PATH = 'O';

  private static final char TRIED = '.';

  public ObstacleCourse(String fileName) {
    foundRow = -1;
    foundCol = -1;
    initializeCourseWith(fileName);
  }

  /**
   * Initializes the 2d char array course.
   */
  private void initializeCourseWith(String fileName) {

    Scanner obstacleCourseFile = null;
    try {
      obstacleCourseFile = new Scanner(new File(fileName));
    }
    catch (FileNotFoundException e) {
    }

    int rows = obstacleCourseFile.nextInt();
    int columns = obstacleCourseFile.nextInt();

    // Get to the next line to read in maze line by line
    String line = obstacleCourseFile.nextLine();
    course = new char[rows][columns];
    for (int r = 0; r < rows; r++) {
      line = obstacleCourseFile.nextLine(); // read to end of line, end
      for (int i = 0; i < columns; i++) { // of line discarded
        course[r][i] = line.charAt(i);
        if (line.charAt(i) == 'S') {
          sRow = r;
          sCol = i;
        }
      }
    }
  }

  /**
   * Returns the start column in the array
   */
  public int getStartColumn() {
    return sCol;
  }

  /**
   * Returns the starting row in the array
   */
  public int getStartRow() {
    return sRow;
  }

  public int getExitColumn() {
    return foundCol;
  }

  public int getExitRow() {
    return foundRow;
  }

  /**
   * Returns a string representation of the array
   */
  public String toString() {
    String result = "";
    for (int i = 0; i < course.length; i++) {
      for (int j = 0; j < course[0].length; j++) {
        result += course[i][j];
      }
      result += "\n";
    }
    return result;
  }

  /**
   * Finds the exit from the 2-D array.  
   * You must use method possible to be implemented below.
   */
  public boolean findTheExit(int row, int col) {
    boolean escaped = false;
    if(possible(row, col)){
    	course[row][col] = TRIED;
    	if(row==0||row==course.length-1||col==0||col==course[row].length-1){
    		escaped = true;
    		foundRow = row;
    		foundCol = col;
    	}
    	else {
    		escaped = findTheExit(row+1, col);
    		if(!escaped) escaped = findTheExit(row, col+1);
    		if(!escaped) escaped = findTheExit(row-1, col);
    		if(!escaped) escaped = findTheExit(row, col-1);
    	}
    	if(escaped){ 
    		course[row][col] = PART_OF_PATH;
    		
    	}
    }
    return escaped;
  }

  /**
   * Returns a true if the given row and col represent a location
   * in the 2D array that can be tried (and is in range).
   */
  public boolean possible(int row, int col) {
    return (course[row][col] != '+') && (course[row][col] != TRIED);
  }

}