package hashcode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.xml.ws.Endpoint;

public class ProblemSolver {
	
	public String OUTPUT = "";
	private int score = Integer.MIN_VALUE;
	
	private ArrayList<Video> videos;
	private ArrayList<Endpoint> endpoints;
	private ArrayList<CacheServer> cacheServers;
	
	/* 
	 * ALL RELEVANT ATTRIBUTES TO STORE SOLUTION TO PROBLEM
	 */
	
	public ProblemSolver(ArrayList<Video> videos, ArrayList<Endpoint> endpoints, ArrayList<CacheServer> cacheServers) {
		this.videos = videos;
		this.endpoints = endpoints;
		this.cacheServers = cacheServers;
	}
	
	public void solve() {
		Random rand = new Random();
		
		//Collections.shuffle(videos);
		
		for(CacheServer cacheServer : cacheServers) {
			
			ArrayList<Video> addedVideos = new ArrayList<Video>();
			
			
			while(!cacheServer.isFull()) {
				// Fyll den
				
				Video video = videos.remove(rand.nextInt(videos.size));
				addedVideos.add(video);
				
				boolean success = cacheServer.add(video);				
				
			}
			
			videos.addAll(addedVideos);
				
		}
		
		
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
