/**
* given n unique integers, number k and target, find all possible 
* k integers where their sum is the target.
* public static ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target)
*/

import java.util.*;

public class AllKSum{
	public static ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target){
		if(A.length < k)
			return null;
		Arrays.sort(A);
		ArrayList<ArrayList<Integer>> res = helper(A, k, target);
		return res;
	}
	public static ArrayList<ArrayList<Integer>> helper(int[] A, int k, int target){
		if((A == null || A.length == 0 || k == 0) && target != 0)
			return null;
		if(k == 0 && target == 0){
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			res.add(new ArrayList<Integer>());
			return res;
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= A.length - k; i++){
			int it = A[i];
			ArrayList<ArrayList<Integer>> tmp = helper(Arrays.copyOfRange(A,i+1,A.length),k-1,target-it);
			//System.out.println(Arrays.toString(Arrays.copyOfRange(A,i+1,A.length)));
			if(tmp != null && tmp.size() != 0){
				for(ArrayList<Integer> list: tmp){
					list.add(0,it);
				}
				res.addAll(tmp);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		int target = 5;
		int k = 2;
		ArrayList<ArrayList<Integer>> res = kSumII(A,k,target);
		System.out.format("The %d-sums of %s with target %d are:\n",k,Arrays.toString(A),target);
		if(res != null){
			System.out.println(res.toString());
		}else{
			System.out.println("null");
		}
	}
}