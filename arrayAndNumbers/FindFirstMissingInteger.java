/** Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * public int firstMissingPositive(int[] nums)
 */

public class FindFirstMissingInteger {
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) return 1;
		int minpos = 0;
		int pt = 0;
		while (pt < nums.length) {
			if (nums[pt] <= 0 || nums[pt] > nums.length || 
				nums[pt] == nums[nums[pt] - 1] /*in case of deadloop*/) pt++;
			else {
				if (nums[pt] == pt + 1) pt++;
				else {
					int tmp = nums[pt];
					nums[pt] = nums[tmp - 1];
					nums[tmp - 1] = tmp;
				}	
			}
			while (nums[minpos] == minpos + 1) {
				minpos++;
				if (minpos == nums.length) return minpos + 1;
			}
		}
		return minpos + 1;
	}
	public static void main(String[] args) {
		FindFirstMissingInteger test = new FindFirstMissingInteger();
		int[] nums = {1,1};
		System.out.println(test.firstMissingPositive(nums));
	}
}