/**
* given a array of integers, find two non-overlapping subarrays 
* whose differences are the largest. return the largest difference.
* public static int maxDiff(int[] nums)
*/

import java.util.*;

public class MaxSubarrayDiff{
	public static int maxDiff(int[] nums){
		if(nums==null || nums.length<=1)
			return 0;
		int[] maxFromLeft = new int[nums.length];
		int[] minFromLeft = new int[nums.length];
		int[] maxFromRight = new int[nums.length];
		int[] minFromRight = new int[nums.length];
		maxFromLeft[0] = nums[0];
		minFromLeft[0] = nums[0];
		for(int i=1; i<nums.length; i++){
			maxFromLeft[i] = Math.max(maxFromLeft[i-1]+nums[i],nums[i]);
			minFromRight[i] = Math.min(minFromLeft[i-1]+nums[i],nums[i]);
		}
		maxFromRight[nums.length-1]=nums[nums.length-1];
		minFromRight[nums.length-1]=nums[nums.length-1];
		for(int i= nums.length-2; i>=0; i--){
			maxFromRight[i] = Math.max(maxFromRight[i+1]+nums[i],nums[i]);
			minFromRight[i] = Math.min(minFromRight[i+1]+nums[i],nums[i]);
		}
		for(int i=1; i<nums.length; i++){
			maxFromLeft[i] = Math.max(maxFromLeft[i-1],maxFromLeft[i]);
			minFromLeft[i] = Math.min(minFromLeft[i-1],minFromLeft[i]);
		}
		for(int i = nums.length-2; i>=0; i--){
			maxFromRight[i] = Math.max(maxFromRight[i],maxFromRight[i+1]);
			minFromRight[i] = Math.min(minFromRight[i],minFromRight[i+1]);
		}
		int res = 0;
		for(int i = 0; i<nums.length-1; i++){
			res = (res<Math.max(maxFromRight[i+1]-minFromLeft[i],maxFromLeft[i]-minFromRight[i+1]))?Math.max(maxFromRight[i+1]-minFromLeft[i],maxFromLeft[i]-minFromRight[i+1]):res;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,-3,1};
		System.out.format("The array is %s, the max subarray difference is %d.\n",Arrays.toString(nums),maxDiff(nums));
	}
}