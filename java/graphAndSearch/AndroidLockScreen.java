/* Given an Android 3x3 key lock screen
* 	1 2 3
*	4 5 6
*	7 8 9
* and two integers m and n, 
* where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns 
* of the Android lock screen, which consist of minimum of m keys 
* and maximum n keys.
* Rules for a valid pattern:
* Each pattern must connect at least m keys and at most n keys.
* All the keys must be distinct.
* If the line connecting two consecutive keys in the pattern passes 
* through any other keys, the other keys must have previously selected 
* in the pattern. No jumps through non selected key is allowed.
* The order of keys used matters.
* *also note that there is no block in the way between 2 and 9*
* public int numberOfPatterns(int m, int n) {}
*/
import java.util.*;

public class AndroidLockScreen{
	public static int numberOfPatterns(int m, int n) {
		boolean[] visited = new boolean[10];
		int[][] jumpover = new int[10][10];
		jumpover[1][7] = jumpover[7][1] = 4;
		jumpover[1][3] = jumpover[3][1] = 2;
		jumpover[1][9] = jumpover[9][1] = 5;
		jumpover[2][8] = jumpover[8][2] = 5;
		jumpover[3][9] = jumpover[9][3] = 6;
		jumpover[3][7] = jumpover[7][3] = 5;
		jumpover[4][6] = jumpover[6][4] = 5;
		jumpover[7][9] = jumpover[9][7] = 8;
		int res = 0;
		for(int i = m; i<=n; i++){
			res += visit(1, visited, jumpover, i-1)*4;
			res += visit(2, visited, jumpover, i-1)*4;
			res += visit(5, visited, jumpover, i-1);
		}
		return res;
	}
	private static int visit(int num, boolean[] visited, int[][] jumpover, int k){
		if(k == 0)
			return 1;
		int res = 0;
		visited[num] = true;
		for(int i = 1; i<=9; i++){
			if(!visited[i] && (jumpover[num][i] == 0 || visited[jumpover[num][i]]))
				res+=visit(i,visited,jumpover,k-1);
		}
		visited[num] = false;
		return res;
	}
	public static void main(String[] args) {
		int m = 1, n = 1;
		System.out.println(numberOfPatterns(m,n));
	}
}