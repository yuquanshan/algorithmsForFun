/** Given a non-empty string s and an abbreviation abbr, 
* return whether the string matches with the * given abbreviation.
* A string such as "word" contains only the following valid abbreviations:
* 
* ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", 
* "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
* Notice that only the above abbreviations are valid abbreviations of the 
* string "word". Any other string is not a valid abbreviation of "word".
* 
* Note:
* Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
* 
* Example 1:
* Given s = "internationalization", abbr = "i12iz4n":
* Return true.
* Example 2:
* Given s = "apple", abbr = "a2e":
* Return false.
* public boolean validWordAbbreviation(String word, String abbr)
*/
import java.util.*;

public class ValidWordAbbreviation{
	public static boolean validWordAbbreviation(String word, String abbr){
		int i = 0, j = 0;
		while(i<word.length() && j < abbr.length()){
			if(abbr.charAt(j)>='0' && abbr.charAt(j)<='9'){
				String s = "";
				if(abbr.charAt(j) == '0')
					return false;
				while(j < abbr.length() && abbr.charAt(j)>='0' && abbr.charAt(j)<='9'){
					s = s+abbr.charAt(j);
					j++;
				}
				i = i+Integer.parseInt(s);
			}else{
				if(abbr.charAt(j)!=word.charAt(i))
					return false;
				else{
					i++; j++;
				}
			}
		}
		if(word.length() != i || abbr.length() != j)
			return false;
		return true;
	}
	public static void main(String[] args) {
		String s = "internationalization", abbr = "i12iz4n";
		if(validWordAbbreviation(s,abbr))
			System.out.println("Test1 passed!");
		s = "apple"; abbr = "a2e";
		if(!validWordAbbreviation(s,abbr))
			System.out.println("Test2 passed!");
	}
}