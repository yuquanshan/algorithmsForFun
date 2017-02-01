/**
* Given an m x n matrix of non-negative integers representing the height of each unit cell in a
*continent, the "Pacific ocean"; touches the left and top edges of the matrix and the "Atlantic ocean"
* touches the right and bottom edges.
* Water can only flow in four directions (up, down, left, or right) from a cell to another one with height
* equal or lower.
*
* Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
*
* Note:
* 1. The order of returned grid coordinates does not matter.
* 2. Both m and n are less than 150.
*
* Example:
* Given the following 5x5 matrix:
*	Pacific ~ ~ ~ ~ ~
*	~ 1 2 2 3 (5) *
*	~ 3 2 3 (4) (4) *
*	~ 2 4 (5) 3 1 *
*	~ (6) (7) 1 4 5 *
*	~ (5) 1 1 2 4 *
*	* * * * * Atlantic
* Return:
* [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses
* in above matrix).
*/
import java.util.*;

public class PacificOcean{
	public static List<List<Integer>> flowBoth(int[][] matrix){
		HashSet<Integer> pacific = new HashSet<Integer>();	// grids that can flow to pacific ocean
		Queue<Integer> queue = new LinkedList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i<matrix[0].length; i++){
			queue.add(i); pacific.add(i);
		}
		for(int i = 1; i<matrix.length; i++){
			queue.add(i*150); pacific.add(i*150);
		}
		bfsFlow(queue, pacific, matrix);
		HashSet<Integer> atlantic = new HashSet<Integer>();
		for(int i = 0; i < matrix[0].length; i++){
			queue.add((matrix.length-1)*150+i); atlantic.add((matrix.length-1)*150+i);
		}
		for(int i = 0; i < matrix.length-1; i++){
			queue.add(i*150+matrix[0].length-1); atlantic.add(i*150+matrix[0].length-1);
		}
		bfsFlow(queue, atlantic, matrix);
		for(int i: pacific){
			if(atlantic.contains(i)){
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i/150); tmp.add(i%150);
				res.add(tmp);
			}
		}
		return res;
	}
	private static void bfsFlow(Queue<Integer> queue, Set<Integer> ocean, int[][] matrix){
		while(!queue.isEmpty()){
			int pos = queue.poll();
			int x = pos/150;
			int y = pos%150;
			if(x > 0 && !ocean.contains((x-1)*150+y) && matrix[x-1][y]>=matrix[x][y]){
				queue.add((x-1)*150+y); ocean.add((x-1)*150+y);
			}
			if(x < matrix.length-1 && !ocean.contains((x+1)*150+y) && matrix[x+1][y] >= matrix[x][y]){
				queue.add((x+1)*150+y); ocean.add((x+1)*150+y);
			}
			if(y > 0 && !ocean.contains(x*150+y-1) && matrix[x][y-1] >= matrix[x][y]){
				queue.add(x*150+y-1); ocean.add(x*150+y-1);
			}
			if(y < matrix[0].length-1 && !ocean.contains(x*150+y+1) && matrix[x][y+1] >= matrix[x][y]){
				queue.add(x*150+y+1); ocean.add(x*150+y+1);
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		List<List<Integer>> res = flowBoth(matrix);
		System.out.println(res.toString());
	}
}