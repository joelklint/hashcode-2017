package hashcode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class ProblemSolver {

	public String OUTPUT = "";
	private float score = Integer.MIN_VALUE;

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

				Video video = videos.remove(rand.nextInt(videos.size()));
				addedVideos.add(video);
				//System.out.println("Adding new videos");
				boolean success = cacheServer.add(video);				

			}

			videos.addAll(addedVideos);

		}

		createOutputString();
		calculateScore();
	}

	public float getScore() {
		return score;
	}

	private void createOutputString() {
		int nrCacheServersUsed = 0;
		String cacheDescription = "";

		// build all cache rows
		for(CacheServer cacheServer : cacheServers) {
			boolean hasVideos = cacheServer.hasVideos();
			if(hasVideos) {
				nrCacheServersUsed++;

				// build cache row
				cacheDescription += cacheServer.id;
				ArrayList<Video> cacheVideos = cacheServer.videos;
				for(Video video : cacheVideos) {
					cacheDescription += " " + video.id;
				}
				cacheDescription += "\n";
			}
		}

		cacheDescription = nrCacheServersUsed + "\n" + cacheDescription;
		OUTPUT = cacheDescription;
		OUTPUT = OUTPUT.trim();
	}

	public void calculateScore() {
		float scoreSum=0;
		float nrRequests=0;
		
		for(Endpoint endpoint : endpoints) {
			int dataCenterLatency = endpoint.dataCenterLatancy;


			HashMap<Integer, Integer> requests = endpoint.videoRequests;
			TreeMap<Integer, Integer> cacheLatencies = endpoint.cacheLatancies;			

			Set<Integer> latency_values = cacheLatencies.keySet();

			for(Integer videoId : requests.keySet()) {


				Iterator itr = latency_values.iterator();

				while(itr.hasNext()){
				
				int cacheLatency=(int) itr.next();
				int cacheID=cacheLatencies.get(cacheLatency);

				Video video = videos.get(videoId);				
				boolean hasVideo = cacheServers.get(cacheID).hasVideo(video);

				if(hasVideo) {
					//calc latency
					
					scoreSum += (dataCenterLatency-cacheLatency)*requests.get(videoId);
					break;
				}
				else {
					continue;
				}
				}
				
				nrRequests+=requests.get(videoId);

			}

		}
		
		score= (scoreSum/nrRequests)*1000;
		
		
	}

	public String printToFile() {
		String fileName = "output/score:" + getScore() + "&file:" + Main.inputPath;
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
