/**
given an array of numbers, find two numbers whose sum is closest to a target, 
return the difference between their sum and the target.
public int twoSumClosest(int[] nums, int target)
*/

import java.util.*;

public class TwoSumClosest{
	public static int twoSumClosest(int[] nums, int target){
		if(nums == null || nums.length <= 1)
			return target;
		quicksort(nums,0,nums.length-1);
		int closestSoFar = Integer.MAX_VALUE;
		for(int i = 0; i<nums.length-1;i++){
			int a = target - nums[i];
			int start = i+1;
			int end = nums.length-1;
			while(end-start > 1){
				int mid = start + (end - start)/2;
				if(mid == a)
					return 0;
				else if(mid > a)
					end = mid;
				else
					start = mid;
			}
			a = Math.min(Math.abs(nums[start]-a),Math.abs(nums[end]-a));
			if(a < closestSoFar)
				closestSoFar = a;
		}
		return closestSoFar;
	}
	public static void quicksort(int[] nums, int start, int end){
		if(nums != null && nums.length > 1 && end - start > 0){
			int i = start - 1;
			for(int j = start; j < end; j++){
				if(nums[j]<nums[end]){
					int mid = nums[j];
					i += 1;
					nums[j] = nums[i];
					nums[i] = mid;
				}
			}
			int mid = nums[end];
			nums[end] = nums[i+1];
			nums[i+1] = mid;
			quicksort(nums,start,i);
			quicksort(nums,i+2,end);
		}
	}
	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		int target = 4;
		System.out.format("The array is %s.\n", Arrays.toString(nums));
		System.out.format("The closest two sum from %d is %d.\n",target,twoSumClosest(nums,target));
	}
}