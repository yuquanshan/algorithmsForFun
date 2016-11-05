/**
* given a directed graph, find its topological order.
* public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph)
* (exceeded memory limit for the first time)
*/
import java.util.*;

class TopNode{
	//boolean temp;	// temporary mark
	boolean perm;	// permanent mark
	DirectedGraphNode node;
	public TopNode(DirectedGraphNode node){
		this.node = node;
		//temp = false;
		perm = false;
	}
}

public class TopologicalSorting{
	public static ArrayList<DirectedGraphNode> topSortKahn(ArrayList<DirectedGraphNode> graph){	// a variant of Kahn's algorithm
		if(graph == null || graph.size() == 0)
			return new ArrayList<DirectedGraphNode>();
		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		HashMap<DirectedGraphNode, Integer> indegree = new HashMap<DirectedGraphNode, Integer>();	// recording all nodes with indegree, and # of incomming edges
		for(DirectedGraphNode node: graph){
			for(DirectedGraphNode kid: node.neighbors){
				if(indegree.containsKey(kid)){
					indegree.put(kid,indegree.get(kid)+1);
				}else{
					indegree.put(kid,1);
				}
			}
		}
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode node: graph){
			if(!indegree.containsKey(node)){
				queue.add(node);
			}
		}
		while(queue.peek()!=null){
			DirectedGraphNode parent = queue.poll();
			res.add(parent);
			for(DirectedGraphNode kid: parent.neighbors){
				if(indegree.get(kid) == 1){
					queue.add(kid);
				}else{
					indegree.put(kid,indegree.get(kid)-1);
				}
			}
		}
		return res;
	}
	public static ArrayList<DirectedGraphNode> topSortDFS(ArrayList<DirectedGraphNode> graph){	// a DFS approach
		if(graph == null || graph.size() == 0)
			return new ArrayList<DirectedGraphNode>();
		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		HashMap<DirectedGraphNode, TopNode> n2n = new HashMap<DirectedGraphNode, TopNode>();
		Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();	// stack the result
		for(DirectedGraphNode node: graph){
			n2n.put(node, new TopNode(node));
		}
		for(DirectedGraphNode node: graph){
			if(n2n.get(node).perm == false){
				visit(node,n2n,stack);
			}
		}
		while(!stack.empty()){
			res.add(stack.pop());
		}
		return res;
	}
	public static void visit(DirectedGraphNode node, HashMap<DirectedGraphNode, TopNode> n2n, Stack<DirectedGraphNode> stack){
		if(n2n.get(node).perm == false){
			for(DirectedGraphNode tmp: node.neighbors){
				visit(tmp,n2n,stack);
			}
			n2n.get(node).perm = true;
			stack.push(node);
		}
	}
	public static void main(String[] args) {
		DirectedGraphNode node1 = new DirectedGraphNode(1);
		DirectedGraphNode node2 = new DirectedGraphNode(2);
		DirectedGraphNode node3 = new DirectedGraphNode(3);
		node1.neighbors.add(node2); node1.neighbors.add(node3);
		node2.neighbors.add(node3);
		ArrayList<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>();
		graph.add(node1); graph.add(node2); graph.add(node3);
		ArrayList<DirectedGraphNode> list = topSortDFS(graph);
		for(DirectedGraphNode node: list)
			System.out.format("%d ", node.label);
		System.out.println();
	}
}