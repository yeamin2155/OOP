//lab3- cosc242501 Professor Mccurry
//Implemented by - Ashabul Yeamin 

package lab3;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

	public static void main(String[] args) {
		// THESE DECLARATIONS ARE CORRECT.
		Random ranGen = new Random(5); // seeded to make debugging easier
		Scanner userInput = new Scanner(System.in);
		String[] words = { "dragon", "wizard", "castle", "sword", "magic" };// Creates an array of words
		String word = words[ranGen.nextInt(words.length)];// Picks the word
		String hiddenWord = new String(new char[word.length()]).replace("\0", "_");// Hides the word
		int attempts = 6;// Initializes attempts

		// MAKE SURE THE PROGRAM PLAYS BY THESE RULES!!!
		System.out.println("Welcome to the Hangman Game!\n\n RULES:" + "\n1. Guess the letters of the hidden word."
				+ "\n2. You have six attempts to guess the word."
				+ "\n3. Each incorrect guess brings you closer to being caught by the dragon!"
				+ "\n4. Save yourself by guessing the word before your attempts run out!");

		// loop until the user runs out of attempts or guesses the word
		// changed it greater than or equal to
		while (attempts > 0 && hiddenWord.contains("_")) {
			System.out.println("\nWord: " + hiddenWord);
			System.out.print("Guess a letter: ");
			char guess = userInput.next().charAt(0);

			// check if the guessed letter is in the word
			// changed from or to and 
			if (word.indexOf(guess) >= 0) {
				hiddenWord = revealLetters(word, hiddenWord, guess);
				System.out.println("Correct guess!");
			} else {
				attempts--;
				System.out.println("Incorrect guess. Attempts left: " + attempts);
			}
		}

		// check if the user guessed the word or ran out of attempts
		if (hiddenWord.equals(word)) {
			System.out.println("Congratulations! You saved yourself from the dragon. The word was: " + word);
		} else {
			// add word
			System.out.println("You were caught by the dragon! The word was: " + word);
		}

		// close the scanner
		userInput.close();
	}

	// reveal the guessed letters in the hidden word
	private static String revealLetters(String word, String hiddenWord, char guess) {
		StringBuilder newHiddenWord = new StringBuilder(hiddenWord);
		//change int from 1 to 0
		for (int i = 0; i < word.length(); i++) {
			//change from 0 to i
			if (word.charAt(i) == guess) {
				newHiddenWord.setCharAt(i, guess);
			}
		}
		return newHiddenWord.toString();
	}
}
