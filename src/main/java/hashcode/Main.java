package hashcode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.ws.Endpoint;

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
		String inputPath = "input/videos_worth_spreading.in"; /*"INPUT_FILE_NAME_HERE"*/ /* path is relative to git repo root path */
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
			
			ArrayList<Video> videos = parser.getVideos();
			ArrayList<Endpoint> endpoints = parser.getEndpoints();
			ArrayList<CacheServer> cacheServers = parser.getCacheServers();
			
			ProblemSolver ps = new ProblemSolver(ArrayList<Video> videos, ArrayList<Endpoint> endpoints, ArrayList<CacheServer> cacheServers);
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
			
		//}
		
		
		
	}

}
