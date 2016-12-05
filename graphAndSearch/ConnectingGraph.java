/**
* given n nodes in a graph labeled from 1 to n. no edge at beginning,
* use connect(.) to connect two nodes and query(.) to check whether two nodes
* are connected.
* 	public class ConnectingGraph{
*		public ConnectingGraph(int n){}
*		public void connect(int a, int b){}
*		public boolean query(int a, int b){}
*	}
* (first try - matrix presentation didn't pass the test...)
*/
import java.util.*;

public class ConnectingGraph { 
    HashMap<Integer,Integer> map;
    int n;
    public ConnectingGraph(int n) {
        this.n = n;
        map = new HashMap<Integer,Integer>();
        for(int i = 1; i<=n; i++)
            map.put(i,n+1);
    }

    public void connect(int a, int b) {
        int roota = a;
        int counta = 1;
        while(map.get(roota)!=n+1){
            roota = map.get(roota);
            counta++;
        }
        int rootb = b;
        int countb = 1;
        while(map.get(rootb)!=n+1){
            rootb = map.get(rootb);
            countb++;
        }
        if(rootb!=roota){
            if(countb>counta)
                map.put(roota,rootb);
            else
                map.put(rootb,roota);
        }
    }
        
    public boolean query(int a, int b) {
        int roota = a;
        while(map.get(roota)!=n+1){
            roota = map.get(roota);
        }
        int rootb = b;
        while(map.get(rootb)!=n+1){
            rootb = map.get(rootb);
        }
        return roota==rootb;
    }
    public static void main(String[] args) {
    	ConnectingGraph graph = new ConnectingGraph(6);
    	graph.connect(5,6);
    	graph.connect(1,4);
        graph.connect(4,6);
    	int node1 = 1;
    	int node2 = 4;
    	if(graph.query(1,4))
    		System.out.format("Node %d and %d are connected.\n",node1,node2);
    	else
    		System.out.format("Node %d and %d are not connected.\n",node1,node2);
    }
}