/**
* given an array of numbers (may have dups), find all possible subsets, the elements
* in each subset must be in non-descending order.
* public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) 
* (failed to write an algorithm on time)
*/
import java.util.*;

public class SubsetWithDupNonRecursive{
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S){
		if(S == null || S.size() == 0)
			return new ArrayList<ArrayList<Integer>>();
		Collections.sort(S);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> queue1 = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> queue2 = new ArrayList<Integer>();
		queue1.add(new ArrayList<Integer>());
		queue2.add(-1);
		while(queue1.size() != 0){	// a BFS approach
			int size = queue1.size();
			for(int i = 0; i<size; i++){
				ArrayList<Integer> list = queue1.remove(0);
				int begin = queue2.remove(0)+1;
				res.add(list);
				int old = Integer.MAX_VALUE;
				for(int j = begin; j<S.size(); j++){
					if(S.get(j) != old){
						ArrayList<Integer> newlist = new ArrayList<Integer>(list);
						newlist.add(S.get(j));
						old = S.get(j);
						queue1.add(newlist);
						queue2.add(j);
					}
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		ArrayList<Integer> S = new ArrayList<Integer>();
		S.add(1); S.add(2); S.add(2);
		ArrayList<ArrayList<Integer>> res = subsetsWithDup(S);
		System.out.println(res.toString());
	}
}