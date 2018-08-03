/** 
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 *
 * public void rotate(int[][] matrix)
*/
import java.util.*;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ||
			matrix.length != matrix[0].length) return;
		int tmp = 0;
		int n = matrix.length;
		for (int i = 0; i < n/2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = tmp;
			}
		}
		return;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,0,0,0,0},{0,1,0,0,0},
						  {0,0,1,0,0},{0,0,0,1,0},{0,0,0,0,1}};
		for (int[] a: matrix) System.out.println(Arrays.toString(a));
		RotateImage test = new RotateImage();
		test.rotate(matrix);
		System.out.println("Rotated result:");
		for (int[] a: matrix) System.out.println(Arrays.toString(a));
	}
}