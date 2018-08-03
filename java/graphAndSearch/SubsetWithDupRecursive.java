/**
* given an array of numbers (may have dups), find all possible subsets, the elements
* in each subset must be in non-descending order.
* public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) 
* (failed to write an algorithm on time)
*/
import java.util.*;

public class SubsetWithDupRecursive{
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S){
		if(S == null || S.size() == 0)
			return new ArrayList<ArrayList<Integer>>();
		Collections.sort(S);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> pass = new ArrayList<Integer>();
		res.add(pass);
		subWithPass(pass,0,S,res);
		return res;
	}
	public static void subWithPass(ArrayList<Integer> pass, int start, ArrayList<Integer> S, ArrayList<ArrayList<Integer>> res){
		if(start == 0){
			int old = Integer.MAX_VALUE;
			while(start < S.size()){
				if(old != S.get(start)){
					old = S.get(start);
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(old);
					res.add(tmp);
					subWithPass(tmp,start+1,S,res);
				}
				start++;
			}
		}else{
			int old = pass.get(pass.size()-1);
			int anstr = S.get(start-1);
			while(start < S.size()){
				if(anstr == S.get(start)){
					ArrayList<Integer> tmp = new ArrayList<Integer>(pass);
					tmp.add(S.get(start));
					res.add(tmp);
					subWithPass(tmp,start+1,S,res);
				}else{
					if(old != S.get(start)){
						old = S.get(start);
						ArrayList<Integer> tmp = new ArrayList<Integer>(pass);
						tmp.add(S.get(start));
						res.add(tmp);
						subWithPass(tmp,start+1,S,res);
					}
				}
				start++;
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> S = new ArrayList<Integer>();
		S.add(1); S.add(2); S.add(2);
		ArrayList<ArrayList<Integer>> res = subsetsWithDup(S);
		System.out.println(res.toString());
	}
}
