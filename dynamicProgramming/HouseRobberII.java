/** 
 * Reconsider the HouseRobber problem such that now the houses are 
 * arranged in a circle. Return the max money the robber can get without
 * alerting the police.
 *
 * public int rob(int[] nums)
 */

public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int[] rob = new int[nums.length];
		int[] nrob = new int[nums.length];
		int res = nums[0];
		rob[0] = nums[0];
		nrob[0] = 0;
		if (nums.length > 1) {
			// break the circle by removing the last house
			for (int i = 1; i < nums.length - 1; i++) {	
				rob[i] = nums[i] + nrob[i - 1];
				nrob[i] = Math.max(nrob[i - 1], rob[i - 1]);
			}
			res = Math.max(rob[nums.length - 2], nrob[nums.length - 2]);
			// break the circle by removing the first house
			rob[1] = nums[1];
			nrob[1] = 0;
			for (int i = 2; i < nums.length; i++) {	
				rob[i] = nums[i] + nrob[i - 1];
				nrob[i] = Math.max(nrob[i - 1], rob[i - 1]);
			}
			res = Math.max(res, Math.max(rob[nums.length - 1], 
				nrob[nums.length - 1]));
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {8, 1, 6, 7};
		HouseRobberII test = new HouseRobberII();
		System.out.println(test.rob(nums));
	}
}