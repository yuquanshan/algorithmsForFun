/**
 * Given an array of integers and an integer k, find out whether there are 
 * two distinct indices i and j in the array such that nums[i] = nums[j] and 
 * the absolute difference between i and j is at most k.
 *
 * public boolean containsNearbyDuplicate(int[] nums, int k)
 */
import java.util.*;

public class ContainsNearbyDuplicate {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (k <= 0) return false;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) return true; 
			if (set.size() == k) {
				set.remove(nums[i-k]);
				set.add(nums[i]);
			} else {
				set.add(nums[i]);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 1};
		ContainsNearbyDuplicate test = new ContainsNearbyDuplicate();
		System.out.println(test.containsNearbyDuplicate(nums, 1));
	}
}