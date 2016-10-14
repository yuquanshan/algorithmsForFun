/*
given an array of numbers and a number k, find k subarrays which have the largest sum.
public static int maxSubArray(int[] nums, int k)
(inspired by AtMostKPairsBuyNSellMaxProfit.java, it's a kind of simpler version of it)
*/

import java.util.*;

public class MaxKSubarraySum{
	public static int maxSubArray(int[] nums, int k){
		if(nums == null || nums.length < k || k == 0)
			return 0;
		int[][] local = new int[nums.length][k+1];
		int[][] global = new int[nums.length][k+1];
		for(int i = 0; i<nums.length; i++){
			local[i][0] = 0;
			global[i][0] = 0;
		}
		for(int i = 0; i<=k; i++){
			if(i == 1){
				local[0][i] = nums[0];
				global[0][i] = nums[0];
			}else{
				local[0][i] = 0;
				global[0][i] = 0;
			}
		}
		for(int i = 1; i <= k; i++){
			for(int j = 1; j < nums.length; j++){
				if(j<i-1){
					local[j][i] = 0;
					global[j][i] = 0;
				}else if(j == i-1){
					local[j][i] = local[j-1][i-1]+nums[j];
					global[j][i] = local[j][i];
				}else{
					local[j][i] = Math.max(local[j-1][i]+nums[j],global[j-1][i-1]+nums[j]);
					global[j][i] = Math.max(local[j][i],global[j-1][i]);
				}
			}
		}
		return global[nums.length-1][k];
	}
	public static void main(String[] args) {
		//int[] nums = {-1,4,-2,3,-2,3};
		int[] nums = {-1,-2,-3,-100,-1,-50};
		int k = 2;
		System.out.format("The array is %s.\nThe max %d-subarray sum is %d.\n",Arrays.toString(nums),k,maxSubArray(nums,k));
	}
}