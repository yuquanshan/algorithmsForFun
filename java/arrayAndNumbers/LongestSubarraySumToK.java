/** Given an array nums and a target value k, find the maximum length 
* of a subarray that sums to k. If there isn't one, return 0 instead.
*
* Note:
* The sum of the entire nums array is guaranteed to fit within the 
* 32-bit signed integer range.
*
* Example 1:
* Given nums = [1, -1, 5, -2, 3], k = 3,
* return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
* 
* Example 2:
* Given nums = [-2, -1, 2, 1], k = 1,
* return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
*
* public int maxSubArrayLen(int[] nums, int k)
*/
import java.util.*;

public class LongestSubarraySumToK{
	public static int maxSubArrayLen(int[] nums, int k){
		if(nums == null || nums.length == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();	// record the lowest index that sum to a certain number
		int acc = 0;
		int longestSoFar = 0;
		map.put(0,-1);
		for(int i = 0; i < nums.length; i++){
			acc += nums[i];
			if(!map.containsKey(acc))
				map.put(acc, i);
			if(map.containsKey(acc - k)){
				int tmpLen = i - map.get(acc - k);
				longestSoFar = Math.max(tmpLen, longestSoFar);
			}
		}
		return longestSoFar;
	}
	public static void main(String[] args) {
		int[] nums = {-2, -1, 2, 1};
		int k = 1;
		System.out.println(maxSubArrayLen(nums, k));
	}
}