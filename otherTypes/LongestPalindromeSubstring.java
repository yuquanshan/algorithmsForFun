/** Given a string s, find the longest palindromic substring in s. 
* You may assume that the maximum length of s is 1000.
*
* Example:
* Input: "babad"
* Output: "bab"
*
* Note: "aba" is also a valid answer.
* Example:
*
* Input: "cbbd"
* Output: "bb"
* public String longestPalindrome(String s)
*/
import java.util.*;

public class LongestPalindromeSubstring{
	public static String longestPalindrome(String s){
		if(s == null || s.length() == 0)
			return s;
		if(s.length() == 1)
			return s;
		int[] max = new int[3];
		for(int i = 0; i < s.length(); i++){
			int[] tmp = expandToPalindrome(s, i, i);
			if(tmp[2] > max[2])
				max = tmp;
			if(i > 0 && s.charAt(i) == s.charAt(i-1)){
				tmp = expandToPalindrome(s, i-1, i);
				if(tmp[2] > max[2])
					max = tmp;
			}
			if(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
				tmp = expandToPalindrome(s, i, i+1);
				if(tmp[2] > max[2])
					max = tmp;
			}
		}
		return s.substring(max[0],max[1]+1);
	}
	private static int[] expandToPalindrome(String s, int start, int end){
		int[] res = new int[3];
		if(start <= 0 || end >= s.length()-1){
			res[0] = start; res[1] = end; res[2] = end - start + 1;
			return res;
		}
		if(s.charAt(start-1) == s.charAt(end+1))
			return expandToPalindrome(s, start-1, end+1);
		else{
			res[0] = start; res[1] = end; res[2] = end - start + 1;
			return res;
		}
	}
	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}
}