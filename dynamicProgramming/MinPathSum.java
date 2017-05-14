/**
* given a m*n grid with non-negative numbers, find a path from top left to 
* bottom right which collects as less sum of numbers as possible. 
* can only move down or right.
* public int minPathSum(int[][] grid)
*/
import java.util.*;

public class MinPathSum{
	public static int minPathSum(int[][] grid){
		if(grid.length == 0)
			return 0;
		if(grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		for(int i = n-2; i>=0; i--){
			grid[m-1][i] = grid[m-1][i] + grid[m-1][i+1];
		}
		for(int i = m-2; i>=0; i--){
			grid[i][n-1] = grid[i][n-1]+grid[i+1][n-1];
			for(int j = n-2; j>=0; j--){
				grid[i][j] = Math.min(grid[i][j]+grid[i+1][j],grid[i][j]+grid[i][j+1]);
			}
		}
		return grid[0][0];
	}
	public static void main(String[] args) {
		int[][] grid = {{0,2},{1,0}};
		System.out.println("The grid is:");
		for(int i=0; i<grid.length; i++)
			System.out.println(Arrays.toString(grid[i]));
		System.out.format("The minimum path sum is %d.\n",minPathSum(grid));
	}
}