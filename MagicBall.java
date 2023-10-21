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

import java.util.*;

public class MagicBall {
	
	/*
	 * private fields
	 */
	private ArrayList<String> answers;
	private Random r;
	
	/*
	 * main method that will run a simulation
	 * similar to a Magic 8 Ball
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		MagicBall magicBall = new MagicBall();
		System.out.println("Welcome! This program mimics that of a Magic 8 Ball. You can ask it as many questions as you'd like.");
		/*
		 * do while loop that prompts the user
		 * to ask a question and gives them one
		 * of the many responses until the user
		 * does not want to ask anymore questions
		 */
		
		do {
			System.out.println("Please ask your question: ");
			String question = sc.nextLine();
			System.out.println("Your question: " + question);
			System.out.println(magicBall.randomAnswer());
			System.out.println("Do you want to ask another question?");
			String response = sc.nextLine().toLowerCase();
			if (!response.equals("yes"))
				break;
		}
		while (true);
		
		System.out.println("Thank you for playing! Goodbye!");
		sc.close();
	}
	
	/*
	 * constructor for MagicBall that adds the
	 * list of possible answers for the user's
	 * question into the ArrayList
	 */
	public MagicBall() {
		answers = new ArrayList<String>();
		r = new Random();
		answers.add("Yes");
		answers.add("No");		
		answers.add("It is certain");
		answers.add("Better not tell");
		answers.add("Absoultely not");
		answers.add("Can't predict now");
	}
	
	/*
	 * method that returns an answer,
	 * a String, that will answer the
	 * user's question
	 * @return answers.get(i), a String from the
	 * list of possible answers from the arrayList.
	 */
	public String randomAnswer() {
		int i = r.nextInt(answers.size());
		return answers.get(i);
	}
}
