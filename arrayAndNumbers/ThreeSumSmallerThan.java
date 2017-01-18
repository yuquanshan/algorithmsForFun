/* Given an array of n integers nums and a target, find the number 
* of index triplets i, j, k with 0 <= i < j < k < n that satisfy 
* the condition nums[i] + nums[j] + nums[k] < target.
* For example, given nums = [-2, 0, 1, 3], and target = 2, the answer 
* should be .
* public int threeSumSmaller(int[] nums, int target)
*/

import java.util.*;

public class ThreeSumSmallerThan{
	public static int threeSumSmaller(int[] nums, int target){
		int count = 0;
		Arrays.sort(nums);
		for(int i = nums.length-1; i >= 2; i--){	// the third member
			int start = 0;
			int end = i-1;
			int t = target - nums[i];
			while(start < end){
				if(nums[start]+nums[end]<t){
					count += end - start;
					start++;
				}else{
					end--;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[] nums = {0,1,-2,3};
		int target = 2;
		System.out.format("Three sum smaller than result with %s, and target %d is %d\n", Arrays.toString(nums), target, threeSumSmaller(nums,target));
	}
}