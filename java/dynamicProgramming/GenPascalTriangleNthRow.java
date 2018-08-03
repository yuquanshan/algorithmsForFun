/** Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * public List<Integer> getRow(int rowIndex)
 */

import java.util.*;

public class GenPascalTriangleNthRow {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		if (rowIndex == 0) {
			res.add(1); 
			return res;
		}
		if (rowIndex == 1) {
			res.add(1); res.add(1);
			return res;
		}
		int[][] row = new int[2][rowIndex+1];
		row[1][0] = 1; row[1][1] = 1;
		boolean toggle = false;
		for (int i = 2; i <= rowIndex; i++) {
			row[i%2][0] = 1;
			for (int j = 1; j < i; j++) 
				row[i%2][j] = row[(i-1)%2][j-1] + row[(i-1)%2][j];
			row[i%2][i] = 1;
		}
		for (int i = 0; i <= rowIndex; i++) res.add(row[rowIndex%2][i]);
		return res;
	}
	public static void main(String[] args) {
		GenPascalTriangleNthRow test = new GenPascalTriangleNthRow();
		System.out.println(test.getRow(3));
	}
}