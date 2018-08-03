/** Given an integer array nums, return the number of range sums that lie in 
* [lower, upper] inclusive. Range sum S(i, j) is defined as the sum of the 
* elements in nums between indices i and j (i ≤ j), inclusive.
*
* Note:
* A naive algorithm of O(n^2) is trivial. You MUST do better than that.
*
* Example:
* Given nums = [-2, 5, -1], lower = -2, upper = 2,
* Return 3.
* The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
* public int countRangeSum(int[] nums, int lower, int upper)
*/
import java.util.*;

public class CountOfRangeSum{
	public static int countRangeSum(int[] nums, int lower, int upper){
		// we get sum[i], which is the sum from 0 to i, and we want to count the pairs i < j
		// such that lower<=sum[j]-sum[i]<=upper
		// the array may change to long in case of some extreme cases, like [Integer.MAX_VALUE, Integer.MAX_VALUe...]
		int acc = 0;
		int count = 0;
		for(int i = 0; i<nums.length; i++){
			acc += nums[i];
			nums[i] = acc;
			if(nums[i] >= lower && nums[i] <= upper)
				count++;
		}
		count = count + msort(nums, 0, nums.length-1, lower, upper);
		return count;
	}
	private static int msort(int[] nums, int start, int end, int lower, int upper){
		if(start == end)
			return 0;
		int mid = start+(end-start)/2;
		int left = msort(nums, start, mid, lower, upper);
		int right = msort(nums, mid+1, end, lower, upper);
		int middle = merge(nums, start, end, lower, upper);
		return left+right+middle;
	}	
	private static int merge(int[] nums, int start, int end, int lower, int upper){
		if(start == end)
			return 0;
		int mid = start+(end-start)/2;
		int pt1 = mid+1, pt2 = mid+1;
		int count = 0;
		for(int i = start; i<=mid; i++){
			int lbound = nums[i]+lower;
			int ubound = nums[i]+upper;
			while(pt1 <= end && nums[pt1]<lbound)
				pt1++;
			while(pt2 <= end && nums[pt2]<=ubound)
				pt2++;
			//System.out.format("%d, %d, %d-%d\n",lbound, ubound, pt1,pt2);
			count += pt2-pt1;
		}
		int[] tmp = new int[end-start+1];
		int p = 0; 
		int start2 = mid+1;
		int start1 = start;
		while(p < end-start+1){
			if(start1 > mid)
				tmp[p++] = nums[start2++];
			else if(start2 > end)
				tmp[p++] = nums[start1++];
			else if(nums[start1] < nums[start2])
				tmp[p++] = nums[start1++];
			else
				tmp[p++] = nums[start2++];
		}
		for(int i = 0; i<tmp.length; i++)
			nums[start+i] = tmp[i];
		//System.out.format("%d - %d, %d\n", start, end, count);
		return count;
	}
	public static void main(String[] args) {
		int[] nums = {-2, 5, -1};
		int lower = -2, upper = 2;
		System.out.println(countRangeSum(nums, lower, upper));
	}
}