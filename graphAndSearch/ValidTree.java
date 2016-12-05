/**
* given n nodes labeled from 0 to n-1, and a list of undirected edges,
* e.g., {{0,1},{0,2},...} verify whether they construct a valid tree.
* public static boolean validTree(int n, int[][] edges)
*/

import java.util.*;

public class ValidTree{
	public static boolean validTree(int n, int[][] edges){
		if(n == 1)
			return true;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for(int i = 0; i<n; i++){
			map.put(i,n+1);
		}
		for(int i = 0; i<edges.length; i++){
			int root1 = edges[i][0];
			int root2 = edges[i][1];
			visited.add(root1); visited.add(root2);
			int count1 = 1;
			while(map.get(root1)!=n+1){
				root1 = map.get(root1);
				count1++;
			}
			int count2 = 1;
			while(map.get(root2)!=n+1){
				root2 = map.get(root2);
				count2++;
			}
			if(root1==root2)
				return false;
			if(count1>=count2)
				map.put(root2,root1);
			else
				map.put(root1,root2);
		}
		for(int i = 0; i<n; i++)
			if(!visited.contains(i))
				return false;
		return true;
	}
	public static void main(String[] args) {
		int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
		int n = 5;
		if(validTree(n,edges))
			System.out.println("Valid tree!");
		else
			System.out.println("Not valid tree!");
	}
}