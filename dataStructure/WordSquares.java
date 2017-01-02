/** given a set of words (without duplicates), find all word 
* squares you can build from them.
* A sequence of words forms a valid word square if the kth row 
* and column read the exact same string, for example,
* ["ball","area","lead","lady"] construct a valid word square
*	b a l l
*	a r e a
*	l e a d
*	l a d y
*/
import java.util.*;

public class WordSquares{
	static class TrieNode{
		HashMap<Character, TrieNode> map;
		boolean endOfWord;
		TrieNode(){
			map = new HashMap<Character, TrieNode>();
			endOfWord = false;
		}
	}
	public static List<List<String>> allWordSquares(String[] words){
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<Integer, TrieNode> l2t = new HashMap<Integer,TrieNode>();	// length to trie 
		for(String word: words){
			TrieNode cur = null;
			if(l2t.containsKey(word.length())){
				cur = l2t.get(word.length());
			}else{
			 	cur = new TrieNode();
			 	l2t.put(word.length(),cur);
			}
			
			for(int i = 0; i<word.length(); i++){
				if(cur.map.containsKey(word.charAt(i)))
					cur = cur.map.get(word.charAt(i));
				else{
					TrieNode tmp = new TrieNode();
					cur.map.put(word.charAt(i),tmp);
					cur = tmp;
				}
			}
			cur.endOfWord = true;
		}
		for(String word: words){
			int len = word.length();
			TrieNode root = l2t.get(len);
			List<String> sof = new ArrayList<String>();
			sof.add(word);
			visit(root,sof,res);
		}
		return res;
	}
	private static void visit(TrieNode root, List<String> list, List<List<String>> res){
		int len = list.get(0).length();
		if(len == list.size())
			res.add(new ArrayList<String>(list));
		else if(len == list.size()+1){
			String prefix = "";
			for(String s: list){
				prefix = prefix+s.charAt(len-1);
			}
			List<String> box = findWordStartingWith(root,prefix);
			for(String s: box){
				List<String> tmp = new ArrayList<String>(list);
				tmp.add(s);
				res.add(tmp);
			}
		}else{
			String prefix = "";
			for(String s: list){
				prefix = prefix+s.charAt(list.size());
			}
			List<String> box = findWordStartingWith(root,prefix);
			for(String s: box){
				list.add(s);
				visit(root,list,res);
				list.remove(list.size()-1);
			}
		}
	}
	private static List<String> findWordStartingWith(TrieNode root, String prefix){
		List<String> res = new ArrayList<String>();
		TrieNode tmp = root;
		for(int i = 0; i<prefix.length(); i++){
			if(tmp.map.containsKey(prefix.charAt(i)))
				tmp = tmp.map.get(prefix.charAt(i));
			else
				return res;
		}
		List<String> rest = findToEnd(tmp);
		for(String s: rest)
			res.add(prefix+s);
		return res;
	}
	private static List<String> findToEnd(TrieNode node){
		List<String> res = new ArrayList<String>();
		for(char c: node.map.keySet()){
			TrieNode tmp = node.map.get(c);
			if(tmp.endOfWord)
				res.add(Character.toString(c));
			else{
				List<String> rest = findToEnd(tmp);
				for(String s: rest)
					res.add(Character.toString(c)+s);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] set = {"a","ball", "area", "lead", "lady","wall"};
		List<List<String>> res = allWordSquares(set);
		System.out.println(res.toString());
	}
}