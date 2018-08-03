/** There is a new alien language which uses the latin alphabet. However, the order among 
* letters are unknown to you. You receive a list of words from the dictionary, where 
* words are sorted lexicographically by the rules of this new language. Derive the order 
* of letters in this language.
*
* For example,
* Given the following words in dictionary,
*
* [
*  "wrt",
*  "wrf",
*  "er",
*  "ett",
*  "rftt"
* ]
* The correct order is: "wertf".
*
* Note:
* You may assume all letters are in lowercase.
* If the order is invalid, return an empty string.
* There may be multiple valid order of letters, return any one of them is fine.
*/

import java.util.*;

public class AlienDictionary{
	public static String correctOrder(List<String> dictionary){
		String last = dictionary.get(0);
		HashMap<Character, List<Character>> graph = new HashMap<Character,List<Character>>();
		for(int i = 1; i<dictionary.size(); i++){
			String s = dictionary.get(i);
			int j = 0;
			while(j < Math.min(s.length(),last.length()) && last.charAt(j) == s.charAt(j)){
				j++;
			}
			if(j<Math.min(s.length(),last.length())){
				if(!graph.containsKey(last.charAt(j))){
					graph.put(last.charAt(j),new ArrayList<Character>());
				}
				if(!graph.containsKey(s.charAt(j)))
					graph.put(s.charAt(j),new ArrayList<Character>());
				graph.get(last.charAt(j)).add(s.charAt(j));
			}
			last = s;
		}
		HashSet<Character> finished = new HashSet<Character>();
		Stack<Character> stack = new Stack<Character>();
		for(char c: graph.keySet()){
			if(!dfs(c, graph, new HashSet<Character>(), finished,stack))
				return null;
		}
		String res = "";
		while(!stack.isEmpty())
			res += stack.pop();
		return res;
	}
	private static boolean dfs(char c, HashMap<Character, List<Character>> graph, HashSet<Character> visited, HashSet<Character> finished, Stack<Character> stack){
		if(!finished.contains(c)){
			visited.add(c);
			//System.out.println(c);
			for(char child: graph.get(c)){
				if(visited.contains(child))
					return false;
				else
					dfs(child, graph, visited, finished, stack);
			}	
			finished.add(c);
			stack.push(c);
		}
		return true;
	}
	public static void main(String[] args) {
		List<String> dictionary = new ArrayList<String>();
		dictionary.add("wrt"); dictionary.add("wrf"); dictionary.add("er"); dictionary.add("ett"); dictionary.add("rftt");
		String res = correctOrder(dictionary);
		if(res != null)
			System.out.println(res);
	}
}