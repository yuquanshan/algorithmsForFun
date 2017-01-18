/** Given a matrix of m x n elements (m rows, n columns), 
* return all elements of the matrix in spiral order.
*
* For example,
* Given the following matrix:
*
* [
*  [ 1, 2, 3 ],
*  [ 4, 5, 6 ],
*  [ 7, 8, 9 ]
* ]
* You should return [1,2,3,6,9,8,7,4,5].
* public List<Integer> spiralOrder(int[][] matrix)
*/
import java.util.*;

public class SpiralMatrix{
	public static List<Integer> spiralOrder(int[][] matrix){
		List<Integer> res = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return res;
		int state = 0;	// four states: right(0)-down(1)-left(2)-up(3)
		int up = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1;
		while(up <= down && left <= right){
			if(state == 0){
				for(int i = left; i<=right; i++)
					res.add(matrix[up][i]);
				up++;
			}else if(state == 1){
				for(int i = up; i<=down; i++)
					res.add(matrix[i][right]);
				right--;
			}else if(state == 2){
				for(int i = right; i>=left; i--)
					res.add(matrix[down][i]);
				down--;
			}else{	
				for(int i = down; i >= up; i--)
					res.add(matrix[i][left]);
				left++;
			}
			state = (state+1)%4;
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiralOrder(matrix).toString());
	}
}