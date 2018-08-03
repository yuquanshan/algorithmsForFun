/**
* given a string of characters, find all permutations.
* public static List<String> stringPermutation(String str)
* (didn't pass the test for the first time with an algorithm which 
* i don't think asymptotically more complex than this one...)
*/

import java.util.*;

public class StringPermutation{
	public static List<String> stringPermutation(String str){
		if(str == null || str.length() == 0){
			List<String> res = new ArrayList<String>();
			res.add("");
			return res;
		}
		List<String> res = new ArrayList<String>();
		char[] ca = new char[str.length()];
		for(int i=0; i<ca.length; i++){
			ca[i] = str.charAt(i);
		}
		helper(ca,res,0);
		return res;
	}
	public static void helper(char[] ca, List<String> res, int pos){	// pos is the starting position of the array to permute
		if(pos == ca.length)
			res.add(String.valueOf(ca));
		HashSet<Character> visited = new HashSet<Character>();
		for(int i=pos; i<ca.length; i++){
			if(!visited.contains(ca[i])){
				visited.add(ca[i]);
				swap(ca,pos,i);
				helper(ca, res, pos+1);
				swap(ca,pos,i);
			}
		}
	}
	public static void swap(char[] ca, int i, int j){
		char mid = ca[j];
		ca[j] = ca[i];
		ca[i] = mid;
	}
	public static void main(String[] args) {
		String str = "abb";
		List<String> res = stringPermutation(str);
		System.out.format("The permutations of %s is %s\n",str,res.toString());
	}
}