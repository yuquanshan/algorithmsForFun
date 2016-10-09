/**
* given an array of integers, find the two non-overlapping subarrays
* with the max sum.
* public static int maxSum(ArrayList<Integer> nums)
*/

import java.util.*;

public class MaxTwoSubarraySum{
	public static int maxSum(ArrayList<Integer> nums){
		if(nums==null || nums.size()==0)
			return 0;
		if(nums.size()==1)
			return nums.get(0);
		int[] maxFromLeft = new int[nums.size()];
		int[] maxSoFarLeft = new int[nums.size()];
		int[] maxFromRight = new int[nums.size()];
		int[] maxSoFarRight = new int[nums.size()];
		maxFromLeft[0] = nums.get(0);
		maxSoFarLeft[0] = nums.get(0);
		for(int i=1; i<nums.size();i++){
			maxFromLeft[i] = Math.max(maxFromLeft[i-1]+nums.get(i),nums.get(i));
			maxSoFarLeft[i] = Math.max(maxSoFarLeft[i-1],maxFromLeft[i]);
		}
		maxFromRight[nums.size()-1] = nums.get(nums.size()-1);
		maxSoFarRight[nums.size()-1] = nums.get(nums.size()-1);
		for(int i=nums.size()-2; i>=0; i--){
			maxFromRight[i] = Math.max(maxFromRight[i+1]+nums.get(i),nums.get(i));
			maxSoFarRight[i] = Math.max(maxSoFarRight[i+1],maxFromRight[i]);
		}
		int res = 0;
		for(int i=0; i<nums.size()-1; i++){
			res = (res<maxSoFarLeft[i]+maxSoFarRight[i+1])?maxSoFarLeft[i]+maxSoFarRight[i+1]:res;
		}
		return res;
	}
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(3);
		nums.add(-1);
		nums.add(2);
		nums.add(-1);
		nums.add(2);
		System.out.format("The array is %s, the max two-subarray sum is %d.\n",nums.toString(),maxSum(nums));
	}
}