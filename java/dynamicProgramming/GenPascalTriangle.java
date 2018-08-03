/** Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 *
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * public List<List<Integer>> generate(int numRows)
 */

import java.util.*;

public class GenPascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows <= 0) return res;
		for (int i = 1; i <= numRows; i++) {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(1);
			for (int j = 1; j <= i - 2; j++) {
				tmp.add(res.get(i-2).get(j-1)+res.get(i-2).get(j));
			}
			if (i > 1) tmp.add(1);
			res.add(tmp);
		}
		return res;
	}
	public static void main(String[] args) {
		int numRows = 4;
		GenPascalTriangle test = new GenPascalTriangle();
		List<List<Integer>> res = test.generate(numRows);
		for (List<Integer> l: res) System.out.println(l);
	}
}

