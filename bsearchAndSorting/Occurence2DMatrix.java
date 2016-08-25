/**
search for a value in an m*n matrix, return occurence of it. 
this matrix is row wise and column wise sorted, no duplicated 
integer in each row or column.
*/

public class Occurence2DMatrix{
	public static int searchMatrix(int[][] matrix, int target){
		if (matrix == null || matrix.length==0 || matrix[0].length==0)
			return 0;
		int n = 0;
		int m = matrix[0].length-1;
		int count = 0;
		while(m >= 0 && n <= matrix.length-1){
			if(matrix[n][m] == target){
				n++;
				m--;
				count++;
			}else if(matrix[n][m]>target){
				m--;
			}else{
				n++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{2,4,7,8},{3,5,9,10}};
		int target = 3;
		System.out.println("the occurence of "+target+" is "+searchMatrix(matrix,target)+".");
	}
}