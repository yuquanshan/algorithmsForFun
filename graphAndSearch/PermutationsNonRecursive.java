/**
* given an array of numbers, find all its permutations,
* asssume there is no duplicated number.
* try to do it non-recursively.
* public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums)
*/
import java.util.*;

public class PermutationsNonRecursive{
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums){	//	yuquan(11/13/2016): now BFS looks better than DFS...
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(nums == null || nums.size() == 0)
			return res;
		ArrayList<ArrayList<Integer>> rest = new ArrayList<ArrayList<Integer>>();	// the numbers left for visit
		for(int i = 0; i<nums.size(); i++){
			ArrayList<Integer> begining = new ArrayList<Integer>();
			begining.add(nums.get(i));
			res.add(begining);
			ArrayList<Integer> left = new ArrayList<Integer>(nums);
			left.remove(i);
			rest.add(left);
		}
		int level = 1;
		while(level < nums.size()){
			int size = res.size();
			for(int i = 0; i<size; i++){
				ArrayList<Integer> curr = res.remove(0);
				ArrayList<Integer> next = rest.remove(0);
				for(int j = 0; j<next.size(); j++){
					ArrayList<Integer> newnext = new ArrayList<Integer>(next);
					ArrayList<Integer> newcurr = new ArrayList<Integer>(curr);
					newcurr.add(newnext.get(j));
					newnext.remove(j);
					res.add(newcurr);
					rest.add(newnext);
				}
			}
			level++;
		}
		return res;
	}
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1); nums.add(2); nums.add(3);
		System.out.format("The permutations of %s is %s.\n", nums.toString(), permute(nums).toString());
	}
}