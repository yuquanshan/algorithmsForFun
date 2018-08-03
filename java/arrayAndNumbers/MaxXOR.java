/** Given a non-empty array of numbers, a0, a1, a2, … , an-1, 
* where 0 ≤ ai < 231.
*
* Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
* Could you do this in O(n) runtime?
*
* Example:
* 
* Input: [3, 10, 5, 25, 2, 8]
* Output: 28
*
* Explanation: The maximum result is 5 ^ 25 = 28.
* public static int findMaximumXOR(int[] nums)
* (failed to give an algorithm for the first time, can use trie
* or bitmask)
*/
import java.util.*;

public class MaxXOR{
	public static int findMaximumXOR(int[] nums){
		int max = 0, mask = 0;
		for(int i = 8; i>=0; i--){
			mask = mask | (1<<i);
			Set<Integer> prefixset = new HashSet<Integer>();
			for(int j: nums)
				prefixset.add(mask&j);
			int tmp = max | (1<<i);	// try to add 1 on max's bit i
			for(int j: prefixset){
				if(prefixset.contains(tmp ^ j)){	// basically means "if me provide 1, can my partner num(s) provide 0"
					max = tmp;
					break;
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] nums = {3, 10, 5, 25, 2, 8};
		System.out.println(findMaximumXOR(nums));
	}
}