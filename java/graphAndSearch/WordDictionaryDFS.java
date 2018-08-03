/**
* write a structure WordDictionary containing method addWord(.) to add word
* to the dictionary, and method search(.) to check if the current dictionary 
* contains the word. note that wildcard '.' can be used to represent all valid 
* characters (a-z).
* 	public class WordDictionary {
*    	public void addWord(String word){}
*    	public boolean search(String word){}
*	}
* (this DFS approach can be extremely slow when there are many wildcards, 
* compared with Trie)
*/
import java.util.*;

public class WordDictionaryDFS {
	HashSet<String> set;
	WordDictionaryDFS(){
		set = new HashSet<String>();
	}
    public void addWord(String word) {
        set.add(word);	
    }
    public boolean search(String word){
        ArrayList<Integer> dotpos = new ArrayList<Integer>();
    	for(int i = 0; i<word.length(); i++){
            if(word.charAt(i)=='.'){
                dotpos.add(i);
            }
        }
        if(dotpos.size()==0)
            return set.contains(word);
        int depth = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        while(!stack.isEmpty()){
            if(depth == dotpos.size()){
                if(set.contains(word))
                    return true;
                stack.pop();
                depth--;
            }else if(stack.peek() == 26){
                stack.pop();
                if(!stack.isEmpty()){
                    int tmp = stack.pop();
                    stack.push(tmp+1);
                }
                depth--;
            }else{
                word = word.substring(0,dotpos.get(depth))+(char)('a'+stack.peek())+word.substring(dotpos.get(depth)+1);
                int tmp = stack.pop();
                stack.push(tmp+1);
                stack.push(0);
                depth++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    	WordDictionaryDFS dict = new WordDictionaryDFS();
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