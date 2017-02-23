/** Given a binary array, find the maximum length of a contiguous subarray 
* with equal number of 0 and 1.
*
* Example 1:
* Input: [0,1]
* Output: 2
* Explanation: [0, 1] is the longest contiguous subarray with equal number 
* of 0 and 1.
*
* Example 2:
* Input: [0,1,0]
* Output: 2
* Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal 
* number of 0 and 1.
* Note: The length of the given binary array will not exceed 50,000.
* 
* public int findMaxLength(int[] nums)
*/
import java.util.*;

public class LongestSubarrayWithEqualOnesAndZeros{
	public int findMaxLength(int[] nums) {
		if(nums == null || nums.length <= 1) return 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();	// the first pos that ones - zeros reaches the key
		map.put(0, -1);
		int longestSoFar = 0;
		int acc = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) acc--;
			else acc++;
			if(!map.containsKey(acc)) map.put(acc, i);
			longestSoFar = Math.max(i - map.get(acc), longestSoFar);
		}
		return longestSoFar;
	}
	public static void main(String[] args) {
		int[] nums = {0, 1, 0};
		LongestSubarrayWithEqualOnesAndZeros test = new LongestSubarrayWithEqualOnesAndZeros();
		System.out.println(test.findMaxLength(nums));
	}
}