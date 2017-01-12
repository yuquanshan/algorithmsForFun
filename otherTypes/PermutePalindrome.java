/** Given a string, determine if a permutation of the string could form a palindrome.
* 
* For example,
* "code" -> False, "aab" -> True, "carerac" -> True.
* 
* public boolean canPermutePalindrome(String s)
*/

public class PermutePalindrome{
	public static boolean canPermutePalindrome(String s){
		if(s == null || s.length() <= 1)
			return true;
		int[] count = new int[256];
		int oddcount = 0;
		for(int i = 0; i<s.length(); i++){
			if(++count[s.charAt(i)]%2 == 1)
				oddcount++;
			else
				oddcount--;
		}
		return oddcount <= 1;
	}
	public static void main(String[] args) {
		String s1 = "code";
		String s2 = "aab";
		if(!canPermutePalindrome(s1))
			System.out.println("Test1 passed!");
		if(canPermutePalindrome(s2))
			System.out.println("Test2 passed!");
	}
}