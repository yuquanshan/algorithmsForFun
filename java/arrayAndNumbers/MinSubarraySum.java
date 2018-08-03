/**
* given an array return the minimum sum of its subarray
* public static int minSum(ArrayList<Integer> nums)
*/
import java.util.*;
public class MinSubarraySum{
	public static int minSum(ArrayList<Integer> nums){
		if(nums == null || nums.size() == 0)
			return 0;
		int minSoFar = nums.remove(0);
		int[] array = new int[nums.size()+1];
		array[0] = minSoFar;
		int count = 1;
		while(nums.size()!=0){
			int tmp = nums.remove(0);
			array[count] = Math.min(array[count-1]+tmp,tmp);
			if(array[count]<minSoFar)
				minSoFar = array[count];
			count += 1;
		}
		return minSoFar;
	}
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(-1);
		nums.add(-2);
		nums.add(1);
		System.out.format("The min subarray sum of %s is %d.\n",nums.toString(),minSum(nums));
	}
}