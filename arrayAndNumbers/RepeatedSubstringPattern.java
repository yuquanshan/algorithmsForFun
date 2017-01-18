/** Given a non-empty string check if it can be constructed by 
* taking a substring of it and appending multiple copies of the 
* substring together. You may assume the given string consists 
* of lowercase English letters only and its length will not exceed 10000.
*
* Example 1:
* Input: "abab"
* Output: True
* Explanation: It's the substring "ab" twice.
*
* Example 2:
* Input: "aba"
* Output: False
*
* Example 3:
* Input: "abcabcabcabc"
* Output: True
* Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
* public boolean repeatedSubstringPattern(String str)
*/

public class RepeatedSubstringPattern{
	public static boolean repeatedSubstringPattern(String str){
		int[] pi = kmp(str);
		return str.length()>0 && pi[str.length()-1] > 0 && str.length()%(str.length()-pi[str.length()-1]) == 0;
	}
	private static int[] kmp(String str){
		int[] res = new int[str.length()];
		res[0] = 0;
		for(int i = 1; i<str.length(); i++){
			int mlen = res[i-1];
			while(mlen > 0 && str.charAt(i) != str.charAt(mlen))
				mlen = res[mlen-1];
			if(str.charAt(i) == str.charAt(mlen))
				mlen++;
			res[i] = mlen;
		}
		return res;
	}
	public static void main(String[] args) {
		String str = "abcabcabcabc";
		if(repeatedSubstringPattern(str))
			System.out.println("Good!");
		else
			System.out.println("Bad!");
	}
}