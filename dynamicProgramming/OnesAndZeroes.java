/** In the computer world, use restricted resource you have to generate 
* maximum benefit is what we always want to pursue.
* 
* For now, suppose you are a dominator of m 0s and n 1s respectively. 
* On the other hand, there is an array with strings consisting of only 0s and 1s.
*
* Now your task is to find the maximum number of strings that you can form with 
* given m 0s and n 1s. Each 0 and 1 can be used at most once.
*
* Note:
* The given numbers of 0s and 1s will both not exceed 100
* The size of given string array won't exceed 600.
* Example 1:
* Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
* Output: 4
* Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, 
* which are “10,”0001”,”1”,”0”
* Example 2:
* Input: Array = {"10", "0", "1"}, m = 1, n = 1
* Output: 2
* Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
*
* public int findMaxForm(String[] strs, int m, int n)
* (try to use dp to solve this problem)
*/

public class OnesAndZeroes{
	public static int findMaxForm(String[] strs, int m, int n){
		int[] ones = new int[strs.length];
		int[] zeroes = new int[strs.length];
		for(int i = 0; i<strs.length; i++){
			int o = 0, z = 0;
			for(int j = 0; j<strs[i].length(); j++){
				if(strs[i].charAt(j) == '0')
					z++;
				else
					o++;
			}
			ones[i] = o; zeroes[i] = z;
		}
		return helper(zeroes, ones, m, n, 0);
	}
	public static int helper(int[] zeroes, int[] ones, int m, int n, int pt){
		int count = 0;
		if(pt == zeroes.length)
			return count;
		if(zeroes[pt]<=m && ones[pt]<=n)
			count = Math.max(count, 1+helper(zeroes, ones, m-zeroes[pt], n-ones[pt], pt+1));
		count = Math.max(count, helper(zeroes, ones, m, n, pt+1));
		return count;
	}
	public static void main(String[] args) {
		String[] strs = {"10", "0001", "111001", "1", "0"};
		int m = 1, n = 1;
		System.out.println(findMaxForm(strs, m, n));
	}
}