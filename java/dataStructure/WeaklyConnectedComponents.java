/**
* find the number of weak connected component in the directed graph.
* the weak connect component is the subgraph 'weakly' connected by 
* edges in either direction, e.g., A--->B<---C
* class DirectedGraphNode {
*     int label;
*     ArrayList<DirectedGraphNode> neighbors;
*     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
* };
* public static List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes){}
*/
import java.util.*;

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
};

public class WeaklyConnectedComponents{
	public static List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes){
		HashMap<DirectedGraphNode,DirectedGraphNode> map = new HashMap<DirectedGraphNode,DirectedGraphNode>();
		for(DirectedGraphNode node: nodes){
			map.put(node,null);
		}
		for(DirectedGraphNode node: nodes){
			for(DirectedGraphNode neighbor: node.neighbors){
				DirectedGraphNode root1 = node;
				while(map.get(root1)!=null){
					root1 = map.get(root1);
				}
				DirectedGraphNode root2 = neighbor;
				while(map.get(root2)!=null){
					root2 = map.get(root2);
				}
				if(root2!=root1){
					map.put(root2,root1);
				}
			}
		}
		HashMap<DirectedGraphNode,ArrayList<Integer>> resmap = new HashMap<DirectedGraphNode,ArrayList<Integer>>();
		for(DirectedGraphNode node: nodes){
			DirectedGraphNode root = node;
			while(map.get(root)!=null){
				root = map.get(root);
			}
			if(!resmap.containsKey(root)){
				resmap.put(root,new ArrayList<Integer>());
				resmap.get(root).add(node.label);
			}else{
				resmap.get(root).add(node.label);
			}
		}
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		for(DirectedGraphNode key: resmap.keySet()){
			res.add(resmap.get(key));
		}
		return res;
	}
	public static void main(String[] args) {
		DirectedGraphNode nodeA = new DirectedGraphNode(1);
		DirectedGraphNode nodeB = new DirectedGraphNode(2);
		DirectedGraphNode nodeC = new DirectedGraphNode(3);
		DirectedGraphNode nodeD = new DirectedGraphNode(4);
		DirectedGraphNode nodeE = new DirectedGraphNode(5);
		DirectedGraphNode nodeF = new DirectedGraphNode(6);
		nodeA.neighbors.add(nodeB); nodeB.neighbors.add(nodeD);
		nodeB.neighbors.add(nodeD);
		nodeC.neighbors.add(nodeE);
		nodeF.neighbors.add(nodeE);
		/*
			A ----> B    C
			 \      |    |
			  \     |    |
			   \    |    |
			    \   |    |
			     -> D    E <- F
		*/
		ArrayList<DirectedGraphNode> input = new ArrayList<DirectedGraphNode>();
		input.add(nodeA); input.add(nodeB); input.add(nodeC); input.add(nodeD);
		input.add(nodeE); input.add(nodeF);
		List<List<Integer>> res = connectedSet2(input);
		System.out.format("The result is %s\n",res.toString());
	}
}