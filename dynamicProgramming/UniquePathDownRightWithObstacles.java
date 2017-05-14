/**
* given a m*n grid and an obstacle matrix, which depicts the position of obstacles,
* return the number of unique paths from top left to bottom right.
* a grid with only one obstacle in the center can be described in the following obstacle matrix
* [
* 	[0,0,0],
* 	[0,1,0],
* 	[0,0,0]
* ]
* public int uniquePath(int[][] obstacleGrid)
*/
import java.util.*;
public class UniquePathDownRightWithObstacles{
	public static int uniquePath(int[][] obstacleGrid){
		int m = obstacleGrid.length;
		if(m == 0)
			return 0;
		int n = obstacleGrid[0].length;
		if(n == 0)
			return 0;
		if(obstacleGrid[m-1][n-1]!=1)
            obstacleGrid[m-1][n-1] = 1;
        else
            return 0;	// the destination is blocked...
		for(int i=n-2; i>=0; i--){
			if(obstacleGrid[m-1][i] != 1){
				obstacleGrid[m-1][i] = obstacleGrid[m-1][i+1];
			}else{
				obstacleGrid[m-1][i] = 0;
			}
		}
		for(int i=m-2; i>=0; i--){
			for(int j=n-1; j>=0; j--){
				if(obstacleGrid[i][j] != 1){
					if(j==n-1){
						obstacleGrid[i][j] = obstacleGrid[i+1][j];
					}else{
						obstacleGrid[i][j] = obstacleGrid[i+1][j]+obstacleGrid[i][j+1];
					}
				}else{
					obstacleGrid[i][j] = 0;
				}
			}
		}
		return obstacleGrid[0][0];
	}
	public static void main(String[] args) {
		int[][] obs = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println("The obstacle matrix is: ");
		for(int i=0; i<obs.length; i++)
			System.out.println(Arrays.toString(obs[i]));
		System.out.format("The number of unique paths is %d.\n", uniquePath(obs));
	}
}