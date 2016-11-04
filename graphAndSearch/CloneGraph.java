/**
* given a node of a connected undirected graph, 
* clone this graph and return the corresponding 
* node of the cloned graph, assuming all nodes
* are uniquely labeled.
* public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
*/
import java.util.*;

public class CloneGraph{
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		if(node == null)
			return null;
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		UndirectedGraphNode res = new UndirectedGraphNode(node.label);
		HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		map.put(res.label,res);
		queue.add(node);
		visited.add(node);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i<size; i++){
				UndirectedGraphNode tmp = queue.poll();
				for(UndirectedGraphNode mid: tmp.neighbors){
					if(map.containsKey(mid.label)){
						map.get(tmp.label).neighbors.add(map.get(mid.label));
					}else{
						UndirectedGraphNode newnode = new UndirectedGraphNode(mid.label);
						map.put(mid.label,newnode);
						map.get(tmp.label).neighbors.add(newnode);
					}
					if(!visited.contains(mid)){
							queue.add(mid);
							visited.add(mid);
					}
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node4 = new UndirectedGraphNode(4);
		node1.neighbors.add(node2); node1.neighbors.add(node4);
		node2.neighbors.add(node1); node2.neighbors.add(node4);
		node4.neighbors.add(node1); node4.neighbors.add(node2);
		UndirectedGraphNode newnode = cloneGraph(node1);

	}
}