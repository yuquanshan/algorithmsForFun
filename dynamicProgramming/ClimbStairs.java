/**
take n steps to reach another stage, you can climb either 1 or 2 steps.
how many possible steps combinations to reach you destination?
*/

public class ClimbStairs{
	public static int steps(int n){
		if(n == 0)
			return 1;
		if(n == 1)
			return 1;
		int[] away = new int[n+1]; // index indicates how many steps away from the destination
		away[0] = 1;
		away[1] = 1;
		for(int i = 2; i<=n; i++){
			away[i] = away[i-1]+away[i-2];
		}
		return away[n];
	}
	public static void main(String[] args) {
		int n = 3;
		System.out.format("%d away from destination, %d step combinations.\n", n, steps(n));
	}
}