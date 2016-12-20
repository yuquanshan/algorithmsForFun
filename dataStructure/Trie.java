/**
* implement a Trie for string
*  class TrieNode {
*       public TrieNode() {}
*   }
*   public class Trie {
*       private TrieNode root;
*       public Trie() {
*           root = new TrieNode();
*       }
*       public void insert(String word){}
*       public boolean search(String word){}
*       public boolean startsWith(String prefix){}
*   }
* (witnessed in Google interview)
*/
import java.util.*;

public class Trie {
    static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode(){
            children = new HashMap<Character, TrieNode>();
            endOfWord = false;
        }
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word){
        if(word != null && word.length() != 0){
            TrieNode cur = root;
            for(int i = 0; i<word.length(); i++){
                if(cur.children.containsKey(word.charAt(i)))
                    cur = cur.children.get(word.charAt(i));
                else{
                    TrieNode tmp = new TrieNode();
                    cur.children.put(word.charAt(i),tmp);
                    cur = tmp;
                }
            }
            cur.endOfWord = true;
        }
    }
    public boolean search(String word){
        if(word == null || word.length() == 0)
            return true;
        TrieNode cur = root;
        for(int i = 0; i<word.length(); i++){
            if(cur.children.containsKey(word.charAt(i)))
                cur = cur.children.get(word.charAt(i));
            else
                return false;
        }
        return cur.endOfWord;
    }
    public boolean startsWith(String prefix){
        if(prefix == null || prefix.length() == 0)
            return true;
        TrieNode cur = root;
        for(int i = 0; i<prefix.length(); i++){
            if(cur.children.containsKey(prefix.charAt(i)))
                cur = cur.children.get(prefix.charAt(i));
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        if(trie.search("hello"))
            System.out.println("Test 1 passed");
        if(trie.startsWith("he"))
            System.out.println("Test 2 passed");
    }
}