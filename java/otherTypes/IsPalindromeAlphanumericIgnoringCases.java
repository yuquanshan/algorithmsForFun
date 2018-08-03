/** Given a string, determine if it is a palindrome, considering only alphanumeric 
* characters and ignoring cases.
*
* For example,
* "A man, a plan, a canal: Panama" is a palindrome.
* "race a car" is not a palindrome.
*
* Note:
* Have you consider that the string might be empty? This is a good question to ask 
* during an interview.
*
* For the purpose of this problem, we define empty string as valid palindrome.
* 
* public boolean isPalindrome(String s)
*/

public class IsPalindromeAlphanumericIgnoringCases{
	public static boolean isPalindrome(String s){
		if(s == null)
			return true;
		int i = 0;
		int j = s.length() - 1;
		while(i < j){
			char a = process(s.charAt(i));
			char b = process(s.charAt(j));
			if(a == '#')
				i++;
			else if(b == '#')
				j--;
			else{
				if(a != b)
					return false;
				i++;
				j--;
			}
		}
		return true;
	}
	private static char process(char c){
		if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
			return c;
		if(c >= 'A' && c <= 'Z')
			return (char)('a' + c - 'A');
		return '#';
	}
	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(str));
	}
}