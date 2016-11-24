/**
* given an array, find the number of pairs whose sum is bigger than 
* a target number.
* public static int twoSum2(int[] nums, int target)
*/

import java.util.*;

public class TwoSumBiggerThan{
	public static int twoSum2(int[] nums, int target){
		if(nums == null || nums.length < 2)
			return 0;
		Arrays.sort(nums);
		int count = 0;
		for(int i = 0; i < nums.length-1; i++){
			int aim = target - nums[i];
			int start = i+1;
			int end = nums.length-1;
			while(end - start > 1){
				int mid = start + (end-start)/2;
				if(nums[mid] <= aim)
					start = mid;
				else
					end = mid;
			}
			if(nums[start]>aim){
				count += nums.length - start;
			}else if(nums[end]>aim){
				count += nums.length - end;
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