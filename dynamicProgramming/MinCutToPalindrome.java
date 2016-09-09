/**
given a string, cut it into substrings such that every substring is a palindrome,
return the minimum cuts needed.
*/

public class MinCutToPalindrome{
	public static int minCut(String s){
		if(s == null || s.length() == 0)
			return 0;
		int[] dp = new int[s.length()+1];	// dp[i] records min cuts required to from 1th to ith char
		dp[0] = -1;
		dp[1] = 0;
		for(int i = 2; i <= s.length(); i++){
			int min = dp[i-1] + 1;
			for(int j = 0; j<i-1; j++){
				if(s.charAt(j) == s.charAt(i-1) && isPalindorme(s.substring(j+1,i-1)) && dp[j]+1<min){
					mid = dp[j]+1;
				}
			}
			dp[i] = min;
		}
		return dp[s.length()];
	}
	public static boolean isPalindorme(String s){
		if(s==null || s.length() == 0)
			return true;
		int len = s.length();
		boolean res = true;
		int head = 0;
		int end = s.length()-1;
		while(end > head){
			if(s.charAt(end)!=s.charAt(head))
				return false;
			else{
				head++;
				end--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String str = "aab";
		System.out.println("Min cut of "+str+" is "+minCut(str));
	}
}