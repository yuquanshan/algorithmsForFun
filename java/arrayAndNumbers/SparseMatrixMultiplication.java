/** Given two sparse matrices A and B, return the result of AB.
*
* You may assume that A's column number is equal to B's row number.
*
* Example:
*
* A = [
*  [ 1, 0, 0],
*  [-1, 0, 3]
* ]
*
* B = [
*  [ 7, 0, 0 ],
*  [ 0, 0, 0 ],
*  [ 0, 0, 1 ]
* ]
*
*      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
* AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
*                   | 0 0 1 |
* public int[][] multiply(int[][] A, int[][] B)
*/
import java.util.*;

public class SparseMatrixMultiplication{
	public static int[][] multiply(int[][] A, int[][] B){
		if(A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0)
			return null;
		int[][] res = new int[A.length][B[0].length];
		List<List<Integer>> arow = new ArrayList<List<Integer>>(A.length);
		List<List<Integer>> bcol = new ArrayList<List<Integer>>(B[0].length);
		for(int i = 0; i < A.length; i++){
			arow.add(new ArrayList<Integer>());
			for(int j = 0; j < A[i].length; j++){
				if(A[i][j] != 0)
					arow.get(i).add(j);
			}
		}
		for(int i = 0; i < B[0].length; i++){
			bcol.add(new ArrayList<Integer>());
			for(int j = 0; j < B.length; j++){
				if(B[j][i] != 0)
					bcol.get(i).add(j);
			}
		}
		for(int i = 0; i < res.length; i++){
			for(int j = 0; j < res[0].length; j++)
				res[i][j] = calcElem(A, B, i, j, arow.get(i), bcol.get(j));
		}
		return res;
	}
	private static int calcElem(int[][] A, int[][] B, int i, int j, List<Integer> a, List<Integer> b){
		int ap = 0, bp = 0, res = 0;
		while(ap < a.size() && bp < b.size()){
			if(a.get(ap) == b.get(bp)){
				res += A[i][a.get(ap)]*B[b.get(bp)][j];
				ap++; bp++;
			}else if(a.get(ap) < b.get(bp)){
				ap++;
			}else{
				bp++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] A = {{1, 0, 0},{-1, 0, 3}};
		int[][] B = {{7, 0, 0},{0, 0, 0},{0, 0, 1}};
		int[][] res = multiply(A, B);
		for(int[] r: res)
			System.out.println(Arrays.toString(r));
	}
}

