/**
given two strings S and T, return the number of 
distinct subsequences of T in S. 
*/
import java.util.*;

public class NumberOfDistinctSubsequences{
	public static int distinctSub(String S, String T){
		if(S == null || S.length() == 0)
			return 0;
		if(T == null || T.length() == 0)
			return 0;
		int lenS = S.length();
		int lenT = T.length();
		int[][] table = new int[lenS+1][lenT+1];
		for(int i = 0; i<=lenS; i++){
			table[i][0] = 1;
		}
		for(int i = 1; i<=lenT; i++){
			table[0][i] = 0;
		}
		for(int i = 1; i<=lenS; i++){
			for(int j = 1; j<=Math.min(lenT,i); j++){
				if(S.charAt(i-1)==T.charAt(j-1)){
					table[i][j] = table[i-1][j]+table[i-1][j-1];	// last element is enough to make a (possible) distinct subsequence 		
				}else{
					table[i][j] = table[i-1][j];	// delete last element of S, continue searching
				}
			}
		}
		return table[lenS][lenT];
	}
	public static void main(String[] args) {
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(distinctSub(S,T)+" subsequences of "+T+" in "+S+".");
	}
}