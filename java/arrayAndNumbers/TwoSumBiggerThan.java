/**
* given an array, find the number of pairs whose sum is bigger than 
* a target number.
* public static int twoSum2(int[] nums, int target)
* (didn't notice the two pointer approach for the first time)
*/

import java.util.*;

public class TwoSumBiggerThan{
	public static int twoSum2(int[] nums, int target){
		if(nums == null || nums.length < 2)
			return 0;
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length-1;
		int count = 0;
		while(left < right){
			if(nums[left] + nums[right] > target){
				count += right-left;
				right--;
			}else{
				left++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99};
		int target = -64;
		System.out.format("The number of pairs in %s bigger than %d is %d\n", Arrays.toString(nums),target,twoSum2(nums,target));
	}
}