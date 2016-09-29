/**
given an array of integers, return the maximum sum of its subarray.
public static int maxSubsum(int[] nums)
*/
import java.util.*;

public class MaxSubarraySum{
	public static int maxSubsum(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		int maxSoFar = nums[0];
		for(int i = 1; i < nums.length; i++){
			nums[i] = Math.max(nums[i-1]+nums[i],nums[i]);
			if(nums[i] > maxSoFar)
				maxSoFar = nums[i];
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		int[] nums = {-2,2,-3,4,-1,2,1,-5,3};
		System.out.format("The current array is %s.\n",Arrays.toString(nums));
		System.out.format("The max subarray sum is %d.\n", maxSubsum(nums));
	}
}