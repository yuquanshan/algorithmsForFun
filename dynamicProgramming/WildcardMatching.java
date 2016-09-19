/**
given two strings, see if they match with wildcard,
wildcard:
	'?' matches any single character;
	'*' matches any sequence of characters
*/
import java.util.*;

public class WildcardMatching{
	public static boolean isMatch(String s, String p){
		if((s == null || s.length() == 0) && (p == null || p.length() == 0))
			return true;
		if(s == null || s.length() == 0)
			if(p.equals("*"))
				return true;
			else
				return false;
		if(p == null || p.length() == 0)
			if(s.equals("*"))
				return true;
			else
				return false;
		boolean[][] table = new boolean[s.length()+1][p.length()+1];	// table[i][j] records whether last i chars in s and last j in p match
		boolean ticket = true;
		for(int i = 1; i <= s.length(); i++){
			if(s.charAt(s.length()-i) != '*')
				ticket = false;
			if(ticket)
				table[i][0] = true;
			else
				table[i][0] = false;
		}
		ticket = true;
		for(int i = 1; i <= p.length(); i++){
			if(p.charAt(p.length()-i) != '*')
				ticket = false;
			if(ticket)
				table[0][i] = true;
			else
				table[0][i] = false;
		}
		table[0][0] = true;
		for(int i = 1; i <= s.length(); i++){
			for(int j = 1; j <= p.length(); j++){
				if(s.charAt(s.length()-i) == p.charAt(p.length()-j))
					table[i][j] = table[i-1][j-1];
				else if(s.charAt(s.length()-i) == '?')
					table[i][j] = table[i-1][j-1];
				else if(p.charAt(p.length()-j) == '?')
					table[i][j] = table[i-1][j-1];
				else if(s.charAt(s.length()-i) == '*'){
					boolean res = false;
					for(int k = j; k >=0; k--)
						res = res || table[i-1][k];
					table[i][j] = res;
				}else if(p.charAt(p.length()-j) == '*'){
					boolean res = false;
					for(int k = i; k >= 0; k--)
						res = res || table[k][j-1];
					table[i][j] = res;
				}
			}
		}
		return table[s.length()][p.length()];
	}	
	public static void main(String[] args) {
		String s = "aa";
		String t = "a*";
		if(isMatch(s,t))
			System.out.println(s+" and "+t+" match.");
		else
			System.out.println(s+" and "+t+" doesn't match.");
	}
}