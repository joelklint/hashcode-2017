package hashcode;

import java.util.ArrayList;

public class CacheServer {
	
	public int id;
	public int capacity;
	public ArrayList<Video> cacheVideos;
	
	public CacheServer(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
		this.cacheVideos = new ArrayList<>();
		
	}
			
			
}
