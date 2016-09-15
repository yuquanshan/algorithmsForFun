/**
given n items with different sizes and an empty backpack with a certain size,
how much the backpack can hold?
*/
import java.util.*;

public class FillBackpack{
	public static int fill(int m, int[] A){
		if(A == null || A.length == 0 || m<=0)
			return 0;
		//Arrays.sort(A);
		int n = A.length;
		int[][] table = new int[m+1][n+1];	// table[i][j] if space is i and items to jth item, how much can fill
		for(int i = 0; i <= n; i++){
			table[0][i] = 0;
		}
		for(int i = 0; i <= m; i++){
			table[i][0] = 0;
		}
		for(int i = 1; i <= m; i++){
			for(int j=1; j<=n; j++){
				if(A[j-1]<=i)
					table[i][j] = Math.max(A[j-1]+table[i-A[j-1]][j-1],table[i][j-1]);
				else
					table[i][j] = table[i][j-1];
			}
		}
		return table[m][n];
	}
	public static void main(String[] args) {
		int[] A = {2,3,5,7};
		int m = 11;
		System.out.println("The items are "+Arrays.toString(A));
		System.out.format("The bag size is %d, it can fill %d.\n",m,fill(m,A));
	}
}