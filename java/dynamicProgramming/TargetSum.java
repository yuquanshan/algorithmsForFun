/** You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
* Now you have 2 symbols + and -. For each integer, you should choose one from + 
* and - as its new symbol.
*
* Find out how many ways to assign symbols to make sum of integers equal to target S.
*
* Example 1:
* Input: nums is [1, 1, 1, 1, 1], S is 3. 
* Output: 5
* Explanation: 
*
* -1+1+1+1+1 = 3
* +1-1+1+1+1 = 3
* +1+1-1+1+1 = 3
* +1+1+1-1+1 = 3
* +1+1+1+1-1 = 3
*
* There are 5 ways to assign symbols to make the sum of nums be target 3.
* Note:
* The length of the given array is positive and will not exceed 20.
* The sum of elements in the given array will not exceed 1000.
* Your output answer is guaranteed to be fitted in a 32-bit integer.
* public static int findTargetSumWays(int[] nums, int S)
* (there is an another DP solution, which beats the dfs solution)
*/

public class TargetSum{
	public static int findTargetSumWays(int[] nums, int S){
		if(nums == null || nums.length == 0)
			return 0;
		return dfs(nums, 0, 0, S);
	}
	private static int dfs(int[] nums, int i, int acc, int S){
		if(i == nums.length){
			if(S == acc)
				return 1;
			else
				return 0;
		}else
			return dfs(nums, i+1, acc+nums[i], S) + dfs(nums, i+1, acc-nums[i], S);
	}
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1};
		int S = 3;
		System.out.println(findTargetSumWays(nums, S));
	}
}