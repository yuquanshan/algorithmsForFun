/** A message containing letters from A-Z is being encoded to numbers using the following mapping:
*
* 'A' -> 1
* 'B' -> 2
* ...
* 'Z' -> 26
* Given an encoded message containing digits, determine the total number of ways to decode it.
*
* For example,
* Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
*
* The number of ways decoding "12" is 2.
* 
* public int numDecodings(String s) 
*/

import java.util.*;

public class DecodingWays{
	public static int numDecodings(String s){
        if(s == null || s.length() == 0)
            return 0;
        else{
            int[] dp = new int[s.length() + 1];
            dp[s.length()] = 1;
            if(s.charAt(s.length() - 1) == '0')
                dp[s.length() - 1] = 0;
            else
                dp[s.length() - 1] = 1;
            for(int i = s.length() - 2; i >= 0; i--){
			    if(s.charAt(i) == '0')
			        dp[i] = 0;
			    else{
	    		    String tmp = "";
		    	    int acc = 0;
			        String num1 = tmp + s.charAt(i);
			        String num2 = num1 + s.charAt(i + 1);
			        if(Integer.parseInt(num1) > 0)
			            acc += dp[i + 1];
			        if(Integer.parseInt(num2) > 0 && Integer.parseInt(num2) < 27)
			            acc += dp[i + 2];
			        dp[i] = acc;
			    }
            }
            return dp[0];
        }
    }
	/*public static int numDecodings(String s){
        if(s == null || s.length() == 0)
            return 0;
        else
          return dfs(s, 0); 	
    }
	public static int dfs(String s, int start){
		if(start == s.length())
			return 1;
		else if(s.charAt(start) == '0')
			return 0;
		else if(start == s.length() - 1)
			return 1;
		else{
			String tmp = "";
			int acc = 0;
			String num1 = tmp + s.charAt(start);
			String num2 = num1 + s.charAt(start + 1);
			if(Integer.parseInt(num1) > 0)
				acc += dfs(s, start + 1);
			if(Integer.parseInt(num2) > 0 && Integer.parseInt(num2) < 27)
				acc += dfs(s, start + 2);
			return acc;
		}
	}
	public static int helper(String s){
		if(s == null || s.length() == 0)
			return 1;
		else if(s.charAt(0) == '0')
			return 0;
		else if(s.length() == 1){
			return 1;
		}else{
			int acc = 0;
			String number = s.substring(0,1);
			String rest = s.substring(1);
			int num = Integer.parseInt(number);
			if(num > 0)
				acc += helper(rest);
			number = s.substring(0,2);
			rest = s.substring(2);
			num = Integer.parseInt(number);
			if(num > 0 && num < 27)
				acc += helper(rest);
			return acc;
		}
	}*/
	public static void main(String[] args) {
		String s = "10";
		System.out.println("result is "+numDecodings(s));
	}
}