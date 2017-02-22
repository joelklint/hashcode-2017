package hashcode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class ProblemSolver {
	
	public String OUTPUT = "";
	private int score = Integer.MIN_VALUE;
	
	/*
	 * ADD RELEVANT ATTRIBUTES DESCRIBING THE PROBLEM HERE
	 * 
	 * ALL RELEVANT ATTRIBUTES TO STORE SOLUTION TO PROBLEM
	 */
	
	public ProblemSolver() {
		/*
		 * EXTEND TO RECEIVE RELEVANT DATA FOR PROBLEM HERE
		 */
	}
	
	public void solve() {
		/*
		 * IMPLEMENT TO SOLVE THE PROBLEM HERE. STORE IN CLASS VARIABLES
		 */
		calculateScore();
	}
	
	public int getScore() {
		return score;
	}
	
	private void calculateScore() {
		/*
		 * IMPLEMENT TO CALCULATE THE SCORE OF THE SOLUTION HERE. STORE IN CLASS VARIABLE
		 */
		Random rand = new Random();
		score = rand.nextInt(400000);
	}
	
	public String printToFile() {
		String fileName = "output/score:" + getScore() + "&pid:" + Main.PROCESS_ID;
		PrintWriter out;
		try {
			out = new PrintWriter(fileName);
			out.println(OUTPUT);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("COULD NOT PRINT TO FILE. PRINTING IN TERMINAL INSTEAD");
			System.out.println("\n\n\n\n\n");
			System.out.println(OUTPUT);
			System.out.println("\n\n\n\n\n");
			e.printStackTrace();
		}
		return fileName;
		
	}

}
