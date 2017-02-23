package hashcode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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
		//String inputPath = "input/kittens.in";
		//String inputPath = "input/me_at_the_zoo.in";
		String inputPath = "input/trending_today.in";
		//String inputPath = "input/videos_worth_spreading.in";
		Parser parser = new Parser();
		
		System.out.println("Starting to parse");
		parser.parse(inputPath);
		
		//Create variable for storing current best score
		int bestScore = Integer.MIN_VALUE;
		int iterations = 0;
		
		
		//Initiate while loop for endless trying
		//while() {
			
			/*
			 * GET ALL DATA FROM PARSER HERE.
			 * THIS WILL BE A FRESH COPY OF DATA, THAT IS UNRELATED TO PREVIEOUS ITERATIONS
			 */
			
			//ArrayList<Video> videos = parser.getVideos();
			//ArrayList<Endpoint> endpoints = parser.getEndpoints();
			//ArrayList<CacheServer> cacheServers = parser.getCacheServers();
			
			ProblemSolver ps = new ProblemSolver(parser.allVideos, parser.allEndpoints, parser.allCacheServers);
			ps.solve();
			int score = ps.getScore();
			
			if(score > bestScore) {
				bestScore = score;
				String fileName = ps.printToFile();
				System.out.println("New highscore: " + score);
				System.out.println("Find it in file " + fileName);
			}
			
			ps.printToFile();
			
			//if(iterations%100000 == 0) {
				System.out.println("On iteration: " + iterations);
			//}
			iterations++;
			
		//}
		
		
		
	}

}
