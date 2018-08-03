/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, 
 * where n is the total number of rows in the triangle.
 *
 * public int minimumTotal(List<List<Integer>> triangle)
 */
import java.util.*;

public class MinDownPathInTriangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0 || 
			triangle.get(0).size() == 0)
			return 0;
		int n = triangle.size();
		int[] array = new int[n];
		int[] array2 = new int[n];
		boolean toggle = true;	// true means just updated array, false array2
		int count = 0;
		for (int i: triangle.get(n - 1)) array[count++] = i;
		for (int i = n - 2; i >=0; i--) {
			count = 0;
			for (int j: triangle.get(i)) {
				if (toggle) {
					array2[count] = j + Math.min(array[count],array[count+1]);
					count++;
				} else {
					array[count] = j + Math.min(array2[count],array2[count+1]);
					count++;
				}
			}
			toggle = !toggle;
		}
		if (toggle) return array[0];
		return array2[0];
	}
	public static void main(String[] args) {
		MinDownPathInTriangle test = new MinDownPathInTriangle();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(new ArrayList<Integer>());
		triangle.add(new ArrayList<Integer>());
		triangle.add(new ArrayList<Integer>());
		triangle.add(new ArrayList<Integer>());
		triangle.get(0).add(2);
		triangle.get(1).add(3); triangle.get(1).add(4);
		triangle.get(2).add(6); triangle.get(2).add(5); triangle.get(2).add(7);
		triangle.get(3).add(4); triangle.get(3).add(1); 
		triangle.get(3).add(8); triangle.get(3).add(3);
		System.out.println(test.minimumTotal(triangle)); 
	}
}