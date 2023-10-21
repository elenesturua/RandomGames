/***********************************************************************
 * Name(s): Maritza Mozo and Elene Sturua                              *
 * Assignment name (Lab 20)                                            *
 *                                                                     *
 * Assignment for 10/15/23                                             *
 ***********************************************************************/


/* *********************************************************************
 * Academic honesty certification:                                     *
 *   Written/online sources used: https://jimenezp.cs.grinnell.edu/Courses/CSC207/2023Fa/labs/20_Random.html *
 *   Help obtained: Prof Jimenez, course mentor                        *
 *   My/our signature(s) below confirms that the above list of sources *
 *   is complete AND that I/we have not talked to anyone else          *
 *   (e.g., CSC 207 students) about the solution to this problem       *
 *                                                                     *
 *   Signature: Maritza Mozo, Elene Sturua                             *
 ***********************************************************************/

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber {
	
	/* 
	 * main program that prompts
	 * the user to input their name
	 * before playing the game
	 */
public static void main(String[] args) {
	try {
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your first name:");
		String name=sc.next();
		System.out.println("Hello, " + name + ". Let's play a game!");
		
		int target=r.nextInt(100)+1;
		int totalGuesses=10;
		int userGuesses=totalGuesses;

			/*
			 * do while loop that will continue to run until
			 * the user guesses the correct number or runs
			 * out of turns
			 */
	
		do {
			System.out.println("Input your guess (an integer between numbers 1-100):");
			int guess=sc.nextInt();
			if (guess<1 || guess>100) {
				System.out.println("Enter a valid integer in the range of 1 and 100!");
			}
			if (guess==target) {
				System.out.println("You have correctly guessed the random number in "+ (11-userGuesses)+" guesses!");
				break;
			}
			else if ((guess<target) &&(userGuesses>0)) {
			System.out.println("Your guess was too low!");
			}
			else if ((guess>target) &&(userGuesses>0)) {
				System.out.println("Your guess was too high!");
			}
			userGuesses--;
			if (userGuesses==0) {
				System.out.println("You are out of tries! The correct number was " + target);
				break;
				}
		}
		while (userGuesses !=0);
		sc.close();
}

	/*
	 * catch statement if a user inputs
	 * a wrong argument as a guess
	 */
	
catch (InputMismatchException e) {
	System.out.println("Restart the game and enter a valid input!(an integer in range:1-100)");
	}
}
}