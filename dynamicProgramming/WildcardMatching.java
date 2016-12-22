/**
given two strings, see if they match with wildcard,
wildcard:
	'?' matches any single character;
	'*' matches any sequence of characters
*/
import java.util.*;

public class WildcardMatching{
	public static boolean isMatch(String s, String p){
		if(s == null || p == null)
			return false;
		if(s.length() == 0 && p.length() == 0)
			return true;
		boolean[][] match = new boolean[s.length()+1][p.length()+1];
		if(s.length()>0 && s.charAt(s.length()-1) == '*')
			match[1][0] = true;
		if(p.length()>0 && p.charAt(p.length()-1) == '*')
			match[0][1] = true;
		match[0][0] = true;
		for(int i = 1; i<=s.length(); i++){
			for(int j = 1; j<=p.length(); j++){
				if(s.charAt(s.length()-i) == p.charAt(p.length()-j) || s.charAt(s.length()-i) == '?' || p.charAt(p.length()-j)=='?'){
					match[i][j] = match[i-1][j-1];
				}else if(s.charAt(s.length()-i) == '*' || p.charAt(p.length()-j) == '*'){
					match[i][j] = match[i-1][j] || match[i][j-1];
				}else{
					match[i][j] = false;
				}
			}
		}
		return match[s.length()][p.length()];
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