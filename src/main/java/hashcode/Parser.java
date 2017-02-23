package hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
	
	
	
	
	public ArrayList<Video> allVideos;
	public ArrayList<CacheServer> allCacheServers;
	public ArrayList<Endpoint> allEndpoints;
	
	Scanner scan;
	
	public Parser() {
		allVideos = new ArrayList<Video>();
		allCacheServers = new ArrayList<CacheServer>();
		allEndpoints = new ArrayList<Endpoint>();
	}
		
		
	public void  parse(String inputPath) {
		File file = new File(inputPath);
		try {
			scan = new Scanner(file);
			
			String line = scan.nextLine();
			String[] splitLine = line.split(" ");
			
			int numberOfVideos = Integer.parseInt(splitLine[0]);
			int numberOfEndpoints = Integer.parseInt(splitLine[1]);
			int numberOfRequestDescriptions = Integer.parseInt(splitLine[2]);
			int numberOfCacheServers = Integer.parseInt(splitLine[3]);
			int cacheServerCapacity = Integer.parseInt(splitLine[4]);
			
			line = scan.nextLine();
			splitLine = line.split(" ");
			
			for (int i = 0; i < splitLine.length; i++) {
				int videoSize = Integer.parseInt(splitLine[i]);
				Video v = new Video(i, videoSize);
				allVideos.add(v);
			}
			

			//Create Endpoints
			for (int i = 0; i < numberOfEndpoints; i++) {
				line = scan.nextLine();
				splitLine = line.split(" ");
				Endpoint endpoint = new Endpoint(i);
				allEndpoints.add(endpoint);
				
				int latancyToDatacenter = Integer.parseInt(splitLine[0]);
				
				endpoint.dataCenterLatancy = latancyToDatacenter;
				int numberOfConnectedCaches = Integer.parseInt(splitLine[1]);
				
				for (int j = 0; j < numberOfConnectedCaches; j++) {
					line = scan.nextLine();
					splitLine = line.split(" ");
					//Create cacheServers if not exists
					int cacheServerId = Integer.parseInt(splitLine[0]);
					int latencyFromEndpoint = Integer.parseInt(splitLine[1]);
					boolean cacheExists = false;
					CacheServer currentCache = null;
					for (CacheServer c : allCacheServers) {
						if(c.id == cacheServerId) {
							cacheExists = true;
							currentCache = c;
						}
					}
					
					// Create unexisting cacheobjects.
					if (!cacheExists) {
						currentCache = new CacheServer(cacheServerId, latencyFromEndpoint);
						allCacheServers.add(currentCache);
						currentCache.capacity = cacheServerCapacity;
					}
					
					endpoint.cacheLatancies.put(latencyFromEndpoint, currentCache.id); 
					
				}
			}
				
				for (int j = 0; j < numberOfRequestDescriptions; j++) {
					line = scan.nextLine();
					splitLine = line.split(" ");
					int videoId = Integer.parseInt(splitLine[0]);
					int endPointId = Integer.parseInt(splitLine[1]);
					int nbrOfRequests = Integer.parseInt(splitLine[2]);
					
					Endpoint videoEndpoint = allEndpoints.get(endPointId);
					
					videoEndpoint.videoRequests.put(videoId, nbrOfRequests);
					
				}
			
			
			System.out.println("DONE With Reading");
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("COULD NOT FIND FILE TO READ FROM!");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public ArrayList<Video> getVideos(){
		ArrayList<Video> videoCopy = (ArrayList<Video>) allVideos.clone();
		return videoCopy;
	}
	
	public ArrayList<Endpoint> getEndpoints(){
		ArrayList<Endpoint> endpointCopy = (ArrayList<Endpoint>) allEndpoints.clone();
		return endpointCopy;
	}
	
	public ArrayList<CacheServer> getCacheServers(){
		ArrayList<CacheServer> cacheServerCopy = (ArrayList<CacheServer>) allCacheServers.clone();
		return cacheServerCopy;
	}

		// Scanner already initiated. Example use below
		
		/*
		 * IMPLEMENT PARSER HERE.
		 * STORE ALL RELEVANT DATA IN CLASS ATTRIBUTES.
		 */
	
	
	/*
	 * IMPLEMENT GETTERS FOR ALL RELEVANT ATTRIBUTES FOR PROBLEM.
	 * 
	 * ALL GETTERS MUST RETURN A DEEP CLONED COPY.
	 * THIS MEANS EVERYTHING MUST BE CLONED, DOWN TO ITS PRIMITIVE TYPES
	 */

}
