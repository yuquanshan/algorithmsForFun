/** Remove the minimum number of invalid parentheses in order to make the input string valid. 
* Return all possible results.
*
* Note: The input string may contain letters other than the parentheses ( and ).
* 
* Examples:
* "()())()" -> ["()()()", "(())()"]
* "(a)())()" -> ["(a)()()", "(a())()"]
* ")(" -> [""]
*
* public List<String> removeInvalidParentheses(String s)
*/
import java.util.*;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0) return res;
		helper(s, 0, 0, new char[]{'(', ')'}, res);
		return res;
	}
	// need to set start-to-cancel point, otherwise "()())())" will duplicate
	//												  .	 .
	private void helper(String s, int pos, int start, char[] pair, List<String> res) {
		int acc = 0;
		for(int i = pos; i < s.length(); i++) {
			if(s.charAt(i) == pair[0]) acc++;
			else if(s.charAt(i) == pair[1]) {
				if(acc == 0){
					int j = i;
					while(j >= start) {
						if(s.charAt(j) == pair[1] && (j == start || s.charAt(j - 1) != pair[1])) {
							helper(s.substring(0,j)+s.substring(j+1,s.length()), i, j, pair, res);
						}
						j--;
					}
					return;
				}else{
					acc--;
				}
			}
		}
		if(pair[0] == '(') {
			helper(new StringBuilder(s).reverse().toString(), 0, 0, new char[]{')','('}, res);
		}else {
			res.add(new StringBuilder(s).reverse().toString());
		}
	}
	public static void main(String[] args) {
		String s = "()())())";
		RemoveInvalidParentheses test = new RemoveInvalidParentheses();
		System.out.println(test.removeInvalidParentheses(s));
	}
}