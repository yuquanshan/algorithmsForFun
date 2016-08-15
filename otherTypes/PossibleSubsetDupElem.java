/**
Given a set of integers (elements may not be identical), find all possible subsets
both resursive and non-recursive approaches
*/
import java.util.*;

class largerThan implements Comparator<Integer>{
	public int compare(Integer a, Integer b){
		return b.intValue() - a.intValue();
	}
}

public class PossibleSubsetDupElem{
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S){
		//Integer[] array = S.toArray(new Integer[S.size()]);
		//Arrays.sort(array,new largerThan());	// sort in descending order
		Collections.sort(S, new largerThan());
		//return sortedSubsetsWithDup(new ArrayList<Integer>(Arrays.asList(array)));
		return sortedSubsetsWithDup(new ArrayList<Integer>(S));
	}
	public static ArrayList<ArrayList<Integer>> sortedSubsetsWithDup(ArrayList<Integer> S){	// a recursive approach
		if (S.isEmpty()){
			return new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>()));	
		}
		Integer n = S.get(0);	
		S.remove(0);// cut the head of the list
		System.out.println(n+" "+S);
		ArrayList<ArrayList<Integer>> part = sortedSubsetsWithDup(S);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(part);
		for(int i = 0; i < part.size(); i++){
			ArrayList<Integer> pinch = new ArrayList<Integer>(part.get(i));
			pinch.add(n);
			if (!res.contains(pinch)) {
				//System.out.println("Add " + pinch + " to " + res);
				res.add(pinch);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(2));
		System.out.println(subsetsWithDup(list));
	}
}