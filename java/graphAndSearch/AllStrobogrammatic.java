/* A strobogrammatic number is a number that looks the same when rotated 180 degrees 
* (looked at upside down).
* Find all strobogrammatic numbers that are of length = n.
* For example,
* Given n = 2, return ["11","69","88","96"].
*/
import java.util.*;

public class AllStrobogrammatic{
	public static List<String> allstrob(int n){
		if(n <= 0)
			return null;
		List<String> res = new ArrayList<String>();
		char[] str = new char[n];
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		map.put('0','0');
		map.put('1','1'); 
		map.put('6','9'); map.put('9','6');
		map.put('8','8');
		dfs(0, n-1, str, res, map);
		return res;
	}
	public static void dfs(int start, int end, char[] str, List<String> res, HashMap<Character,Character> map){
		if(start == end){
			str[start] = '0';
			res.add(new String(str));
			str[start] = '1';
			res.add(new String(str));
			str[start] = '8';
			res.add(new String(str));
		}else if(start > end){
			res.add(new String(str));
		}else{
			for(char d: map.keySet()){
				if(start != 0 || d != '0'){
					str[start] = d;
					str[end] = map.get(d);
					dfs(start+1, end-1, str, res, map);
				}
			}
		}
	}
	public static void main(String[] args) {
		int n = 2;
		System.out.format("all length-%d strobogrammatic numbers are: %s\n", n, allstrob(n).toString());
	}
}