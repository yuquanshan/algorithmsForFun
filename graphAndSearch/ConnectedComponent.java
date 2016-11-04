/**
* find the connected component in an undirected graph.
* public static List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes)
*/
import java.util.*;

public class ConnectedComponent{
	public static List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes){
		if(nodes == null || nodes.size() == 0){
			return new ArrayList<List<Integer>>();
		}
		HashSet<UndirectedGraphNode> visitedSet = new HashSet<UndirectedGraphNode>();
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(UndirectedGraphNode node: nodes){
			if(!visitedSet.contains(node)){
				ArrayList<Integer> list = new ArrayList<Integer>();
				queue.push(node);
				visitedSet.add(node);
				while(!queue.isEmpty()){
					int size = queue.size();
					for(int i = 0; i<size; i++){
						UndirectedGraphNode tmp = queue.pop();
						list.add(tmp.label);
						visitedSet.add(tmp);
						for(UndirectedGraphNode mid: tmp.neighbors){
							if(!visitedSet.contains(mid)){
								queue.push(mid);
								visitedSet.add(mid);
							}
						}
					}
				}
				Collections.sort(list);	
				res.add(list);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node3 = new UndirectedGraphNode(3);
		UndirectedGraphNode node4 = new UndirectedGraphNode(4);
		UndirectedGraphNode node5 = new UndirectedGraphNode(5);
		node1.neighbors.add(node2); node1.neighbors.add(node4);
		node2.neighbors.add(node1); node2.neighbors.add(node4);
		node3.neighbors.add(node5);
		node4.neighbors.add(node1); node4.neighbors.add(node2);
		node5.neighbors.add(node3);
		ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
		nodes.add(node1); nodes.add(node2); nodes.add(node3); nodes.add(node4); nodes.add(node5);
		List<List<Integer>> res = connectedSet(nodes);
		for(List<Integer> list: res){
			System.out.println(list.toString());
		}
	}
}