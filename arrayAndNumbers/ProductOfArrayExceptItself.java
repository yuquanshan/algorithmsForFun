/** Given an array of n integers where n > 1, nums, return 
* an array output such that output[i] is equal to the 
* product of all the elements of nums except nums[i].
*
* Solve it without division and in O(n).
*
* For example, given [1,2,3,4], return [24,12,8,6].
*
* Follow up:
* Could you solve it with constant space complexity? 
* (Note: The output array does not count as extra space 
* for the purpose of space complexity analysis.)
*
* public int[] productExceptSelf(int[] nums)
*/
import java.util.*;

public class ProductOfArrayExceptItself{
	public static int[] productExceptSelf(int[] nums){
		if(nums == null || nums.length == 0)
			return nums;
		if(nums.length == 1)
			return new int[]{0};
		int[] res = new int[nums.length];
		int acc = 1;
		for(int i = 0; i < nums.length; i++) {
			res[i] = acc;
			acc *= nums[i];
		}
		acc = 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			res[i] = res[i] * acc;
			acc *= nums[i];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}
}