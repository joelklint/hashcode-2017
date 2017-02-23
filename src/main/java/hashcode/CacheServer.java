package hashcode;

import java.util.ArrayList;

public class CacheServer {
	
	public int id;
	public int capacity;
	private int capacityLeft;
	public ArrayList<Video> videos;
	private int failedInputAttempts = 0;
	private boolean full = false;
	
	public CacheServer(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
		this.capacityLeft = capacity;
		this.videos = new ArrayList<>();
		
	}
	
	public boolean add(Video video) {
		if(capacityLeft >= video.size) {
			videos.add(video);
			return true;
		}
		else {
			failedInputAttempts++;
			if(failedInputAttempts > 5) {
				this.full = true;
			}
		}
		return false;
	}
	
	public boolean isFull() {
		return full;
	}

	public boolean hasVideos(){
		return videos.size() > 0;
	}
			
			
}
