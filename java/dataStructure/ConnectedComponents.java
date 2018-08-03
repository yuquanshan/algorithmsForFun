/**
* find the connected components in an undirected graph.
* Definition for Undirected graph.
* class UndirectedGraphNode {
*     int label;
*     ArrayList<UndirectedGraphNode> neighbors;
*     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
* };
* public static List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes)
* (try to use union find this time)
*/

import java.util.*;

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class ConnectedComponents{
	public static List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> cap = new HashMap<Integer,Integer>();
		for(UndirectedGraphNode node: nodes){
			cap.put(node.label,1);
			map.put(node.label,Integer.MIN_VALUE);
		}
		HashSet<Integer> visited = new HashSet<Integer>();
		for(UndirectedGraphNode node: nodes){
			if(!visited.contains(node.label)){
				visited.add(node.label);
				for(UndirectedGraphNode neighbor: node.neighbors){
					if(!visited.contains(neighbor.label)){
						int root1 = node.label;
						int root2 = neighbor.label;
						while(map.get(root1)!=Integer.MIN_VALUE){
							root1 = map.get(root1);
						}
						while(map.get(root2)!=Integer.MIN_VALUE){
							root2 = map.get(root2);
						}
						if(root1!=root2){
							if(cap.get(root1)>=cap.get(root2)){
								map.put(root2,root1);
								cap.put(root1,cap.get(root1)+cap.get(root2));
							}else{
								map.put(root1,root2);
								cap.put(root2,cap.get(root1)+cap.get(root2));
							}
						}
					}
				}
			}
		}
		HashMap<Integer,ArrayList<Integer>> resmap = new HashMap<Integer,ArrayList<Integer>>();
		for(UndirectedGraphNode node:nodes){
			int root = node.label;
			while(map.get(root)!=Integer.MIN_VALUE){
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
		for(int key: resmap.keySet()){
			res.add(resmap.get(key));
		}
		return res;
	}
	public static void main(String[] args) {
		UndirectedGraphNode nodeA = new UndirectedGraphNode(1);
		UndirectedGraphNode nodeB = new UndirectedGraphNode(2);
		UndirectedGraphNode nodeC = new UndirectedGraphNode(3);
		UndirectedGraphNode nodeD = new UndirectedGraphNode(4);
		UndirectedGraphNode nodeE = new UndirectedGraphNode(5);
		nodeA.neighbors.add(nodeB); nodeA.neighbors.add(nodeD);
		nodeB.neighbors.add(nodeA); nodeB.neighbors.add(nodeD);
		nodeD.neighbors.add(nodeA); nodeD.neighbors.add(nodeB);
		nodeC.neighbors.add(nodeE);
		nodeE.neighbors.add(nodeC);
		ArrayList<UndirectedGraphNode> input = new ArrayList<UndirectedGraphNode>();
		input.add(nodeA); input.add(nodeB); input.add(nodeC); input.add(nodeD); input.add(nodeE);
		List<List<Integer>> res = connectedSet(input);
		System.out.format("The connected components are %s\n",res.toString()); 
	}
}