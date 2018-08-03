/**
 * Given a string s, return all the palindromic permutations 
 * (without duplicates) of it. Return an empty list if no 
 * palindromic permutation could be form.
 *
 * For example:
 * 
 * Given s = "aabb", return ["abba", "baab"].
 *
 * Given s = "abc", return [].
 *
 * public List<String> generatePalindromes(String s)
 */
import java.util.*;

public class PermutePalindromeII {
	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) return res;
		int central = -1; 
		Map<Character, Integer> map = new HashMap<Character, Integer>(256);
		int[] alphabet = new int[256];
		for (char i: s.toCharArray()) {
			alphabet[i]++;
		}
		for (int i = 0; i < 255; i++) {
			if (alphabet[i]/2 > 0) map.put((char)i, alphabet[i]/2);
			if (alphabet[i]%2 == 1) {
				if (central != -1) return res;
				central = i;
			}
		}
		int flag = s.length()%2;
		if (flag == 0 && central != -1 || flag == 1 && central == -1) 
			return res;
		collector(map, res, "", central);
		return res;
	}
	private void collector(Map<Character, Integer> map, List<String> res, 
		String sofar, int central) {
		if (map.size() == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(sofar);
			if (central >= 0) sb.append((char)central);
			for (int i = sofar.length() - 1; i >= 0; i--) 
				sb.append(sofar.charAt(i));
			res.add(sb.toString());
		} else {
			Set<Character> set = new HashSet<Character>(map.keySet());
			for (Character c: set) {
				if (map.get(c) == 1) {
					map.remove(c);
					collector(map, res, sofar + c, central);
					map.put(c, 1);
				} else {
					int tmp = map.get(c);
					map.put(c, tmp - 1);
					collector(map, res, sofar + c, central);
					map.put(c, tmp);
				}
			}
		}
	}
	public static void main(String[] args) {
		PermutePalindromeII test = new PermutePalindromeII();
		System.out.println(test.generatePalindromes("aabb"));
	}
}