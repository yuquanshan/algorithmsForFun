/** Find the length of the longest substring T of a given string 
* (consists of lowercase letters only) such that every character 
* in T appears no less than k times.
*
* Example 1:
* Input:
* s = "aaabb", k = 3
* Output:
* 3
* The longest substring is "aaa", as 'a' is repeated 3 times.
*
* Example 2:
* Input:
* s = "ababbc", k = 2
* Output:
* 5
* The longest substring is "ababb", as 'a' is repeated 2 times and 
* 'b' is repeated 3 times.
* public int longestSubstring(String s, int k)
* (have no idea what to do in my first try)
*/
import java.util.*;

public class LongestSubstringWithKRepeat{
	public static int longestSubstring(String s, int k){
		int[][] acc = new int[26][s.length()+1];
		for(int i = 1; i <= s.length(); i++){
			for(int j = 0; j < 26; j++){
				if(j == s.charAt(i-1)-'a')
					acc[j][i] = acc[j][i-1] + 1;
				else
					acc[j][i] = acc[j][i-1];
			}
		}
		return dfs(acc, 0, s.length(), k);
	}
	private static int dfs(int[][] acc, int start, int end, int k){
		int res = 0;
		if(end - start < k)
			return res;
		boolean clean = true;
		for(int i = 0; i < 26; i++){
			if(acc[i][end] - acc[i][start] < k && acc[i][end] - acc[i][start] > 0){
				clean = false;
				int tmp = start;
				for(int j = start; j <= end; j++){
					if(acc[i][j] > acc[i][tmp+1]){
						int r = dfs(acc, tmp, j-1, k);
						res = (r > res)?r:res;
						tmp = j-1;
					}
				}
			}
		}
		if(clean)
			return end - start;
		return res;
	}
	public static void main(String[] args) {
		String str = "ababbc";
		int k = 2;
		System.out.println(longestSubstring(str, k));
	}
}