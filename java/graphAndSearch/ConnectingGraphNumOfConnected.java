/**
* given n nodes in a graph labeled from 1 to n. no edge at beginning,
* use connect(.) to connect two nodes and query(a) to query how many 
* nodes (including a) are connected with a.
* 	public class ConnectingGraphNumOfConnected{
*		public ConnectingGraph(int n){}
*		public void connect(int a, int b){}
*		public int query(int a){}
*	}
*/
import java.util.*;

public class ConnectingGraphNumOfConnected{
	HashMap<Integer,Integer> map;
	HashMap<Integer,Integer> cap; // capacity of the current tree
	int n;
	public ConnectingGraphNumOfConnected(int n){
		this.n = n;
		map = new HashMap<Integer,Integer>();
		cap = new HashMap<Integer,Integer>();
		for(int i = 1; i<=n; i++){
			map.put(i,n+1);
			cap.put(i,1);
		}
	}
	public void connect(int a, int b){
		int roota = a;
		int rootb = b;
		while(map.get(roota)!=n+1){
			roota = map.get(roota);
		}
		while(map.get(rootb)!=n+1){
			rootb = map.get(rootb);
		}
		if(roota != rootb){
			if(cap.get(roota)<cap.get(rootb)){
				map.put(roota,rootb);
				cap.put(rootb,cap.get(rootb)+cap.get(roota));
			}else{
				map.put(rootb,roota);
				cap.put(roota,cap.get(roota)+cap.get(rootb));
			}
		}
	}
	public int query(int a){
		int roota = a;
		while(map.get(roota)!=n+1)
			roota = map.get(roota);
		return cap.get(roota);
	}
	public static void main(String[] args) {
		ConnectingGraphNumOfConnected graph = new ConnectingGraphNumOfConnected(6);
    	graph.connect(5,6);
    	graph.connect(1,4);
        graph.connect(4,6);
        int node = 4;
        System.out.format("There are %d nodes connected with %d.\n", graph.query(node), node);
	}
}