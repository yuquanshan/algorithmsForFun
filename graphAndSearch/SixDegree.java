/**
* given a graph and two nodes, find the degree of two nodes. 
* public static int degree(List<UndirectedGraphNode> graph, 
* UndirectedGraphNode s, UndirectedGraphNode t)
*/
import java.util.*;

public class SixDegree{
	public static int sixDegree(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t){
		if(graph == null || s == null || t == null)
			return -1;
		if(s == t)
			return 0;
		for(UndirectedGraphNode node: graph){
			if(node == s)
				node.label = 0;
			else
				node.label = Integer.MAX_VALUE-1;
		}
		for(int i = 0; i<6; i++){
			for(UndirectedGraphNode node: graph){
				for(UndirectedGraphNode tmp: node.neighbors){
					node.label = (node.label > tmp.label+1)? tmp.label+1:node.label;
				}
			}
		}
		if(t.label <= 6)
			return t.label;
		else
			return -1;
	} 
	public static void main(String[] args) {
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node3 = new UndirectedGraphNode(3);
		UndirectedGraphNode node4 = new UndirectedGraphNode(4);
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		ArrayList<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
		list.add(node1); list.add(node2); list.add(node3); list.add(node4);
		System.out.format("The degree between node1  and node3 is %d\n",sixDegree(list,node1,node3));
	}
}
