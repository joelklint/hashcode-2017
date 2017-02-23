package hashcode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;

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
		
		createOutputString();
		calculateScore();
	}
	
	public int getScore() {
		return score;
	}
	
	private void createOutputString() {
		int nrCacheServersUsed = 0;
		String cacheDescription = "";
		
		// build all cache rows
		for(CacheServer cacheServer : cacheServers) {
			boolean hasVideos = cacheServer.hasVideoes();
			if(hasVideos) {
				nrCacheServersUsed++;
				
				// build cache row
				cacheDescription += cacheServer.getId();
				ArrayList<Video> cacheVideos = cacheServer.getVideos();
				for(Video video : cacheVideos) {
					cacheDescription += " " + video.getId();
				}
				cacheDescription += "\n";
			}
		}
		
		cacheDescription = nrCacheServersUsed + "\n" + cacheDescription;
	}
	
	private void calculateScore() {
		/*
		for(Endpoint endpoint : endpoints) {
			int dataCenterLatency = endpoint.getDataCenterLatency();
			
			
			HashMap<Integer, Integer> requests = endpoint.getRequests();
			TreeMap<Integer, Integer> cacheLatencies = endpoint.getCacheLatencies();			
			
			ArraySet<Integer> latency_values = latencies.keySet();
			
			for(Integer videoId : requests.keySet()) {
				
				Iterator itr = sortedCacheLatencies.iterator();
				itr.next();
				cacheIndex = sortedCacheLatencies.
				
				Cache cache = cacheServers.get(index)
				
				// Hitta närmaste cacheservern
				// kolla om den finns där
					// om den gör det räkna ut saker
					// om inte, gå vidare till nästa cache
				
			}
			
		}
		*/
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
