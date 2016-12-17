/**
* given two regular expressions, see if they match 
* '*' can be used to eliminate or duplicate multiple 
* the character right in front of it.
* '.' can be used to match a character. for example,
* 	isMatch("aa", ".*") -> true
*	isMatch("ab", ".*") -> true
*	isMatch("aab", "c*a*b") -> true
* public static boolean isMatch(String s, String p)
*/

public class RegularExpressionMatching{
	public static boolean isMatch(String s, String p){
		if(s == null || p == null)
			return false;
		String ss = "";
		String pp = "";
		boolean flag = true;
		for(int i = 0; i<s.length(); i++){
			if(flag){
				if(s.charAt(i)!='*'){
					flag = false;
					ss = ss+s.charAt(i);
				}
			}else{
				ss = ss+s.charAt(i);
				if(s.charAt(i)=='*'){
					flag = true;
				}
			}
		}
		flag = true;
		for(int i = 0; i<p.length(); i++){
			if(flag){
				if(p.charAt(i)!='*'){
					flag = false;
					pp = pp+p.charAt(i);
				}
			}else{
				pp = pp+p.charAt(i);
				if(p.charAt(i)=='*'){
					flag = true;
				}
			}
		}
		boolean[][] match = new boolean[ss.length()+1][pp.length()+1];
		match[0][0] = true;

		for(int i = 0; i<=ss.length(); i++){
			for(int j = 0; j<=pp.length(); j++){
				if(i == 0 && j == 0)
					match[0][0] = true;
				else if(i>0 && j>0 && (ss.charAt(i-1) == pp.charAt(j-1) || ss.charAt(i-1) == '.' || pp.charAt(j-1) == '.')){
					match[i][j] = match[i-1][j-1];
				}else if(i>0 && ss.charAt(i-1) == '*'){
					match[i][j] = match[i-2][j] || match[i-1][j];
					if(j > 0 && ss.charAt(i-2) == pp.charAt(j-1))
						match[i][j] = match[i][j] || match[i][j-1];
				}else if(j>0 &&pp.charAt(j-1) == '*'){	
					match[i][j] = match[i][j-2] || match[i][j-1];
					if(i > 0 && ss.charAt(i-1) == pp.charAt(j-2))
						match[i][j] = match[i][j] || match[i-1][j];
				}else{
					match[i][j] = false;
				}
			}
		}
		for(int i = 0; i<=ss.length(); i++){
			for(int j = 0; j<=pp.length(); j++){
				if(match[i][j])
					System.out.format("1");
				else
					System.out.format("0");
			}
			System.out.println();
		}
		return match[ss.length()][pp.length()];
	}
	public static void main(String[] args) {
		String s = "acaabbaccbbacaabbbb";
		String p = "a*.*b*.*a*aa*a*";
		if(isMatch(s,p))
			System.out.println("Test passed!");
	}
}