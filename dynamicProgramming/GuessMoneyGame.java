/** We are playing the Guess Game. The game is as follows:
*
* I pick a number from 1 to n. You have to guess which number I picked.
* Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
*
* However, when you guess a particular number x, and you guess wrong, you pay $x. 
* You win the game when you guess the number I picked.
*
* Example:
* n = 10, I pick 8.
* 
* First round:  You guess 5, I tell you that it's higher. You pay $5.
* Second round: You guess 7, I tell you that it's higher. You pay $7.
* Third round:  You guess 9, I tell you that it's lower. You pay $9.
* 
* Game over. 8 is the number I picked.
* 
* You end up paying $5 + $7 + $9 = $21.
* Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
* public int getMoneyAmount(int n)
*/
import java.util.*;

public class GuessMoneyGame{
	public static int getMoneyAmount(int n){
		int[][] loss = new int[n+2][n+2]; 	// loss[i][j] length i, starting from j
		for(int i = 1; i<=n; i++){
			loss[1][i] = 0;
		}
		for(int i = 2; i<=n; i++){
			for(int j = 1; j<=n+1-i; j++){
				int minmax = Integer.MAX_VALUE;
				for(int k = j; k<=j+i-1; k++){
					minmax = Math.min(minmax, Math.max(loss[k-j][j]+k, loss[i-k+j-1][k+1]+k));
				}
				loss[i][j] = minmax;
			}
		}
		return loss[n][1];
	}
	public static void main(String[] args) {
		System.out.println(getMoneyAmount(3));
	}
}