/** There is a fence with n posts, each post can be painted with one of the k colors.
* You have to paint all the posts such that no more than two adjacent fence posts have the same color.
* Return the total number of ways you can paint the fence.
*
* Note:
* n and k are non-negative integers.
* public int numWays(int n, int k)
*/

public class PaintFence{
	public static int numWays(int n, int k){
		if(n == 0 || k == 0)
			return 0;
		if(n == 1)
			return k;
		int[] a = new int[2];
		a[1] = 1; a[0] = k;
		for(int i = n-3; i>=0; i--){
			int mid = (k-1)*(a[0]+a[1]);
			a[1] = a[0];
			a[0] = mid;
		}
		return k*a[0];
	}
}