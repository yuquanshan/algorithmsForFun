/**
given a string s and a dictionary of words,
determine if that string can be break into a space-separated
sequence of dictionary words.
*/

// dumb implementation, slow and memory consuming...
import java.util.*;

public class WordBreak{
	public static boolean breakable(String s, Set<String> dict){
		if(s == null || s.length() == 0)
			return true;
		boolean[] array = new boolean[s.length()+1]; // array[i]: if s[0:i] breakable
		array[0] = true;
		int dictLen = getMaxLen(dict);
		for(int i = 1; i<=s.length(); i++){
		    array[i] = false;
			for(int j = i; j >=Math.max(1,i-dictLen); j--){
				if(array[j-1]==true && dict.contains(s.substring(j-1,i))){
					array[i] = true;
					break;
				}
			}
			
		}
		return array[s.length()];
	}
	public static int getMaxLen(Set<String> dict){
		int tmpMax = 0;
		for(String i: dict){
			if(i.length()>tmpMax)
				tmpMax = i.length();
		}
		return tmpMax;
	}
	public static void main(String[] args) {
		Set<String> hashset = new HashSet<String>();
		hashset.add("a");
		//hashset.add("b");
		//hashset.add("abc");
		//hashset.add("cd");
		String s = "a";
		if(breakable(s,hashset))
			System.out.println(s+" is breakable.");
		else
			System.out.println(s+" is not breakable.");
	}
}