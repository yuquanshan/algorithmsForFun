/**
* Suppose you have infinite number of quarters (25 cents), dimes (10 cents), 
* nickels (5 cents) and pennies (1 cent), how many ways of breaking n cents?
* public static int waysNCents(int n)
*/

public class BreakCents{
	public static int waysNCents(int n) {	// this recursive approach can pass, but it's not the most efficient algorithm
        // Write your code here
        if(n == 0)
            return 1;
        int[] comb = {1,5,10,25};
        int[][] dp = new int[4][n+1];
        for(int i = 0; i<=n; i++)
            dp[0][i] = 1;
        for(int i = 0; i<4; i++)
            dp[i][0] = 1;
        for(int i = 1; i<4; i++){
            int curr = comb[i];
            for(int j = 1; j<=n; j++){
                int dup = 0;
                dp[i][j] = 0;
                while(dup*curr <= j){
                    dp[i][j] += dp[i-1][j-dup*curr];
                    dup++;
                }
            }
        }
        return dp[3][n];
    }
    public static void main(String[] args) {
        int n = 11;
        System.out.format("There are %d ways to break %d cents.\n", waysNCents(n),n);
    }
}