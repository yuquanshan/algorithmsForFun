/**
* given a triangle, e.g.,
* [
*		[2],
*	   [3,4],
*	  [6,5,7],
*	 [4,1,8,3]
* ]
* find min distance path from top to bottom. one can move from one node to its adjacent nodes.
* public int minPath(int[][] triangle)
*/
import java.util.*;

public class TriangleMinPathSum{
	public static int minPath(int[][] triangle){
		if(triangle.length == 0)
			return 0;
		for(int i=triangle.length-2; i>=0; i--){
			for(int j=0; j<triangle[i].length; j++){
				triangle[i][j] = Math.min(triangle[i][j]+triangle[i+1][j],triangle[i][j]+triangle[i+1][j+1]);
			}
		}
		return triangle[0][0];
	}
	public static void main(String[] args) {
		int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
		System.out.println("The triangle is:");
		for(int i=0; i<triangle.length; i++)
			System.out.println(Arrays.toString(triangle[i]));
		System.out.format("The min path from top to bottom is %d\n",minPath(triangle));
	}
}