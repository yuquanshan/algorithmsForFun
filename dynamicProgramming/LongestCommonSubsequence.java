/**
find the length of longest subsequence between two strings.
*/

import java.util.*;

public class LongestCommonSubsequence{
	public static int lcs(String A, String B){
		if(A == null || A.length()==0 || B == null || B.length() == 0)
			return 0;
		int[][] table = new int[A.length()+1][B.length()+1];
		for(int i = 0; i <= A.length(); i++)
			table[i][0] = 0;
		for(int i = 0; i<=B.length(); i++)
			table[0][i] = 0;
		for(int i = 1; i<=A.length(); i++){
			for(int j = 1; j<=B.length(); j++){
				if(A.charAt(i-1) == B.charAt(j-1)){
					table[i][j] = 1+table[i-1][j-1];
				}else{
					table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
				}
			}
		}
		return table[A.length()][B.length()];
	}
	public static void main(String[] args) {
		String A = "ABCD";
		String B = "CBCE";
		System.out.println("The length of LCS between "+A+" and "+B+" is "+lcs(A,B)+".");
	}
}