/** Given two strings S and T, determine if they are both one edit distance apart.
* 
* public boolean isOneEditDistance(String s, String t)
*/
import java.util.*;

public class OneEditDistance{
	public static boolean isOneEditDistance(String s, String t){
		if(s == null || s.length() == 0)
			return (t != null) && (t.length() == 1);
		if(t == null || t.length() == 0)
			return (s != null) && (s.length() == 1);
		if(Math.abs(s.length() - t.length()) > 1)
			return false;
		if(s.length() == t.length()){	// if one edit, must be substitution
			boolean modified = false;
			for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) != t.charAt(i)){
					if(modified == true) return false;
					else modified = true;
				}
			}
			return modified;
		}else{	// if one edit, must be deletion
			int i = 0, j = 0;
			int flag = (s.length() > t.length())?0:1;
			while(i < s.length() && j < t.length()){
				if(s.charAt(i) != t.charAt(j)){
					if(i != j) return false;
					else{
						if(flag == 0){j--;}
						else {i--;}
					}
				}
				i++;
				j++;
			}
			return true;
		}
	}
	public static void main(String[] args) {
		String s = "ab";
		String t = "acd";
		System.out.println(isOneEditDistance(s, t));
	}
}