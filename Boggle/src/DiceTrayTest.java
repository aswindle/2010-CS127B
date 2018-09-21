// A unit test for class DiceTray, which is one important part of the final project
//
// 1) Alex Swindle
// 2) Kevin Butler
// DiceTray JUnit test
//
import static org.junit.Assert.*;
import org.junit.Test;

public class DiceTrayTest {
	private char[][] tray = { // Always use upper case letters in the dice tray
	{ 'A', 'B', 'C', 'D' }, { 'E', 'F', 'G', 'H' }, { 'I', 'J', 'K', 'L' },
			{ 'M', 'N', 'O', 'P' } };

	@Test
	public void testStringFindWhenThereStartingInUpperLeftCorner() {
		DiceTray dt = new DiceTray(tray);
		assertTrue(dt.stringFound("AbC")); // Must be case insensitive
		assertTrue(dt.stringFound("aBf"));
		assertTrue(dt.stringFound("abc"));
		assertTrue(dt.stringFound("ABCD"));
		// ...
		assertTrue(dt.stringFound("ABFEJINM"));
		assertTrue(dt.stringFound("AbCdHgFeIjKLpONm"));
		assertTrue(dt.stringFound("ABCDHLPOKJNMIEFG"));
	}

	@Test
	public void testMultipleStartingPoints() {
		char[][] tray2 = { { 'A', 'B', 'C', 'D' }, { 'E', 'F', 'G', 'H' },
				{ 'I', 'J', 'A', 'L' }, { 'M', 'N', 'O', 'P' } };
		DiceTray dt = new DiceTray(tray2);
		assertTrue(dt.stringFound("ALOJF"));
		assertTrue(dt.stringFound("AFA"));
		assertTrue(dt.stringFound("AFAL"));
	}

	@Test
	public void testQU() {
		char[][] tray3 = {  { 'A', 'B', 'C', 'D' },
							{ 'E', 'F', 'G', 'H' },
							{ 'I', 'J', 'Q', 'L' }, 
							{ 'M', 'N', 'O', 'P' } };
		DiceTray dt = new DiceTray(tray3);
		assertTrue(dt.stringFound("QuoLP"));
		assertTrue(dt.stringFound("plonmjqu"));
	}

	@Test
	public void testStringFindWhenNotThere() {
		DiceTray dt = new DiceTray(tray);
		assertFalse(dt.stringFound("acb"));
		assertFalse(dt.stringFound("AiE"));
		// ...
	}

	@Test
	public void testStringFindWhenAttemptIsMadeToUseALetterTwice() {
		DiceTray dt = new DiceTray(tray);
		assertFalse(dt.stringFound("ABA"));
		assertFalse(dt.stringFound("ABB"));
		assertFalse(dt.stringFound("aEa"));
	}

}