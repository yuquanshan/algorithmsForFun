/** Given a digit string, return all possible letter combinations that the number could represent.
* A mapping of digit to letters (just like on the telephone buttons) is given below.
* 
* Input:Digit string "23"
* Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
* public List<String> letterCombinations(String digits)
*/
import java.util.*;

public class LetterCombinations{
	public static List<String> letterCombinations(String digits){
		String[] map = new String[10];
		map[2] = "abc";
		map[3] = "def";
		map[4] = "ghi";
		map[5] = "jkl";
		map[6] = "mno";
		map[7] = "pqrs";
		map[8] = "tuv";
		map[9] = "wxyz";
		List<String> res = new ArrayList<String>();
		dfs(digits, 0, "", map, res);
		return res;
	}
	public static void dfs(String digits, int pos, String sofar, String[] map, List<String> res){
		if(pos == digits.length())
			res.add(sofar);
		else if(digits.charAt(pos)>='2' && digits.charAt(pos)<='9'){
			int ind = Character.getNumericValue(digits.charAt(pos));
			for(int i = 0; i<map[ind].length(); i++){
				dfs(digits, pos+1, sofar+map[ind].charAt(i), map, res);
			}
		}else{
			dfs(digits, pos+1, sofar, map, res);
		}
	}
	public static void main(String[] args) {
		String digits = "230";
		System.out.println(letterCombinations(digits).toString());
	}
}