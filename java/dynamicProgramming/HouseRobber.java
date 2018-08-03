/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint 
 * stopping you from robbing each of them is that adjacent houses have 
 * security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money 
 * of each house, determine the maximum amount of money you can rob tonight 
 * without alerting the police.
 *
 * public int rob(int[] nums)
 */
import java.util.*;

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int[] rob = new int[nums.length];	// from house null to house i, 
											// if i rob house i, the max 
											// money i can get so far
		int[] nrob = new int[nums.length]; 	// ... if i don't rob house i, 
											//the max money i can get
		rob[0] = nums[0];
		nrob[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			rob[i] = nums[i] + nrob[i - 1];
			nrob[i] = Math.max(rob[i - 1], nrob[i - 1]);
		}
		return Math.max(nrob[nums.length - 1], rob[nums.length - 1]);
	}
	public static void main(String[] args) {
		int[] nums = {1, 3, 1};
		HouseRobber test = new HouseRobber();
		System.out.println(test.rob(nums));
	}
}