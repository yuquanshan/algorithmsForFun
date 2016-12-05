/**
* given a 2-D character matrix, and a bunch of words, 
* find all words in the dictionary can be constructed 
* from the adjacent (up, down, right, left) cells in 
* the matrix.
* public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) 
* (try to use Trie to solve this problem, need much time to solve for the first time - 
* more than 45 min)
*/
import java.util.*;

public class DictionarySearch{
	static class TrieNode{
		HashMap<Character,TrieNode> children;
		String word;
		TrieNode(){
			children = new HashMap<Character,TrieNode>();
			word = "";
		}
	}
	public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words){
		TrieNode root = new TrieNode();
		for(String word: words){
			TrieNode tmp = root;
			for(int i = 0; i<word.length(); i++){
				if(!tmp.children.containsKey(word.charAt(i))){
					tmp.children.put(word.charAt(i),new TrieNode());
				}
				tmp = tmp.children.get(word.charAt(i));
			}
			tmp.word = word;
		}
		HashSet<String> wordFound = new HashSet<String>();
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[0].length; j++){
				if(root.children.containsKey(board[i][j])){
					HashSet<Integer> visited = new HashSet<Integer>();
					visited.add(i*board[0].length+j);
					wordCollector(board, i, j, root.children.get(board[i][j]), wordFound, visited);
					visited.remove(i*board[0].length+j);
				}
			}
		}
		ArrayList<String> res = new ArrayList<String>();
		for(String word: words){
			if(wordFound.contains(word))
				res.add(word);
		}
		return res;
	}
	public static void wordCollector(char[][] board, int i, int j, TrieNode root, HashSet<String> wordFound,HashSet<Integer> visited){
		if(!root.word.equals("") && !wordFound.contains(root.word)){
			wordFound.add(root.word);
		}
		//System.out.format("(%d,%d):%c\n",i,j,board[i][j]);
		if(i > 0 && root.children.containsKey(board[i-1][j]) && !visited.contains((i-1)*board[0].length+j)){
			visited.add((i-1)*board[0].length+j);
			wordCollector(board, i-1, j, root.children.get(board[i-1][j]),wordFound, visited);
			visited.remove((i-1)*board[0].length+j);
		}
		if(i<board.length-1 && root.children.containsKey(board[i+1][j]) && !visited.contains((i+1)*board[0].length+j)){
			visited.add((i+1)*board[0].length+j);
			wordCollector(board, i+1, j, root.children.get(board[i+1][j]),wordFound, visited);
			visited.remove((i+1)*board[0].length+j);
		}
		if(j>0 && root.children.containsKey(board[i][j-1]) && !visited.contains(i*board[0].length+j-1)){
			visited.add(i*board[0].length+j-1);
			wordCollector(board,i,j-1,root.children.get(board[i][j-1]),wordFound,visited);
			visited.remove(i*board[0].length+j-1);
		}
		if(j<board[0].length-1 && root.children.containsKey(board[i][j+1]) && !visited.contains(i*board[0].length+j+1)){
			visited.add(i*board[0].length+j+1);
			wordCollector(board,i,j+1,root.children.get(board[i][j+1]),wordFound,visited);
			visited.remove(i*board[0].length+j+1);
		}
	}
	public static void main(String[] args) {
		char[][] board = {{'a','b','c','e'},{'s','f','e','s'},{'a','d','e','e'}};
		ArrayList<String> words = new ArrayList<String>();
		/*words.add("dog"); words.add("dad"); words.add("dgdg");
		words.add("can"); words.add("again");*/
		words.add("abceseeefs"); words.add("abceseedasfe");
		ArrayList<String> res = wordSearchII(board, words);
		System.out.format("The found words are %s\n",res.toString());
	}
}