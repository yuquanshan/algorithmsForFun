/**
given a m*n grid, return the number of unique paths from top left to bottom right.
*/

public class UniquePathDownRight{
	public static int uniquePath(int m, int n){
		if(m==0 || n==0)
			return 0;
		int[][] matrix = new int[m][n];	// actually can use an array which is more space efficient
		for(int i = 0; i<n; i++)	// initialize
			matrix[m-1][i] = 1;
		for(int i = m-2; i>=0; i--){
			for(int j = n-1; j>=0; j--){
				if(j == n-1){
					matrix[i][j] = matrix[i+1][j];
				}else{
					matrix[i][j] = matrix[i+1][j]+matrix[i][j+1];
				}
			}
		}
		return matrix[0][0];
	}
	public static void main(String[] args) {
		int m = 2;
		int n = 2;
		System.out.format("The number of unique paths for %d * %d is %d.\n",n,m,uniquePath(m,n));
	}
}