/**
* write a structure WordDictionary containing method addWord(.) to add word
* to the dictionary, and method search(.) to check if the current dictionary 
* contains the word. note that wildcard '.' can be used to represent all valid 
* characters (a-z).
* 	public class WordDictionary {
*    	public void addWord(String word){}
*    	public boolean search(String word){}
*	}
* (failed to figure out a good data structure and finish on time for the first time)
*/
import java.util.*;

public class WordDictionary {
	static class TrieNode{
		HashMap<Character, TrieNode> children;
		boolean endOfWord;
		char c;
		TrieNode(){
			this.children = new HashMap<Character,TrieNode>();
			this.endOfWord = false;
		}
	}	
	TrieNode root;
	WordDictionary(){
		root = new TrieNode();
	}
    public void addWord(String word) {
    	TrieNode cur = root;
		for(int i = 0; i<word.length(); i++){
			if(!cur.children.containsKey(word.charAt(i))){
				cur.children.put(word.charAt(i),new TrieNode());
			}
			cur = cur.children.get(word.charAt(i));
			cur.c = word.charAt(i);
    	}
    	cur.endOfWord = true;
    }
    private boolean find(String word, int index, TrieNode node) {   	
    	if(index == word.length()){
    		return node.endOfWord;
    	}
    	if(node.children.containsKey(word.charAt(index))){
    		return find(word, index+1, node.children.get(word.charAt(index)));
    	}else if(word.charAt(index)=='.'){
    		for(char key: node.children.keySet()){
    			if(find(word,index+1,node.children.get(key)))
    				return true;
    		}
    		return false;
    	}
    	return false;
    }
    public boolean search(String word){
    	return find(word,0,root);
    }
    public static void main(String[] args) {
    	WordDictionary dict = new WordDictionary();
    	dict.addWord("bad");
    	dict.addWord("dad");
    	dict.addWord("mad");
    	if(!dict.search("pad"))
    		System.out.println("test1 good!");
    	if(dict.search("bad"))
    		System.out.println("test2 good!");
    	if(dict.search(".ad"))
    		System.out.println("test3 good!");
    	if(dict.search("b.."))
    		System.out.println("test4 good!");
    }
}