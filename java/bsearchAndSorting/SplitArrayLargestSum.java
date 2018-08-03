/** Given an array which consists of non-negative integers and an 
* integer m, you can split the array into m non-empty continuous 
* subarrays. Write an algorithm to minimize the largest sum among 
* these m subarrays.
*
* Note:
* If n is the length of array, assume the following constraints 
* are satisfied:
*
* 1 ≤ n ≤ 1000
* 1 ≤ m ≤ min(50, n)
* Examples:
*
* Input:
* nums = [7,2,5,10,8]
* m = 2
* Output:
* 18
*
* Explanation:
* There are four ways to split nums into two subarrays.
* The best way is to split it into [7,2,5] and [10,8],
* where the largest sum among the two subarrays is only 18.
*
* public int splitArray(int[] nums, int m)
*/

import java.util.*;

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
		if(nums == null || nums.length == 0 || m == 0) return 0;
		int end = 0;
		int start = 0;
		for(int i: nums) {
			end += i;
			start = i > start?i:start;
		}
		while(end - start > 1) {
			int mid = start + (end - start)/2;
			if(valid(nums, m, mid)) end = mid;
			else start = mid + 1;
		}
		if(valid(nums, m, start)) return start;
		return end;
	}
	private boolean valid(int[] nums, int m, int s) {	// if have no more than m groups whose sum is leq s
		int count = 0;
		int i = 0;
		int tmp = 0;
		while(count < m && i < nums.length) {
			tmp += nums[i];
			if(tmp > s) {
				tmp = 0;
				count++;
			}else {
				i++;
			}
		}
		if(count == m) return false;
		return true;
	}
	public static void main(String[] args) {
		SplitArrayLargestSum test = new SplitArrayLargestSum();
		int[] nums = {7,2,5,10,8};
		int m = 2;
		System.out.println(test.splitArray(nums, m));
	}
}