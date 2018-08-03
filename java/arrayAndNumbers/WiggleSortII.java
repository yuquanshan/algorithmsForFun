/** Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
*
* Example:
* (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
* (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
*
* Note:
* You may assume all input has valid answer.
* 
* Follow Up:
* Can you do it in O(n) time and/or in-place with O(1) extra space?
* public void wiggleSort(int[] nums)
* (a nice way to implement O(n) time and O(1) space, which is hard to come up with)
*/
import java.util.*;

public class WiggleSortII{
	public static void wiggleSort(int[] nums){
		// explanation see https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java
		// basically, we want to put the number smaller than median to the last even positions, and put 
		// the number larger than median to the first odd positions, as a result, we put median in the latter odd positions
		// and put median in the beginning even positions, thus put them as far away as possible.
		// if you want to do it in O(n) time O(1) space, try to use virtual index + three way partition
		int n = nums.length;
		int i = 0; 
		int left = 0; // mapped to first unused odd position so far 
		int right = nums.length-1;	// mapped to last unused even position so far 
		int mid = findKth(nums, (1+nums.length)/2, 0, nums.length-1);
		int[] res = new int[n];
		for(int i = 0; i<nums.length; i++){	// first exame
			if(nums[i] < mid){
				res[getMap(right--,n)] = nums[i];
			}else if(nums[i] > mid){
				res[getMap(left++,n)] = nums[i];
			}
		} 
		for(int i = left; i <= right; i++)
			res[getMap(right--, n)] = mid;
		nums = res;
	}
	private static int findKth(int[] nums, int k, int start, int end){
		int num = nums[end];
		int p = start-1;
		for(int i=start; i<end; i++){
			if(nums[i]<num){
				int tmp = nums[++p];
				nums[p] = nums[i];
				nums[i] = tmp;
			}
		}
		nums[end] = nums[p+1];
		nums[p+1] = num;
		if(p-start+2 == k)
			return nums[p+1];
		else if(p-start+2 < k)
			return findKth(nums, k-p-2+start, p+2, end);
		else
			return findKth(nums, k, start, p);
	}
	private static int getMap(int i, int n){
		return (1+2*i)%(n|1);
	}
	public static void main(String[] args) {
		 int[] nums = {6,13,5,4,5,2};
		 wiggleSort(nums);
		 System.out.println(nums);
	}
}