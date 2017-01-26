/**
* given a string, find the length of its longest palindrome subsequence.
* for example, given "abaca", return 3, because "aaa" is a subsequence 
* which is palindrome.
* public int longestPalindromeSubseq(String s)
*/
import java.util.*;

public class LongestPalindromeSubsequence{
	public static int longestPalindromeSubseq(String s){
		if(s == null || s.length() == 0)
			return 0;
		if(s.length() == 1)
			return 1;
		int[][] oddMatrix = new int[s.length()+2][s.length()+2];	// record length for even palindrome for <-i, j->
		int[][] evenMatrix = new int[s.length()+2][s.length()+2];	// record length for odd palindrome for <-i, j->
		int longestSoFar = 1;
		for(int i = 0; i < s.length(); i++){
			for(int j = s.length()-1; j > i; j--){
				oddMatrix[i+1][j+1] = 1 + Math.max(evenMatrix[i][j+1], evenMatrix[i+1][j+2]);
				if(s.charAt(i) == s.charAt(j))
					evenMatrix[i+1][j+1] = 2 + evenMatrix[i][j+2];
				else
					evenMatrix[i+1][j+1] = Math.max(evenMatrix[i][j+1], evenMatrix[i+1][j+2]);
				longestSoFar = Math.max(longestSoFar, Math.max(oddMatrix[i+1][j+1], evenMatrix[i+1][j+1]));	 
			}	
		}
		return longestSoFar;
	}
	public static void main(String[] args) {
		String s = "abaca";
		System.out.println(longestPalindromeSubseq(s));
	}
}