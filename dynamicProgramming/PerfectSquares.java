/* Given a positive integer n, find the least number of perfect square numbers 
* (for example, 1, 4, 9, 16, ...) which sum to n.
* For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, 
* return 2 because 13 = 4 + 9.
* public int numSquares(int n)
*/
import java.util.*;

public class PerfectSquares{
	public static int numSquares(int n){
		int[] array = new int[n+1];
		array[0] = 0;
		for(int i = 1; i<=n; i++){
			int bound = (int)Math.sqrt(i);
			int smallest = Integer.MAX_VALUE;
			for(int j = 1; j<=bound; j++)
				smallest = Math.min(smallest,array[i-j*j]+1);
			array[i] = smallest;
		}
		return array[n];
	}
	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
}
