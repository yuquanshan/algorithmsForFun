/**
* given a string find its *continuous* substring with at most k distinct 
* characters, for example, given s = "eceba" and k = 2, return 3, because 
* of "ece".
* public static int lengthOfLongestSubstringKDistinct(String s, int k)
* (used a DP to solve this problem for the first time, however, there is another
* more efficient way, sliding window is great, you can even use doubly linked list
* combined with hashmap to implement a LRU key-value cache, for even quick lookup!)
*/
import java.util.*;

public class LongestSubstringWithKDistinctChars{
	public static int lengthOfLongestSubstringKDistinct(String s, int k){
		if(k >= s.length())
			return s.length();
		if(k == 0)
			return 0;
		HashMap<Character, Integer> set = new HashMap<Character, Integer>();
		int longestSoFar = 0;
		int curLen = 0;
		int pt = 0;
		for(int i = 0; i<s.length(); i++){
			if(set.keySet().size() < k || set.containsKey(s.charAt(i))){
				set.put(s.charAt(i),i);
				curLen += 1;
			}else{
				int lowest = i-1;
				char lk = s.charAt(i-1);
				for(char key: set.keySet()){
					if(set.get(key) < lowest){
						lowest = set.get(key);
						lk = key;
					}
				}
				set.remove(lk);
				set.put(s.charAt(i),i);
				curLen = i - lowest;
			}
			longestSoFar = curLen>longestSoFar?curLen:longestSoFar;
		}
		return longestSoFar;
	}
	public static void main(String[] args) {
		String s = "aba";
		int k = 1;
		System.out.println(lengthOfLongestSubstringKDistinct(s,k));
	}
}