/**
 * Given an integer array of size n, find all elements that 
 * appear more than ⌊ n/3 ⌋ times. The algorithm should run 
 * in linear time and in O(1) space.
 * public List<Integer> majorityElement(int[] nums)
 * (proof see my notebook)
 */
import java.util.*;

public class MajorityElementsII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) return res;
		int[] cands = new int[2];
		int[] counters = new int[2];
		for (int i: nums) {
			boolean flag = false;
			for (int j = 0; j < 2; j++) {
				if (cands[j] == i) {
					counters[j]++;
					flag = true;
					break;
				}
			}
			if (!flag) {
				for (int j = 0; j < 2; j++) {
					if (counters[j] == 0) {
						cands[j] = i;
						counters[j] = 1;
						flag = true;
						break;
					}
				}
			}
			if (!flag) {
				counters[0]--;
				counters[1]--;
			}
		}
		counters[0] = 0;
		for (int i: nums) {
			if (i == cands[0]) counters[0]++;
		}
		if (counters[0] > nums.length/3) res.add(cands[0]);
		counters[1] = 0;
		for (int i: nums) {
			if (i == cands[1]) counters[1]++;
		} 
		if (counters[1] > nums.length/3 && cands[0] != cands[1]) 
			res.add(cands[1]);
		return res;
	}
}