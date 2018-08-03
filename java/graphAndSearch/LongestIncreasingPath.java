/* Given an integer matrix, find the length of the longest increasing path.
* From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the * boundary (i.e. wrap-around is not allowed).
* Example 1:
* nums = [
*  [9,9,4],
*  [6,6,8],
*  [2,1,1]
* ]
* Return 4
* The longest increasing path is [1, 2, 6, 9].
* Example 2:
* nums = [
*  [3,4,5],
*  [3,2,6],
*  [2,2,1]
* ]
* Return 4
* The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
* 
* public int longestIncreasingPath(int[][] matrix)
*/
import java.util.*;

public class LongestIncreasingPath{
	public static int longestIncreasingPath(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		Map<Integer,Integer> visited = new HashMap<Integer, Integer>();
		int longestSoFar = 0;
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(!visited.containsKey(i*n+j))
					longestSoFar = Math.max(longestSoFar, dfs(matrix, i, j, visited));
			}
		}
		return longestSoFar;
	}
	private static int dfs(int[][] matrix, int i, int j, Map<Integer, Integer> visited){
		int res = 1;
		int m = matrix.length;
		int n = matrix[0].length;
		if(i > 0 && matrix[i-1][j]>matrix[i][j]){
			if(visited.containsKey((i-1)*n+j))
				res = Math.max(res,1+visited.get((i-1)*n+j));
			else
				res = Math.max(res,1+dfs(matrix, i-1, j, visited));
		}
		if(i < m-1 && matrix[i+1][j]>matrix[i][j]){
			if(visited.containsKey((i+1)*n+j))
				res = Math.max(res,1+visited.get((i+1)*n+j));
			else
				res = Math.max(res, 1+dfs(matrix,i+1,j,visited));
		}
		if(j > 0 && matrix[i][j-1]>matrix[i][j]){
			if(visited.containsKey(i*n+j-1))
				res = Math.max(res,1+visited.get(i*n+j-1));
			else
				res = Math.max(res, 1+dfs(matrix,i,j-1,visited));
		}
		if(j < n-1 && matrix[i][j+1]>matrix[i][j]){
			if(visited.containsKey(i*n+j+1))
				res = Math.max(res,1+visited.get(i*n+j+1));
			else
				res = Math.max(res,1+dfs(matrix,i,j+1,visited));
		}
		visited.put(i*n+j,res);
		return res;
	}
	public static void main(String[] args) {
		//int[][] nums = {{3,4,5},{3,2,6},{2,2,1}};
		int[][] nums = {{1,2}};
		System.out.println(longestIncreasingPath(nums));
	}
}