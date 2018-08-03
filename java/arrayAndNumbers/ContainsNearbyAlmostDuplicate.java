/** 
 * Given an array of integers, find out whether there are two distinct 
 * indices i and j in the array such that the absolute difference between 
 * nums[i] and nums[j] is at most t and the absolute difference between i 
 * and j is at most k.
 *
 * public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
 */

public class ContainsNearbyAlmostDuplicate {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k <= 0 || nums == null || nums.length <= 1) return false;
		long[] sorted = new long[k];
		int len = 1;
		sorted[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int pos = find(sorted, len, nums[i]);
			if (Math.abs(sorted[pos] - nums[i]) <= t) return true;
			if (len < k) {
				sorted[len++] = nums[i];
				rearrange(sorted, len - 1, len);
			} else {
				pos = find(sorted, len, nums[i - k]);
				sorted[pos] = nums[i];
				rearrange(sorted, pos, len);
			}
		} 
		return false;
	}
	private void rearrange(long[] nums, int pos, int len) {
		if (pos == 0 || pos < len - 1 && nums[pos] > nums[pos + 1]) {
			while (pos < len - 1 && nums[pos] > nums[pos + 1]) {
				long tmp = nums[pos];
				nums[pos] = nums[pos + 1];
				nums[pos + 1] = tmp;
			}
		} else {
			while (pos > 0 && nums[pos] < nums[pos - 1]) {
				long tmp = nums[pos];
				nums[pos] = nums[pos - 1];
				nums[pos - 1] = tmp;
			}
		}
	}
	private int find(long[] nums, int len, int target) {
		int start = 0;
		int end = len -1;
		while(end - start > 1) {
			int mid = start + (end - start)/2;
			if (nums[mid] == target) return mid;
			if (nums[mid] > target) end = mid;
			else start = mid;
		}
		if (Math.abs(target - nums[start]) < Math.abs(target - nums[end]))
			return start;
		return end;
	}
	public static void main(String[] args) {
		int[] nums = {-1,2147483647};
		ContainsNearbyAlmostDuplicate test = new ContainsNearbyAlmostDuplicate();
		System.out.println(test.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
	}
}