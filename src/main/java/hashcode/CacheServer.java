package hashcode;

import java.util.ArrayList;

public class CacheServer {
	
	public int id;
	public int capacity;
	public ArrayList<Video> videos;
	
	public CacheServer(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
		this.videos = new ArrayList<>();
		
	}
	
	public boolean hasVideos(){
		return cacheVideos.size() > 0;
	}
			
			
}
