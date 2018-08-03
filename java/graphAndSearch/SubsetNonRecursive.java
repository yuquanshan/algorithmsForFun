/**
* given an array of distinct integers, find all its subset.
* do it non-recursively. elements must be in non-descending order.
* public static ArrayList<ArrayList<Integer>> subsets(int[] nums)
*/
import java.util.*;

class SubsetStackNode{
	int id;
	boolean include;
 	int stage;
	public SubsetStackNode(int id, boolean include, int stage){
		this.id = id;
		this.include = include;
		this.stage = 0;
	}
}

public class SubsetNonRecursive{
	public static ArrayList<ArrayList<Integer>> subsets(int[] nums){
		if(nums == null || nums.length == 0){
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			res.add(new ArrayList<Integer>());
			return res;
		}
		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<SubsetStackNode> stack = new ArrayList<SubsetStackNode>();
		stack.add(new SubsetStackNode(-1,true,0));	
		while(stack.size() != 0){	/* 	oops, though this passes the Lintcode test anyway, 
										but this DFS approach is less optimal, first there is a better
										way of expressing stack, i.e., Node{int id; int pt}, pt is pointing
										to the index of its current child node, this can shorten depth of 
										some branches.
										second, bfs (each node represents a subset) is more straigntforward 
										and timely more effcient.
									*/
			if(stack.get(stack.size()-1).id == nums.length-1){
				ArrayList<Integer> tmp = makeList(stack,nums);
				res.add(tmp);
				stack.remove(stack.size()-1);
			}else{
				if(stack.get(stack.size()-1).stage==0){
					int size = stack.size();
					stack.get(size-1).stage++;
					stack.add(new SubsetStackNode(stack.get(size-1).id+1,true,0));
				}else if(stack.get(stack.size()-1).stage == 1){
					int size = stack.size();
					stack.get(size-1).stage++;
					stack.add(new SubsetStackNode(stack.get(size-1).id+1,false,0));
				}else{
					stack.remove(stack.size()-1);
				}
			}
		}
		return res;
	}
	public static ArrayList<Integer> makeList(ArrayList<SubsetStackNode> stack, int[] nums){
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 1; i <= nums.length; i++){
			if(stack.get(i).include){
				res.add(nums[stack.get(i).id]);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] S = {1,2,3};
		System.out.format("All subsets of %s are %s\n", Arrays.toString(S),subsets(S).toString());
	}
}