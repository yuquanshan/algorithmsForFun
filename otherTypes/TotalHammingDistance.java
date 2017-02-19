/** The Hamming distance between two integers is the number 
* of positions at which the corresponding bits are different.
*
* Now your job is to find the total Hamming distance between 
* all pairs of the given numbers.
*
* Example:
* Input: 4, 14, 2
* Output: 6
* Explanation: In binary representation, the 4 is 0100, 14 is 
* 1110, and 2 is 0010 (just showing the four bits relevant in 
* this case). So the answer will be:
* HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
*
* public int totalHammingDistance(int[] nums)
*/

public class TotalHammingDistance {
	public static int totalHammingDistance(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int[] zeros = new int[32];
		int[] ones = new int[32];
		for(int i: nums) {
			int tmp = i;
			for(int j = 0; j < 32; j++) {
				if(tmp % 2 == 1)
					ones[j]++;
				else
					zeros[j]++;
				tmp = tmp >> 1;
			}
		}
		int res = 0;
		for(int i = 0; i < 32; i++) res += zeros[i] * ones[i];
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {4, 14, 2};
		System.out.println(totalHammingDistance(nums));
	}
}