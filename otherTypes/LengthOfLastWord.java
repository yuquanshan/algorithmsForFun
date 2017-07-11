/**
 * Given a string s consists of upper/lower-case alphabets and 
 * empty space characters ' ', return the length of last word 
 * in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists 
 * of non-space characters only.
 *
 * For example, 
 * Given s = "Hello World",
 * return 5.
 *
 * public int lengthOfLastWord(String s)
 */

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null && s.length() == 0) return 0;
		String[] array = s.split(" ");
		if (array.length == 0) return 0;
		return array[array.length - 1].length();
	}
	public static void main(String[] args) {
		LengthOfLastWord test = new LengthOfLastWord();
		System.out.println(test.lengthOfLastWord(" "));
	}
}