/*
 * Alex Swindle
 * Kevin Butler
 * Boggle JUnit Test
 */

import static org.junit.Assert.*;

import org.junit.Test;


public class BoggleTest {

	@Test
	public void TestGetWordsFoundAndOtherStuffWithSetTray(){
		char[][]tray = {
				{ 'E', 'R', 'H', 'I' },
				{ 'T', 'C', 'O', 'Z' },
				{ 'I', 'E', 'S', 'E' },
				{ 'V', 'E', 'V', 'W' } };
		DiceTray dt = new DiceTray(tray);
		Boggle game = new Boggle();
		game.setDiceTray(dt);
		game.addGuess("see");
		game.addGuess("see");
		game.addGuess("see");
		game.addGuess("tEeS");
		game.addGuess("Receives");
		game.addGuess("Sort");
		game.addGuess("cites");
		game.addGuess("seCreTive");
		game.addGuess("NotHere");
		game.addGuess("NotHere");
		game.addGuess("sew");
		
		assertEquals(28, game.getScore());
		assertEquals("[cites, receives, secretive, see, sew, sort, tees]",
				game.getWordsFound().toString());
		assertEquals("[nothere]", game.getWordsIncorrect().toString());
		assertTrue(game.getWordsNotGuessed().contains("secret"));
		assertTrue(game.getWordsNotGuessed().contains("recite"));
	}
	
	@Test
	public void testOtherTray(){
		char[][]tray = {
				{ 'M', 'B', 'T', 'R' },
				{ 'E', 'E', 'G', 'A' },
				{ 'Q', 'T', 'N', 'C' },
				{ 'R', 'I', 'O', 'P' } };
		DiceTray dt = new DiceTray(tray);
		Boggle game = new Boggle();
		game.setDiceTray(dt);
		game.addGuess("aconite");
		game.addGuess("GRANITE");
		game.addGuess("qUintet");
		game.addGuess("argent");
		game.addGuess("blah");
		game.addGuess("aaaa");
		game.getScore();
		assertTrue(game.getWordsFound().contains("granite"));
		assertTrue(game.getWordsFound().contains("aconite"));
		assertTrue(game.getWordsFound().contains("quintet"));
		game.getDiceTrayAsString();
	}
}
