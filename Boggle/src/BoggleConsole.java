/*
 * Alex Swindle
 * Kevin Butler
 * Boggle Console Game
 */

import java.util.Scanner;

public class BoggleConsole {

	public static void main(String[] args){
		//Creates new randomized game
		Boggle game = new Boggle();
		
		//Creates scanner to read from the keyboard
		Scanner input = new Scanner(System.in);
		String guesses = "";
		
		System.out.println("Play one game of Boggle: "+'\n');
		System.out.println(game.getDiceTrayAsString());
		System.out.println("Enter words or ZZ to quit: ");
		System.out.println();
		
		//Adds first line of text to guesses and keeps adding them while they don't have " zz"
		guesses += input.nextLine().toLowerCase();
		while(!(guesses.contains(" zz"))){
			guesses += " " +input.nextLine().toLowerCase();
		}
		
		//Cuts off the zz
		guesses = guesses.substring(0, guesses.length()-2);
		
		//Creates new scanner for the guesses, adds guesses to the game until it runs out
		Scanner scanGuesses = new Scanner(guesses);
		while(scanGuesses.hasNext()){
			game.addGuess(scanGuesses.next());
		}
		
		//Prints end-of-game text
		System.out.println('\n'+"Your score: " + game.getScore()+'\n');
		System.out.println("Words you found: " + '\n' + game.getWordsFound().toString().substring(1, game.getWordsFound().toString().length()-1)+'\n');
		System.out.println("Incorrect Words: " + '\n' + game.getWordsIncorrect().toString().substring(1, game.getWordsIncorrect().toString().length()-1)+'\n');
		System.out.println("You could have found " + game.getWordsNotGuessed().size() + " more words.");
		System.out.println("The computer found all of your words plus these: " + '\n' + game.getWordsNotGuessed().toString().substring(1, game.getWordsNotGuessed().toString().length()-1));
		
	}
}
