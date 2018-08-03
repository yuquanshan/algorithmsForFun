/**
* given n distinct positive integers, an integer k, and a number target.
* find k numbers where sum is target, calculate how many solutions there are.
* public int ksum(int[] A, int k, int target)
*/
import java.util.*;

public class KSum{
	public static int ksum(int[] A, int k, int target){
		if(target == 0)
			return 1;
		if(A == null || A.length == 0){
			if(k == 0)
				return 1;
			else
				return 0;
		}
		if(k == 0)
			return 0;
		int n = A.length;
		int[][][] table = new int[k+1][target+1][n+1];	//	table[k][i][j] represents the number of k-sum sols for i, with first j items
		// if target != 0, then if either k == 0 or n == 0 will lead to zero solution
		for(int i = 0; i <= target; i++){
			for(int j = 0; j<=n; j++)
				table[0][i][j] = 0;
		}
		for(int i = 0; i <= k; i++){
			for(int j = 0; j<= target; j++)
				table[i][j][0] = 0;
		} 
		// whenever target == 0 and k==0, there will be a solution
		for(int j = 0; j<= n; j++)
			table[0][0][j] = 1;
		for(int kk = 1; kk <= k; kk++){
			for(int i = 1; i <= target; i++){
				for(int j = 1; j <= n; j++){
					if(i - A[j-1]>=0)
						table[kk][i][j] = table[kk][i][j-1]+table[kk-1][i-A[j-1]][j-1];
					else
						table[kk][i][j] = table[kk][i][j-1];
				}
			}
		}
		return table[k][target][n];
	}
	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		int k = 2;
		int target = 5;
		System.out.format("Given "+Arrays.toString(A)+" k=%d target=%d, ",k,target);
		System.out.println("the number of k-sum solution(s) is "+ksum(A,k,target));
	}
}