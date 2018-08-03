/**
* given a set of candidate numbers, find all unique combinations  
* of candidate numbers which sum to a target number.
* public static List<List<Integer>> combinationSum(int[] candidates, int target)
*/
import java.util.*;
import java.util.stream.*;

public class CombinationSum{
	public static List<List<Integer>> combinationSum(int[] candidates, int target){
		candidates = IntStream.of(candidates).distinct().toArray();
		Arrays.sort(candidates);
		if(candidates == null || candidates.length == 0 || target <= 0 || target < candidates[0])
			return new ArrayList<List<Integer>>();
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i<candidates.length; i++){
			if(target == candidates[i]){	// want to distiguish the case where target == 0, and the case where any combination is impossible
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(candidates[i]);
				res.add(list);
			}else{
				List<List<Integer>> tmp = combinationSum(Arrays.copyOfRange(candidates,i,candidates.length),target-candidates[i]);
				if(tmp.size() > 0){
					for(List<Integer> list: tmp)
						list.add(0,candidates[i]);
					res.addAll(tmp);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res = combinationSum(candidates,target);
		System.out.format("These combinations: %s sum to %d\n",res.toString(),target);
	}
}