/**
given an int array, find a subarray whose sum is zero,
return the indices of the first and last element of this subarray.
public static ArrayList<Integer> zeroSubarray(int[] nums)
(didn't know how to do until seeing the tag "hash table".)
*/
import java.util.*;

public class ZeroSumSubarray{
	public static ArrayList<Integer> zeroSubarray(int[] nums){
		if(nums == null || nums.length == 0)
			return null;
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();	// key is sum so far, value is index
		table.put(0,-1);
		int sum = 0;
		for(int i = 0; i<nums.length; i++){
			sum = sum + nums[i];
			if(table.containsKey(sum)){
				ArrayList<Integer> res = new ArrayList<Integer>();
				res.add(table.get(sum)+1);
				res.add(i);
				return res;
			}else{
				table.put(sum,i);
			}
		} 
		return null;
	}
	public static void main(String[] args) {
		int[] nums = {-5,10,5,-3,1,1,1,-2,3,-4};
		ArrayList<Integer> res = zeroSubarray(nums);
		System.out.format("Array is %s.\n",Arrays.toString(nums));
		if(res == null)
			System.out.println("There is no zero sum subarray.");
		else
			System.out.format("The first zero sum subarray is from index %d to %d.\n",res.get(0),res.get(1));
	}
}