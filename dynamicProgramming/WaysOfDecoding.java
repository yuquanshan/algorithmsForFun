/**
* encode the letters to digits like 
*	'A' -> 1
*	'B' -> 2
*	...
* given a string of encoded digits, find the number of all possible ways of decoding.
* public int numOfWays(String s)
*/
import java.util.*;

public class WaysOfDecoding{
	public static int numOfWays(String s){
		if(s.charAt(0) == '0')
			return 0;
		int[] dp = new int[s.length()+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i<=s.length(); i++){
			if(s.charAt(i-1) == '0'){
				if(s.charAt(i-2) == '0')
					return 0;
				if(Integer.parseInt(s.substring(i-2,i))>26)
					return 0;
				dp[i] = dp[i-2];
			}else{
				if(s.charAt(i-2) != '0'){
					int tmp = Integer.parseInt(s.substring(i-2,i));
					if(tmp > 26 || tmp < 10){
						dp[i] = dp[i-1];
					}else{
						dp[i] = dp[i-1] + dp[i-2];
					}
				}else{
					dp[i] = dp[i-1];
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[s.length()];
	}
	public static void main(String[] args) {
		String s = "11111878787676172120121101212918291829819";
		System.out.println("The number of ways of decoding " + s + " is " + numOfWays(s));
	}
}