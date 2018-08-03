/** Given a set of distinct positive integers, find the largest 
* subset such that every pair (Si, Sj) of elements in this subset 
* satisfies: Si % Sj = 0 or Sj % Si = 0.
*
* If there are multiple solutions, return any subset is fine.
* 
* Example 1:
* nums: [1,2,3]
* Result: [1,2] (of course, [1,3] will also be ok)
*
* Example 2:
* nums: [1,2,4,8]
* Result: [1,2,4,8]
*
* public List<Integer> largestDivisibleSubset(int[] nums)
*/
import java.util.*;

public class LargestDivisibleSubset{
	public static List<Integer> largestDivisibleSubset(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums); 	
		int[] len = new int[nums.length];
		int[] map = new int[nums.length];
		int longest = 0;
		int best = -1;
		for(int i = nums.length-1; i>=0; i--){
			len[i] = 1;
			for(int j = i+1; j<nums.length; j++){
				if(nums[j]%nums[i] == 0 && 1+len[j]>len[i]){
					len[i] = 1+len[j];
					map[i] = j;
				}
			}
			if(len[i]>longest){
				longest = len[i];
				best = i;
			}
		}
		res.add(nums[best]);
		while(map[best] != 0){
			best = map[best];
			res.add(nums[best]);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] array = {1,2,3};
		System.out.println(largestDivisibleSubset(array).toString());
	}
}