/**
* given a string find its *continuous* substring with at most k distinct 
* characters, for example, given s = "eceba" and k = 2, return 3, because 
* of "ece".
* public static int lengthOfLongestSubstringKDistinct(String s, int k)
*/
import java.util.*;

public class LongestSubstringWithKDistinctChars{
	public static int lengthOfLongestSubstringKDistinct(String s, int k){
		if(k >= s.length())
			return s.length();
		if(k == 0)
			return 0;
		int[][] matrix = new int[k+1][s.length()];	// length of i->, given current k
		int[][] maxDiv = new int[k+1][s.length()]; 	// max diversity so far, given current k
		for(int i = 0; i<matrix[0].length; i++){
			matrix[1][i] = 1;
			maxDiv[1][i] = 1;
		}
		for(int i = 0; i<matrix.length; i++){
			matrix[i][s.length()-1] = 1;
			maxDiv[i][s.length()-1] = 1;
		}
		int maxSoFar = 0;
		for(int i = 2; i<=k; i++){
			for(int j = s.length()-2; j>=0; j--){
				boolean exists = false;
				for(int n = j+1; n<=j+matrix[i][j+1];n++){
					if(s.charAt(n) == s.charAt(j)){
						exists = true;
						break;
					}
				}
				if(exists){
					matrix[i][j] = matrix[i][j+1]+1;
					maxDiv[i][j] = maxDiv[i][j+1];
				}else{
					if(maxDiv[i][j+1] < k){
						matrix[i][j] = matrix[i][j+1]+1;
						maxDiv[i][j] = maxDiv[i][j+1]+1;
					}else{
						maxDiv[i][j] = k;
						matrix[i][j] = matrix[i-1][j+1]+1;
					}
				}
				maxSoFar = Math.max(matrix[i][j],maxSoFar);
			}
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		String s = "eceba";
		int k = 2;
		System.out.println(lengthOfLongestSubstringKDistinct(s,k));
	}
}