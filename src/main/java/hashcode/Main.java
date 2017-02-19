package hashcode;

import java.io.FileNotFoundException;
import java.util.Random;

public class Main {
	
	public static int PROCESS_ID;
	
	public static void main(String[] args) throws FileNotFoundException {
		Random rand = new Random();
		PROCESS_ID = rand.nextInt(400000);
		
		String var = System.getenv("ITERATIONS");
		int attempts = var != null ? Integer.parseInt(var) : 40;
		System.out.println("Attempts: " + attempts);
		
		String inputPath = "";
		Parser parser = new Parser(inputPath);
		parser.parse();
		
		int bestScore = Integer.MIN_VALUE;
		int iterations = 0;
		
		while(true) {
			// Get all data from parser via getters
			
			ProblemSolver ps = new ProblemSolver();
			ps.solve();
			int score = ps.getScore();
			
			if(score > bestScore) {
				bestScore = score;
				String fileName = ps.printToFile();
				System.out.println("New highscore: " + score);
				System.out.println("Find it in file " + fileName);
			}
			
			iterations++;
			if(iterations%20000 == 0) {
				System.out.println("On iteration: " + iterations);
			}
			
		}
		
		
		
	}

}
