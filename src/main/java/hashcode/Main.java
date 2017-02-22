package hashcode;

import java.io.FileNotFoundException;
import java.util.Random;

public class Main {
	
	public static int PROCESS_ID;
	
	public static void main(String[] args) throws FileNotFoundException {
		//Set a random number to prevent equal file names
		Random rand = new Random();
		PROCESS_ID = rand.nextInt(400000);
		
		//Get run time defined variable, if any. Can be used for something. Defaults to 40 
		String var = System.getenv("ITERATIONS");
		int attempts = var != null ? Integer.parseInt(var) : 40;
		System.out.println("CUSTOM VARIABLE: " + attempts);
		
		//Parse file
		String inputPath; /*"INPUT_FILE_NAME_HERE"*/ /* path is relative to git repo root path */
		//Parser parser = new Parser(inputPath);
		//parser.parse();
		
		//Create variable for storing current best score
		int bestScore = Integer.MIN_VALUE;
		int iterations = 0;
		
		
		//Initiate while loop for endless trying
		while(true) {
			
			/*
			 * GET ALL DATA FROM PARSER HERE.
			 * THIS WILL BE A FRESH COPY OF DATA, THAT IS UNRELATED TO PREVIEOUS ITERATIONS
			 */
			
			ProblemSolver ps = new ProblemSolver(/*ADD RELEVANT DATA FOR PROBLEM HERE*/);
			ps.solve();
			int score = ps.getScore();
			
			if(score > bestScore) {
				bestScore = score;
				String fileName = ps.printToFile();
				System.out.println("New highscore: " + score);
				System.out.println("Find it in file " + fileName);
			}
			
			if(iterations%100000 == 0) {
				System.out.println("On iteration: " + iterations);
			}
			iterations++;
			
		}
		
		
		
	}

}
