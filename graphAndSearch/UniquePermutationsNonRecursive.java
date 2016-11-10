/**
* find all unique permutations of an array (may contain dups)
* public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums){}
* (try to solve it non-recursively)
* (failed to finish it on time for the first time)
*/
import java.util.*;

public class UniquePermutationsNonRecursive{
	public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums){
		if(nums == null || nums.size()==0)
			return new ArrayList<ArrayList<Integer>>();
		Collections.sort(nums);
		ArrayList<Integer> indxstack = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> stack = new ArrayList<ArrayList<Integer>>();
		stack.add(nums);
		indxstack.add(-1);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		while(stack.size() != 0){
			//System.out.format("stacktop: %s indtop: %d\n",stack.get(stack.size()-1),indxstack.get(indxstack.size()-1));
			if(indxstack.get(indxstack.size()-1) == stack.get(stack.size()-1).size()-1){
				if(stack.size() == nums.size()){
					ArrayList<Integer> list = new ArrayList<Integer>();
					for(int i = 0; i<stack.size(); i++){
						list.add(stack.get(i).get(indxstack.get(i)));
					}
					res.add(list);
				}
				stack.remove(stack.size()-1);
				indxstack.remove(indxstack.size()-1);
			}else{
				int pt = indxstack.get(indxstack.size()-1);
				if(pt == -1){
					pt = 0;
					indxstack.set(indxstack.size()-1,pt);
					ArrayList<Integer> tmp = new ArrayList<Integer>(stack.get(stack.size()-1));
					tmp.remove(pt);
					stack.add(tmp);
					indxstack.add(-1);
				}else{
					int num = stack.get(stack.size()-1).get(pt);
					boolean cont = false;
					for(pt = indxstack.get(indxstack.size()-1); pt<stack.get(stack.size()-1).size(); pt++){
						if(stack.get(stack.size()-1).get(pt) != num){
							ArrayList<Integer> tmp = new ArrayList<Integer>(stack.get(stack.size()-1));
							tmp.remove(pt);
							stack.add(tmp);
							indxstack.set(indxstack.size()-1,pt);
							indxstack.add(-1);
							cont = true;
							break;
						}
					}
					if(!cont)
						indxstack.set(indxstack.size()-1,pt-1);
				}
			}
		} 
		return res;
	}
	public static void main(String[] args) {
		ArrayList<Integer> S = new ArrayList<Integer>();
		S.add(1); S.add(2); S.add(2);
		ArrayList<ArrayList<Integer>> res = permuteUnique(S);
		System.out.println(res.toString());
	}
}