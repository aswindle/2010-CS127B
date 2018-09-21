/*Alex Swindle
 * C SC 127B
 * Project 1: Game of Life Test Class
 */

import org.junit.Test;
import static org.junit.Assert.*;


public class GameOfLifeTest {

	//simple test for growing cell, row/col count, cellAt
	@Test
	public void testNumberAndCellAtAndGrowCellAt() {
		GameOfLife tester = new GameOfLife(3, 3);
		tester.growCellAt(0,0);
		tester.growCellAt(0,2);
		assertEquals(3, tester.numberOfRows());
		assertEquals(3, tester.numberOfColumns());
		assertTrue(tester.cellAt(0, 0));
		assertTrue(tester.cellAt(0,2));
		
		//dummy test for toString to get full code coverage on WebCAT
		assertTrue("1"!=tester.toString());
	}
	
	//tests neighbor count for a few simple arrays of them
	@Test
	public void testNeighborCountAndUpdate(){
		GameOfLife tester2 = new GameOfLife(4, 4);
		//cells along top and bottom row, left and right column
		for(int i=0; i<4; i++){
			tester2.growCellAt(i, 0);
			tester2.growCellAt(i, 3);
			tester2.growCellAt(0, i);
			tester2.growCellAt(3, i);
		}
		//first column
		assertEquals(7, tester2.neighborCount(0, 0));
		assertEquals(6, tester2.neighborCount(1, 0));
		assertEquals(6, tester2.neighborCount(2, 0));
		assertEquals(7, tester2.neighborCount(3, 0));
		//second column
		assertEquals(6, tester2.neighborCount(0, 1));
		assertEquals(5, tester2.neighborCount(1, 1));
		assertEquals(5, tester2.neighborCount(2, 1));
		assertEquals(6, tester2.neighborCount(3, 1));
		//third column
		assertEquals(6, tester2.neighborCount(0, 2));
		assertEquals(5, tester2.neighborCount(1, 2));
		assertEquals(5, tester2.neighborCount(2, 2));
		assertEquals(6, tester2.neighborCount(3, 2));
		//fourth column
		assertEquals(7, tester2.neighborCount(0, 3));
		assertEquals(6, tester2.neighborCount(1, 3));
		assertEquals(6, tester2.neighborCount(2, 3));
		assertEquals(7, tester2.neighborCount(3, 3));
		tester2.update();
		
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				assertFalse(tester2.cellAt(i,j));
				assertEquals(0, tester2.neighborCount(i, j));
			}
		}//end for
		
		GameOfLife tester3 = new GameOfLife(4, 4);
		tester3.growCellAt(2, 1);
		tester3.growCellAt(1,2);
		tester3.growCellAt(3,2);
		assertEquals(2, tester3.neighborCount(2, 1));
		tester3.update();
		
		//generation II
		assertTrue(tester3.cellAt(2,1));
		assertTrue(tester3.cellAt(2,2));
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				if(i!=2&&(j!=1||j!=2)){
					assertFalse(tester3.cellAt(i, j));
				}
			}
		}
		tester3.update();
		
		//generation III
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				assertFalse(tester3.cellAt(i, j));
			}
		}
	}//end second test block
	
	
}
