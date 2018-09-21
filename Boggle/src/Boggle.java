/*
 * Alex Swindle
 * Kevin Butler
 * Boggle Iteration 2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Boggle {

	//instance vars; 
	private DiceTray tray;
	private int score;
	private ArrayList<String> wordsPossible;
	private ArrayList<String> wordsRight;
	private ArrayList<String> wordsWrong;
	
	//Creates new random DiceTray, sets up lists, and builds possible word list
	public Boggle(){
		tray = new DiceTray();
		score = 0;
		wordsPossible = new ArrayList<String>(1);
		wordsWrong = new ArrayList<String>(1);
		wordsRight = new ArrayList<String>(1);
		buildPossible();
	}
	
	//Allows the game to be played with a set tray
	//Clears out and rebuilds possible word list
	public void setDiceTray(DiceTray dt){
		wordsPossible = new ArrayList<String>(1);
		this.tray = dt;
		buildPossible();
	}
	
	//Returns DiceTray as a string
	public String getDiceTrayAsString(){
		return tray.toString();
	}
	
	//Checks every word in the dictionary to see if it's in the tray
	public void buildPossible(){
		Scanner scan = null;
		try {
			scan = new Scanner(new File("BoggleWords.txt"));
		} catch (FileNotFoundException e) {
		}
		while(scan.hasNextLine()){
			String cur = scan.nextLine();
			if(tray.stringFound(cur.trim())){
				wordsPossible.add(cur);
			}
		}
	}
	
	//Checks to see if it's been guessed already
	//	If so, it's ignored
	//Otherwise, checks to see if it's a possible word
	//	If it is possible, it's removed from the possible words and added to correct words and the score is added
	//	If it isn't possible, it's added to the list of wrong words
	public void addGuess(String guess){
		guess = guess.toLowerCase();
		if(!wordsRight.contains(guess)){
			if(wordsPossible.contains(guess)){
				String temp = guess;
				wordsPossible.remove(temp);
				wordsRight.add(temp);
				if(temp.length()<5) score ++;
				else if(temp.length()==5) score+=2;
				else if(temp.length()==6) score+=3;
				else if(temp.length()==7) score+=5;
				else score+=11;
			}
			else{
				if(!wordsWrong.contains(guess)) wordsWrong.add(guess);
			}
		}
	}
	
	//returns score
	public int getScore(){
		return score;
	}
	
	//sorts correct words and returns them
	public List<String> getWordsFound(){
		Collections.sort(wordsRight);
		return (List<String>) wordsRight;
	}
	
	//sorts wrong words and returns them
	public List<String> getWordsIncorrect(){
		Collections.sort(wordsWrong);
		return (List<String>) wordsWrong;
	} 
	
	//returns remaining possible words
	public List<String> getWordsNotGuessed(){
		return (List<String>) wordsPossible;
	}
}