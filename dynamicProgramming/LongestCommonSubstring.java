/**
find the length of the longest common substring (*continuous* characters) between two strings.
*/

import java.util.*;

public class LongestCommonSubstring{
	public static int lcs(String A, String B){
		if(A == null || A.length() == 0 || B == null || B.length() == 0)
			return 0;
		// table[i][j] indicates if a substring ends at A[i-1] B[j-1], longest substring possible, ofcourse, if A[i-1]!=B[j-1], table[i][j] = 0
		int[][] table = new int[A.length()+1][B.length()+1]; 
		int longestSoFar = 0;
		for(int i = 0; i<=A.length(); i++)
			table[i][0] = 0;
		for(int i = 0; i<=B.length(); i++)
			table[0][i] = 0;
		for(int i = 1; i<=A.length(); i++){
			for(int j = 1; j<=B.length(); j++){
				if(A.charAt(i-1)!=B.charAt(j-1)){
					table[i][j] = 0;
				}else{
					table[i][j] = 1+table[i-1][j-1];
					if(table[i][j]>longestSoFar)
						longestSoFar = table[i][j];
				}
			}
		}
		return longestSoFar;
	}
	public static void main(String[] args) {
		String A = "www.lintcode.com code";
		String B = "www.ninechapter.com code";
		System.out.println("The length of LCS between "+A+" and "+B+" is "+lcs(A,B)+".");
	}
	
}