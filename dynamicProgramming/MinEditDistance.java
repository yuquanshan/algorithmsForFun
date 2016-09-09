/**
given two strings, find the minimum number of operations to convert 
one string to another, assume there are three types of operations:
	insert a character
	delete a character
	replace a character
*/

public class MinEditDistance{
	public static int minDistance(String word1, String word2){
		if(word1 == null || word1.length() == 0)
			return word2.length();
		if(word2 == null || word2.length() == 0)
			return word1.length();
		int m = word1.length();
		int n= word2.length();
		int[][] table = new int[m+1][n+1];	// table[i][j] means word1[1:i] vs word2[1:j]
		// let's convert word2 to word1
		for(int i = 0; i<=m; i++){
			table[i][0] = i;
		}
		for(int i = 0; i<=n; i++){
			table[0][i] = i;
		}
		for(int i = 1; i<=m; i++){
			for(int j = 1; j<=n; j++){
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					table[i][j] = table[i-1][j-1];	// last characters cancel each other
				}else{
					table[i][j] = Math.min(Math.min(table[i-1][j],table[i][j-1]),table[i-1][j-1])+1;	// insert last char of word1 to the end of word2 or delete last char of word2 or replace last char of word2 with the last char of word1  
				}
			}
		}
		return table[m][n];
	}
	public static void main(String[] args) {
		String w1 = "mart";
		String w2 = "karma";
		System.out.println("To convert "+w2+" to "+w1+", at least "+minDistance(w1,w2)+" steps are required.");
	}
}