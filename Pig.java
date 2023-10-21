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

import java.util.Random;
import java.util.Scanner;

public class Pig {
	/*
	 * main method that introduces 
	 * the players to the game!
	 */
public static void main(String[] args) {
	try (Scanner sc = new Scanner(System.in)) {
		Random r = new Random();
		System.out.println("You have entered the Pig Game! Players will take turns repeatedly rolling a single 6-side.");
		System.out.println("The turns will switch when a player chooses to stop rolling or if they roll a 1, in which case they lose all their points and turn for that round.");
		System.out.println("The player who first reaches 100 points win!");
		int player1=0;
		int player2=0;
		int current=1;

		/*
		 * while statement that continues
		 * playing the game as long as
		 * neither player has reached a
		 * score of 100 or more.
		 */
		while (player1<100 && player2<100) {
			boolean continuePlaying=true;
			System.out.println("Player " + current + "'s turn!");
			int roundScore=0;
		
			/*
			 * while statement that determines if it is
			 * player1's or player2's turn. Their turns 
			 * change if one player rolls a 1 or if one
			 * player chooses to stop rolling for the round.
			 */
			while (continuePlaying) {
				int dice=r.nextInt(6) + 1;
				System.out.println ("Player " + current + " rolled a number " + dice);
				if (dice==1) {
					System.out.println("Because Player " + current + " rolled 1, they lost all points from this round!");
					roundScore=0;
					if (player1<100 && player2<100) {
						current=(current==1)? 2:1;
					}
					break;
				}
				else {
					roundScore += dice;
					System.out.println("Player " + current + "'s score for this round has reach: " + roundScore + "!");
					if ((player1 + roundScore > 99) || (player2 + roundScore > 99)) {
						continuePlaying = false;
						if (current==1) {
							player1 += roundScore;
						}
						else {
							player2 += roundScore;
						}
						System.out.println("Score of player 1 is " + player1+ " and score of player 2 is " + player2 + "!");
					}
					else {
						System.out.println("Want to try your luck and roll again? (yes or no):");
						String option=sc.next();
						if (!option.equalsIgnoreCase("yes")) {
							continuePlaying=false;
							if (current==1) {
								player1 += roundScore;
							}
							else {
								player2 += roundScore;
							}
							System.out.println("Score of player 1 is " + player1+ " and score of player 2 is " + player2 + "!");
							if (player1<100 && player2<100) {
								current=(current==1)? 2:1;
							}
						}
					}
				}
			}
		}
		if (player1>99) {
			System.out.println("Player 1, you are the winner!");
		}
		else {
			System.out.println("Player 2, you are the winner!");
			}
	}	
}
}