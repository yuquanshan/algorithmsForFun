/** Given a list of non-negative numbers and a target integer k, 
* write a function to check if the array has a continuous subarray 
* of size at least 2 that sums up to the multiple of k, that is, 
* sums up to n*k where n is also an integer.
*
* Example 1:
* Input: [23, 2, 4, 6, 7],  k=6
* Output: True
* Explanation: Because [2, 4] is a continuous subarray of size 2 
* and sums up to 6.
*
* Example 2:
* Input: [23, 2, 6, 4, 7],  k=6
* Output: True
* Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray 
* of size 5 and sums up to 42.
* 
* Note:
* The length of the array won't exceed 10,000.
* You may assume the sum of all the numbers is in the range of a 
* signed 32-bit integer.
* 
* public boolean checkSubarraySum(int[] nums, int k)
* 
*/
import java.util.*;

public class SubarraySumToMultiplicationOfTarget {
	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums == null || nums.length <= 1) return false;
		k = k>-k?k:-k;
 		int tmp = 0;
		if(k == 0) {
			for(int i = 0; i < nums.length - 1; i++)
				if(nums[i] == 0 && nums[i + 1] == 0) return true;
		}else {
		    Map<Integer, Integer> record = new HashMap<Integer, Integer>();	// record the frist position where accumulatedd sum % k == key
			record.put(0, -1);
			for(int i = 0; i < nums.length; i++) {
				tmp += nums[i];
				int rem = tmp%k;
				if(i < nums.length - 1 && nums[i] == 0 && nums[i + 1] == 0) return true;
				if(record.containsKey(rem)) {
				    if(i - record.get(rem) >= 2) return true;
				}else {
				    record.put(rem, i);
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] nums = {1, 0, 0};
		int k = 0;
		SubarraySumToMultiplicationOfTarget test = new SubarraySumToMultiplicationOfTarget();
		System.out.println(test.checkSubarraySum(nums, k));
	}
}