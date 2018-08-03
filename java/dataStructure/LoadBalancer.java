/**
* implement a load balancer for a cluster which contains the following 
* functionalities:
* add(server_id): add a server id into the cluster
* remove(server_id): remove a server id from the cluster
* pick(): randomly pick up a server id which has been added to the cluster.
*	public class LoadBalancer {
*	    public LoadBalancer(){}
*	    public void add(int server_id){}
*	    public void remove(int server_id){}
*	    public int pick(){} 
*	}
* (witnessed in Google interview)
* (failed to pick in constant time for the first time)
*/
import java.util.*;

public class LoadBalancer {
	int[] list;
	HashMap<Integer,Integer> map;
	Random rgen;
    public LoadBalancer() {
    	list = new int[100000];
    	map = new HashMap<Integer,Integer>();
    	rgen = new Random();
    }

    public void add(int server_id) {
    	list[map.size()] = server_id;
    	map.put(server_id, map.size());
    }

    public void remove(int server_id) {
        if(map.containsKey(server_id)){
        	int size = map.size();
        	int pos = map.get(server_id);
        	list[pos] = list[size-1];
        	map.put(list[pos],pos);
        	map.remove(server_id);
        }
    }

    public int pick() {
    	if(map.size() == 0)
    		return -1;
        int pos = rgen.nextInt(map.size());
        return list[pos];
    } 
}