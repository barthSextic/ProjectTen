package edu.mtc.egr281.chapter6;

/*/
 * Rick Howell
 * 11/1/21
 * Snail Game
 * This will ask a user to guess the winner and loser, and then play the game
 */

import java.util.Scanner;

public class ProjectTen {

	private static Scanner input;
	private static ColoredDie die1;
	private static ColoredDie die2;
	
	private static Snail[] snails;
	// This String array is public since the die and snails are both colored according to it
	public static final String[] COLOR_PALETTE = {"Red", "Yellow", "Blue", "Green", "Pink", "Orange"};
	
	private static final int SNAIL_COUNT = 6;
	private static final int FINISH = 8;
	private static final int SPACE_CORRECTOR = 6;
	
	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		
		// make die
		die1 = new ColoredDie();
		//System.out.println(die1.roll());
		die2 = new ColoredDie();
		//System.out.println(die2.roll());
		
		// make snails
		snails = new Snail[SNAIL_COUNT];
		for (int i = 0; i < snails.length; ++i) {
			snails[i] = new Snail(COLOR_PALETTE[i]);
		System.out.println(snails[i].getColor());
		} // end array filler for loop
				
		System.out.println();
		
		// prompt
		System.out.print("Place your bets for which snail (from the list above) will cross the line first: ");
		String guess = input.next();
		System.out.println();
		System.out.print("Now tell me who you think will lose: ");
		String guess2 = input.next();
		System.out.println();
		// this lets me call methods from an array if I set the elements in snails = snail
		Snail snail;
		int index = 0;
		int turn = 1;
		boolean winCon = true;

		System.out.println("SNAIL RACE\n*******************\n");
		
		// ------------------- GAME ALGORITHM -------------------
		while(winCon) {
			die1.roll();
			die2.roll();
			System.out.println("Turn #" + turn);
			System.out.println("DICE 1: " + die1.getColor());
			System.out.println("DICE 2: " + die2.getColor());
			System.out.println();
			// compares die values with snail values
			for(int i = 0; i < snails.length; ++i) {
				++index;
				snail = snails[index % ProjectTen.SNAIL_COUNT];
				
				if (snail.getColor() == die1.getColor()) {
					snail.incrementCurrentSpace();
				} // end if
				if (snail.getColor() == die2.getColor()) {
					snail.incrementCurrentSpace();
				} // end if
				if (snail.getCurrentSpace() >= ProjectTen.FINISH) {
					winCon = false;
					break;
				} // end if
			} // end for
			
			// prints game board
			for(int i = 0; i < snails.length; ++i) {
				snail = snails[i];
				printBoard(snail);
			} // end for

			System.out.println();
			++ turn;
		} // end while
		
		// check who won
		winCon = false;
		System.out.println("=================");
		for(int i = 0; i < ProjectTen.SNAIL_COUNT; ++i) {
			snail = snails[i];
			if (snail.getCurrentSpace() >= FINISH) {
				System.out.println(snail.getColor() + " wins!");
				if (guess.equals(snail.getColor())) {
					winCon = true;
				}
			} // end if
		} // end for
		
		// return guess states
		System.out.println();
		if(!winCon) {
			System.out.println("Your winning bet on " + guess + " was incorrect :(");
		} else if (winCon) {
			System.out.println("Your winning bet on " + guess + " was correct!");
		}
		
		System.out.println();
		lastPlace(snails, guess2);
		input.close();
		
	} // end main method
	
	// track drawing method
	private static void printBoard(Snail s) {
		int count = ProjectTen.SPACE_CORRECTOR - s.getColor().length();
		for(int i = 0; i < count; ++i) {
			System.out.print(" ");
		} // end for
		System.out.print(s.getColor() + ": ");
		for(int i = 0; i < ProjectTen.FINISH + 1; ++i) {
			if(i == s.getCurrentSpace()) {
				System.out.print("X");
			} else {
				System.out.print("=");
			} // end else if
		} // end for loop
		System.out.println();
	} // end print board method
	
	// check who is in last place
	private static void lastPlace(Snail s1[], String g) {
		int last = ProjectTen.FINISH;
		int index3 = 0;
		boolean check = false;
		
		for(int i = 0; i < ProjectTen.SNAIL_COUNT; ++i) {
			if (s1[i].getCurrentSpace() < last) {
				last = s1[i].getCurrentSpace();
			} // end if
		} // end for
		
		String[] loserArray = new String[ProjectTen.SNAIL_COUNT];
		
		for(int i = 0; i < ProjectTen.SNAIL_COUNT; ++i) {
			if (s1[i].getCurrentSpace() == last) {
				loserArray[index3] = s1[i].getColor();
				++index3;
			} // end if
		} // end for

		// print elements
		for (int i = 0; i < loserArray.length; ++i) {
			// checks if losing guess is correct
			if (g.equals(loserArray[i])) {
				check = true;
			} // end if
			// prints losers
			if (loserArray[i] != null) {
				System.out.println("Loser(s): " + loserArray[i]);
			} // end if
		} // end for
		System.out.println();
		if (check == true) {
			System.out.println("Your losing bet on " + g + " was correct!");
		} else {
			System.out.println("Your losing bet on " + g + " was incorrect :/");	
		} // end if else

	} // end last place method
	
} // end project ten class
