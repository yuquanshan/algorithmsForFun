/** Given an array of strings, group anagrams together.
*
* For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
* Return:
*
* [
*   ["ate", "eat","tea"],
*   ["nat","tan"],
*   ["bat"]
* ]
* Note: All inputs will be in lower-case.
*
* public List<List<String>> groupAnagrams(String[] strs)
*/

import java.util.*;

public class GroupAnagrams{
	public static List<List<String>> groupAnagrams(String[] strs){
		List<List<String>> res = new ArrayList<List<String>>();
		if(strs == null || strs.length == 0) return res;
		long[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 47, 53, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107};
		Map<Long, List<String>> map = new HashMap<Long, List<String>>();
		for(int i = 0; i < strs.length; i++){
			long tmp = 1;
			for(int j = 0; j < strs[i].length(); j++) tmp *= primes[strs[i].charAt(j) - 'a'];
			if(!map.containsKey(tmp)) map.put(tmp, new ArrayList<String>());
			map.get(tmp).add(strs[i]);
		}
		for(long i: map.keySet()) res.add(map.get(i));
		return res;
	}
	public static void main(String[] args) {
		//String[] strs = {"tao","pit","cam","aid","pro","dog"};
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs).toString());
	}
}