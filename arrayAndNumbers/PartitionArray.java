/**
given an array num[] and a target, partition the array and 
return an index i, such that nums[x] >= k when x >= i.
public static int partitionArray(int[] nums, int k)
*/

import java.util.*;

public class PartitionArray{
	public static int partitionArray(int[] nums, int k){
		if(nums == null || nums.length == 0)
			return -1;
		int i = -1;
		for(int j = 0; j < nums.length; j++){
			if(nums[j]<k){
				i += 1;
				int mid = nums[i];
				nums[i] = nums[j];
				nums[j] = mid;
			}
		}
		return i+1;
	}
	public static void main(String[] args) {
		int[] nums = {3,2,2,1};
		int k = 2;
		System.out.format("Current array is %s.\n", Arrays.toString(nums));
		System.out.format("The result is %d.\n",partitionArray(nums,k));
	}
}