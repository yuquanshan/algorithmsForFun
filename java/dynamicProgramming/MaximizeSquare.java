/** Given a 2D binary matrix filled with 0's and 1's, find the largest 
* square containing only 1's and return its area.
*
* For example, given the following matrix:
*
* 1 0 1 0 0
* 1 0 1 1 1
* 1 1 1 1 1
* 1 0 0 1 0
* Return 4.
*
* public int maximalSquare(char[][] matrix)
*/

public class MaximizeSquare{
	public static int maximalSquare(char[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int longest = 0;
		for(int i = 1; i <= matrix.length; i++) {
			for(int j = 1; j <= matrix[0].length; j++) {
				if(matrix[i - 1][j - 1] == '1'){
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
					longest = Math.max(longest, dp[i][j]);
				}
			}
		}
		return longest * longest;
	}
}
