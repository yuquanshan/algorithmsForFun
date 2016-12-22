/**
* given an array of numbers, find two numbers whose sum is closest to a target, 
* return the difference between their sum and the target.
* public int twoSumClosest(int[] nums, int target)
* (witnessed in Google interview)
*/

import java.util.*;

public class TwoSumClosest{
	public static int twoSumClosest(int[] nums, int target){
		if(nums == null || nums.length < 2)
			return Integer.MAX_VALUE;
		Arrays.sort(nums);
		int res = Integer.MAX_VALUE;
		int left = 0;
		int right = nums.length-1;
		while(left<right){	// correctness can be proved by induction
			if(nums[left]+nums[right] == target)
				return 0;
			else if(nums[left]+nums[right] > target){
				res = Math.min(Math.abs(nums[left]+nums[right]-target),res);
				right--;
			}else{
				res = Math.min(Math.abs(nums[left]+nums[right]-target),res);
				left++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		int target = 4;
		System.out.format("The array is %s.\n", Arrays.toString(nums));
		System.out.format("The closest two sum from %d is %d.\n",target,twoSumClosest(nums,target));
	}
}