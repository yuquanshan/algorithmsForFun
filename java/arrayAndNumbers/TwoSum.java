/**
* given a array of numbers and a target, return i and j such that
* ith and jth element of the array sum to the target.
* public static int[] twoSum(int[] numbers, int target)
*/
import java.util.*;

public class TwoSum{
	public static int[] twoSum(int[] numbers, int target){
		if(numbers == null || numbers.length <= 1)
			return null;
		Hashtable<Integer,ArrayList<Integer>> htable = new Hashtable<Integer,ArrayList<Integer>>();
		for(int i = 0; i<numbers.length; i++){
			if(htable.containsKey(numbers[i])){
				htable.get(numbers[i]).add(i);
			}else{
				htable.put(numbers[i],new ArrayList<Integer>());
				htable.get(numbers[i]).add(i);
			}
		}
		for(int i = 0; i<numbers.length; i++){
			if(htable.containsKey(target-numbers[i])){
				if(target == 2*numbers[i] && htable.get(numbers[i]).size()>=2){
					int[] res = new int[2];
					res[0] = htable.get(numbers[i]).remove(0)+1;
					res[1] = htable.get(numbers[i]).remove(0)+1;
					return res;
				}else{
					int[] res = new int[2];
					res[0] = i+1;
					res[1] = htable.get(target-numbers[i]).remove(0)+1;
					return res;
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		int[] numbers = {2,7,11,15};
		int target = 9;
		System.out.format("The array is %s.\n",Arrays.toString(numbers));
		int[] res = twoSum(numbers,target);
		if(res != null){
			System.out.format("%dth and %dth element sum to %d.\n",res[0],res[1],target);
		}else{
			System.out.format("There is no two element summing to %d.\n",target);
		}
	}
}