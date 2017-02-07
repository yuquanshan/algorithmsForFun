/** Given a string S and a string T, find the minimum window in S 
* which will contain all the characters in T in complexity O(n).
*
* For example,
* S = "ADOBECODEBANC"
* T = "ABC"
* Minimum window is "BANC".
*
* public String minWindow(String s, String t)
*/
import java.util.*;

public class MinCharWindow{
	public static String minWindow(String s, String t){
		if(s == null || t == null)
			return "";
		int soFarStart = 0;
		int soFarEnd = s.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, Integer> boundmap = new HashMap<Character, Integer>(); 
		int p1 =0;
		int countDown = 0;
		for(int i = 0; i < t.length(); i++){
			countDown++;
			if(!map.containsKey(t.charAt(i))){
				map.put(t.charAt(i), 0);
				boundmap.put(t.charAt(i), 0);
			}
			boundmap.put(t.charAt(i), boundmap.get(t.charAt(i)) + 1);
		}
		while(p1 < s.length()){
			if(map.containsKey(s.charAt(p1))){
				map.put(s.charAt(p1),1);
				countDown--;
				break;
			}
			p1++;
		}
		if(countDown == 0)
		    return s.substring(p1, p1 + 1);
		for(int i = p1 + 1; i < s.length(); i++){
			if(s.charAt(p1) == s.charAt(i) && map.get(s.charAt(p1)) == boundmap.get(s.charAt(p1))){
				p1++;
				while(p1 < s.length() && (!map.containsKey(s.charAt(p1)) || map.get(s.charAt(p1)) > boundmap.get(s.charAt(p1)))){
					if(map.containsKey(s.charAt(p1)))
						map.put(s.charAt(p1), map.get(s.charAt(p1)) - 1);
					p1++;
				}
			}else if(map.containsKey(s.charAt(i))){
					if(map.get(s.charAt(i)) < boundmap.get(s.charAt(i)))
						countDown--;
					map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
			if(countDown == 0){
				if(soFarEnd - soFarStart > i - p1){
					soFarEnd = i;
					soFarStart = p1;
				}
			}
		}
		if(soFarEnd < s.length())
			return s.substring(soFarStart, soFarEnd + 1);
		else
			return "";
	}
	public static void main(String[] args) {
		String S = "a"; //"ADOBECODEBANC";
		String T = "aa";
		System.out.println(minWindow(S, T));
	}
}