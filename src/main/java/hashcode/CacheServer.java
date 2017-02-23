package hashcode;

import java.util.ArrayList;

public class CacheServer {
	
	public int id;
	public int capacity;
	public ArrayList<Video> allVideos;
	
	public CacheServer(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
		this.allVideos = new ArrayList<>();
		
	}
			
			
}
