package hashcode;

import java.util.HashMap;

public class Endpoint {
	private int id;
	private HashMap<Video, Integer> videoRequests;
	private HashMap<CacheServer, Integer> cacheLatancy;
	
	public Endpoint(int id) {
		this.id = id;
		this.videoRequests = new HashMap<Video, Integer>();
		this.cacheLatancy = new HashMap<CacheServer, Integer>();
	}
}
