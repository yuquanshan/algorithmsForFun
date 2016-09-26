/**
given an array of numbers, and a target adjacent difference, find minimum adjustment 
to satisify that target difference.
*/
// FAILED TO FIGURE IT OUT MYSELF...
import java.util.*;

public class MinAdjust{
	public static int minAdjust(ArrayList<Integer> A, int target){
		if(A == null || A.size() == 0)
			return 0;
		int low = A.get(0);
		int high = A.get(0);
		for(int i: A){
			if(i < low)
				low = i;
			if(i>high)
				high = i;
		}
		int[][] dp = new int[A.size()+1][high-low+1];
		for(int i = 0; i < high-low+1; i++)
			dp[0][i] = 0;
		for(int i = 1; i <= A.size(); i++){
			for(int j = 0; j < high-low+1; j++){	// j higher than lowest
				int lbound = Math.max(0,j-target);
				int hbound = Math.min(high-low, j+target);
				int min = Integer.MAX_VALUE;
				for(int k = lbound; k<=hbound; k++){
					if(min > Math.abs(A.get(i-1)-j-low)+dp[i-1][k])
						min = Math.abs(A.get(i-1)-j-low)+dp[i-1][k];
				}
				dp[i][j] = min;
			}
		}
		int res = Integer.MAX_VALUE;
		for(int i = 0; i<=high-low; i++)
			if(res > dp[A.size()][i])
				res = dp[A.size()][i];
		return res;
	}
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(4);
		A.add(2);
		A.add(3);
		int target = 1;
		System.out.println(A.toString()+" target: "+target);
		System.out.println("The min adjustment cost is "+minAdjust(A,target));
	}
}