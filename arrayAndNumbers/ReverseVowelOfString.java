/* Write a function that takes a string as input and reverse only the vowels of a string.
*
* Example 1:
* Given s = "hello", return "holle".
*
* Example 2:
* Given s = "leetcode", return "leotcede".
*
* public String reverseVowels(String s)
*/
import java.util.*;

public class ReverseVowelOfString{
	public static String reverseVowels(String s){
		if(s == null || s.length() == 0)
			return s;
		int start = 0, end = s.length()-1;
		char[] charArray = s.toCharArray();
		Set<Character> vowels = new HashSet<Character>();
		vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
		vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');
		while(start < end){
			if(vowels.contains(charArray[start]) && vowels.contains(charArray[end])){
				char a = charArray[start];
				charArray[start] = charArray[end];
				charArray[end] = a;
				start++; end--;
			}else if(!vowels.contains(charArray[start])){
				start++;
			}else{
				end--;
			}
		}
		return new String(charArray);
	}
	public static void main(String[] args) {
		String s = "leetcode";
		String res = reverseVowels(s);
		System.out.format("Given %s, we have %s\n", s, res);
	}
}