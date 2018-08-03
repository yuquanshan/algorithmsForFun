/** Given a list of unique words, find all pairs of distinct indices (i, j) 
* in the given list, so that the concatenation of the two words, i.e. 
* words[i] + words[j] is a palindrome.
*
* Example 1:
* Given words = ["bat", "tab", "cat"]
* Return [[0, 1], [1, 0]]
* The palindromes are ["battab", "tabbat"]
* Example 2:
* Given words = ["abcd", "dcba", "lls", "s", "sssll"]
* Return [[0, 1], [1, 0], [3, 2], [2, 4]]
* The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/
import java.util.*;

public class PalindromePairs{
	static class TrieNode{
		Map<Character, TrieNode> map;
		int indx;
		TrieNode(){
			map = new HashMap<Character, TrieNode>();
			indx = -1;
		}
	}
	public static List<List<Integer>> palindromePairs(String[] words){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(words == null || words.length < 2){
			return res;
		}
		TrieNode prefixTree = buildPrefixTree(words);
		TrieNode suffixTree = buildSuffixTree(words);
		Set<Integer> visited = new HashSet<Integer>();
		int empty = -1;
		for(int i =0; i<words.length; i++){
		    if(words[i].length() == 0)
		        empty = i;
		}
		for(int i = 0; i<words.length; i++){
			visited.add(i);
			if(empty != i && empty != -1){
			    if(checkPalinStart(words[i],0)){
			        List<Integer> l1 = new ArrayList<Integer>();
			        l1.add(empty); l1.add(i);
			        List<Integer> l2 = new ArrayList<Integer>();
			        l2.add(i); l2.add(empty);
			        res.add(l1); res.add(l2);
			    }
			}
			// if w is lengthy string in the first half
			TrieNode node = suffixTree;
			for(int j = 0; j<words[i].length(); j++){
				if(!node.map.containsKey(words[i].charAt(j))) break;
				node = node.map.get(words[i].charAt(j));
				if(node.indx != -1 && i != node.indx){
					if(checkPalinStart(words[i],j+1)){
						List<Integer> list = new ArrayList<Integer>();
						if(j != words[i].length()-1){
							list.add(i); list.add(node.indx);
							res.add(list);
						}else if(!visited.contains(node.indx)){
							list.add(i); list.add(node.indx);
							res.add(list);
						}
					}
				}
			}
			// if w is lengthy string in the second half
			node = prefixTree;
			for(int j = words[i].length()-1; j>=0; j--){
				if(!node.map.containsKey(words[i].charAt(j))) break;
				node = node.map.get(words[i].charAt(j));
				if(node.indx != -1 && i != node.indx){
					if(checkPalinEnd(words[i],j-1)){
						List<Integer> list = new ArrayList<Integer>();
						if(j != 0){
							list.add(node.indx); list.add(i);
							res.add(list); 
						}else if(!visited.contains(node.indx)){
							list.add(node.indx); list.add(i);
							res.add(list);
						}
					}
				}
			}
		}
		return res;
	}
	private static boolean checkPalinStart(String s, int start){
		int end = s.length()-1;
		while(end - start > 0){
			if(s.charAt(start) != s.charAt(end))
				return false;
			end--;
			start++;
		}
		return true;
	}
	private static boolean checkPalinEnd(String s, int end){
		int start = 0;
		while(end - start > 0){
			if(s.charAt(start) != s.charAt(end))
				return false;
			end--;
			start++;
		}
		return true;
	}
	private static TrieNode buildPrefixTree(String[] words){
		TrieNode root = new TrieNode();
		for(int i = 0; i<words.length; i++){
			TrieNode tmp = root;
			for(int j = 0; j < words[i].length(); j++){
				if(!tmp.map.containsKey(words[i].charAt(j)))
					tmp.map.put(words[i].charAt(j),new TrieNode());
				tmp = tmp.map.get(words[i].charAt(j));
			}
			tmp.indx = i;
		}
		return root;
	}
	private static TrieNode buildSuffixTree(String[] words){
		TrieNode root = new TrieNode();
		for(int i = 0; i<words.length; i++){
			TrieNode tmp = root;
			for(int j = words[i].length()-1; j>=0; j--){
				if(!tmp.map.containsKey(words[i].charAt(j)))
					tmp.map.put(words[i].charAt(j),new TrieNode());
				tmp = tmp.map.get(words[i].charAt(j));
			}
			tmp.indx = i;
		}
		return root;
	}
	public static void main(String[] args) {
		String[] words = {"a","abc","aba",""};// {"abcd", "dcba", "lls", "s", "sssll"};
		List<List<Integer>> res = palindromePairs(words);
		System.out.println(res.toString());
	}
}