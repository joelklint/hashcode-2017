package hashcode;

public class Video {

	public int id;
	public int size; 
	
	public Video(int id, int size){
		this.id = id;
		this.size = size;
	}
	
	
	public boolean equals(Object video){
		if(video instanceof Video) {
			Video input = (Video)video;
			if(input.id==this.id) {
			
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
