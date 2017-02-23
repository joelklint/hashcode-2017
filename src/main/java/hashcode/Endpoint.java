package hashcode;

import java.util.HashMap;
import java.util.TreeMap;

public class Endpoint {
	public int id;
	public int dataCenterLatancy;
	// ID: REQGUESTS
	public HashMap<Integer, Integer> videoRequests;
	//ID: Latency 
	public TreeMap<Integer, Integer> cacheLatancies;
	
	public Endpoint(int id) {
		this.id = id;
		this.videoRequests = new HashMap<Integer, Integer>();
		this.cacheLatancies = new TreeMap<Integer, Integer>();
	}
}
