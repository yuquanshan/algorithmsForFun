/** Given an array of n positive integers and a positive integer s, find the minimal length 
* of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
*
* For example, given the array [2,3,1,2,4,3] and s = 7,
* the subarray [4,3] has the minimal length under the problem constraint.
*
* More practice:
* If you have figured out the O(n) solution, try coding another solution of which the time 
* complexity is O(n log n).
*
* public int minSubArrayLen(int s, int[] nums)
*/
import java.util.*;

public class MinSizeSubarraySum {
    public static int minSubArrayLen1(int s, int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        int[] acc = new int[nums.length + 1];
        int pt = 0;	// start of candidate subarray
        int shortest = nums.length + 1;
        for(int i = 1; i <= nums.length; i++){
        	acc[i] = nums[i - 1] + acc[i - 1];
        	boolean flag = false;
        	while(acc[i] - acc[pt] >= s){
        		flag = true;
        		pt++;
        	}
        	if(flag) pt--;
        	if(acc[i] >= s)
        		shortest = Math.min(i - pt, shortest);
        }
        if(shortest == nums.length + 1)
        	return 0;
        return shortest;
    }
    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5};
    	int s = 15;
    	System.out.println(minSubArrayLen1(s, nums));
    }
}