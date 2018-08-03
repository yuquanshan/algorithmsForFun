/** 
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 *
 * public int singleNumber(int[] nums)
 */

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i: nums) res ^= i;
		return res;
	}
	public static void main(String[] args) {
		int[] array = {2,7,5,5,1,1,2};
		SingleNumber test = new SingleNumber();
		System.out.println(test.singleNumber(array));
	}
}