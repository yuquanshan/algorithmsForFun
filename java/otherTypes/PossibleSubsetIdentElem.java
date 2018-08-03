/**
 * find all possible subset of a large set with identical element
 * (a recursive approach)
 */
import java.util.*;

public class PossibleSubsetIdentElem{
	public static ArrayList<ArrayList<Integer>> subsets(int[] nums){
		if (nums.length == 0){
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			list.add(new ArrayList<Integer>());
			return list;
		}
		/*if (nums.length == 1){
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			list.add(new ArrayList<Integer>());
			ArrayList<Integer> li = new ArrayList<Integer>();
			li.add(new Integer(nums[0]));
			list.add(li);
			return list;
		}*/
		Integer tail = new Integer(nums[nums.length-1]);
		ArrayList<ArrayList<Integer>> already = subsets(Arrays.copyOfRange(nums,0,nums.length-1));
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(already);
		for(int i = 0; i < already.size(); i++){
			ArrayList<Integer> newlist = new ArrayList<Integer>(already.get(i));
			newlist.add(tail);
			res.add(newlist);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] S = {1,2};
		ArrayList<ArrayList<Integer>> res = subsets(S);
		System.out.println("Input: "+S+" output: "+res);
	}
}