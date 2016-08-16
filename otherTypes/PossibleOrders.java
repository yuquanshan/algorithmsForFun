/**
given a list with non-identical elements, find all possible orders
(a recursive approach)
*/
import java.util.*;
public class PossibleOrders{
	public static ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums){
		Collections.sort(nums);
		return visit(nums);
	}
	public static ArrayList<ArrayList<Integer>> visit(ArrayList<Integer> tobevisited){
		Integer last = new Integer(-991321);	// very unlikely number
		if (tobevisited.size() == 0){
			ArrayList<ArrayList<Integer>> alist = new ArrayList<ArrayList<Integer>>();
			alist.add(new ArrayList<Integer>());
			return alist;
		}
		ArrayList<ArrayList<Integer>> hugelist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<tobevisited.size(); i++){
			if(!tobevisited.get(i).equals(last)){
				Integer a = tobevisited.get(i);
				last = a;
				ArrayList<Integer> rem = new ArrayList<Integer>(tobevisited);	// remove it from the list
				rem.remove(i);
				ArrayList<ArrayList<Integer>> rest = visit(rem);
				for (int j=0; j<rest.size(); j++){
					rest.get(j).add(a);
				}
				hugelist.addAll(rest);
			}
		}
		return hugelist;
	}
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(new Integer(1));
		numbers.add(new Integer(2));
		numbers.add(new Integer(2));
		ArrayList<ArrayList<Integer>> possible = permuteUnique(numbers);
		System.out.println(possible);
	}
}