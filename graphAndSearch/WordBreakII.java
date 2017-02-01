/** Given a non-empty string s and a dictionary wordDict containing 
* a list of non-empty words, add spaces in s to construct a sentence 
* where each word is a valid dictionary word. You may assume the 
* dictionary does not contain duplicate words.
*  
* Return all such possible sentences.
* 
* For example, given
* s = "catsanddog",
* dict = ["cat", "cats", "and", "sand", "dog"].
* 
* A solution is ["cats and dog", "cat sand dog"].
*
* UPDATE (2017/1/4):
* The wordDict parameter had been changed to a list of strings (instead of a set of strings). 
* Please reload the code definition to get the latest changes.
* public List<String> wordBreak(String s, List<String> wordDict)
*/
import java.util.*;

public class WordBreakII{
	public static List<String> wordBreak(String s, List<String> wordDict){
		List<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0 || wordDict.size() == 0)
			return res;
		Set<String> dict = new HashSet<String>();
		for(String str: wordDict){
			dict.add(str);
		}
		dfs(s,dict,0, new ArrayList<String>(), res);
		return res;
	}
	public static void dfs(String s, Set<String> dict, int start, List<String> words, List<String> res){
		if(start >= s.length()){
			String tmp = "";
			for(int i = 0; i<words.size()-1; i++){
				tmp = tmp+words.get(i)+" ";
			}
			tmp = tmp+words.get(words.size()-1);
			res.add(tmp);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = start; i<s.length(); i++){
			sb.append(s.charAt(i));
			if(dict.contains(sb.toString())){
				words.add(sb.toString());
				dfs(s, dict, i+1, words, res);
				words.remove(words.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("cat"); wordDict.add("cats"); wordDict.add("and"); wordDict.add("sand"); wordDict.add("dog");
		List<String> res = wordBreak(s,wordDict);
		System.out.println(res.toString());
	}
}