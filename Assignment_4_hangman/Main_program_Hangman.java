/**
 * @file Hangman.java
 * Main console program for the Hangman game,
 * which deals with words, and user's hits and misses
 *  */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;

public class Hangman extends ConsoleProgram {
	/* Private instance variables */
	private HangmanLexicon words;
	
	private MyHangmanCanvas canvas;
	
	private RandomGenerator rgen =
			RandomGenerator.getInstance();
	
	// number of words that user tried to guess, in our case, 8
	private int guessesLeft = 8;
	
	// Word which player should guess
	private String guessingWord = wordFromLexicon();
	
	// word with guessed parts from user
	private String usersWord;
	
	// Counter for missed letters
	private String missedLetters = "";
	
	// character which user has entered
	private char ch;
	
	/* Method for playing the game */
	public void run() {
		setFont("Courier-18");
		setUpGame();
		playGame();
	}
	
	/* Setting up the game */
	private void setUpGame() {
		canvas.reset();
		usersWord = showDashes();
		canvas.displayWord(usersWord);
		println("Welcome to Hangman game!");
		println("The word now looks like this: " + usersWord);
		println ("You have " + guessesLeft + " guesses left. ");
	}
	
	/* Shows the dashes, for beginning */
	private String showDashes() {
		String result = "";
		for (int i=0; i<guessingWord.length(); i++) {
			result = result + "-";
		}
		return result;
	}
	
	/* We random generate a word from lexicon */
	private String wordFromLexicon() {
		words = new HangmanLexicon();
		int randomWordFromLexicon = 
				rgen.nextInt(0, words.getWordCount()-1);
		String guessingWord = words.getWord(randomWordFromLexicon);
		return guessingWord;
	}
	
	
	/* We finnished setting up the game, we have the random word, 
	 * and we show it hidden. Now we can play*/
	
	/* Let's play the game! */
	private void playGame() {
		// We read the characters until guessesLeft reaches 0
		while (guessesLeft>0) {
			String usersLetter = readLine("Please guess the letter: ");
			/* loop and a half, for checking if user entered
			 * more than one character 
			 */
			while (true) {
				if (usersLetter.length()>1) {
					println ("You can only enter" +
							"one letter at a time. ");
					usersLetter = readLine("Please guess the letter: ");
				}
				else if (usersLetter.length()==1) break;
			}
			
			ch = usersLetter.charAt(0);
			
			if (Character.isLowerCase(ch)) {
				// as per request in assignment
				ch = Character.toUpperCase(ch);
			}
			// we call the method for checking the presence of the character 
			// which user typed in our word and updates user's word
			updateWord();
			
			if (usersWord.equals(guessingWord)) {
				println("Congratulations! :-) You have guessed " +
						"the word: " + guessingWord);
				break;
			}
			
			println("Your word now looks like this: "+usersWord);
			println("You have "+guessesLeft+" guesses left.");
		}
		if (guessesLeft == 0) {
			println("Game over, bitch! :-)");
			println("The right word was: "+guessingWord);
		}
	}
	
	/*
	 * method for checking the presence of the character 
	 * which user typed in our word
	 */
	private void updateWord() {
		if (!checkThePresence()) {
			println("Letter "+ch+" is not present in the word.");
			guessesLeft --;
			missedLetters = missedLetters + ch;
			canvas.noteIncorrectGuess(missedLetters);

		}
		if(checkThePresence()) {
			println ("You have hit the correct letter. ");
		}
		
		
		for (int i=0; i<guessingWord.length(); i++) {
			if (ch == guessingWord.charAt(i)) {
				if (i > 0) {
					usersWord = usersWord.substring(0,i)
							+ ch + usersWord.substring(i+1);
				}
				if (i == 0) {
					usersWord = ch + usersWord.substring(1);
				}
				canvas.displayWord(usersWord);
			}
		}
	}
		
	/*
	 * method for checking the presence of the character 
	 * which user typed in our word
	 */
	private boolean checkThePresence() {
		if (guessingWord.indexOf(ch) == -1) {
			return false;
		}
		
		else return true;
	}
	
	// initializing the canvas on the screen
	public void init() {
		canvas = new MyHangmanCanvas();
		add(canvas);
	}
	
	
}
