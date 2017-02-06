/** Given a non-negative integer num represented as a string, 
* remove k digits from the number so that the new number is 
* the smallest possible.
*
* Note:
* The length of num is less than 10002 and will be ≥ k.
* The given num does not contain any leading zero.
* Example 1:
* 
* Input: num = "1432219", k = 3
* Output: "1219"
* Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 
* which is the smallest.
* Example 2:
* Input: num = "10200", k = 1
* Output: "200"
* Explanation: Remove the leading 1 and the number is 200. Note that the output 
* must not contain leading zeroes.
* Example 3:
* Input: num = "10", k = 2
* Output: "0"
* Explanation: Remove all the digits from the number and it is left with nothing which is 0.
* public String removeKdigits(String num, int k)
*/
import java.util.*;

public class RemoveKDigits{
	public static String removeKdigits(String num, int k){
		if(num.length() <= k)
			return "0";
		int len = num.length()-k;
		int size = 0;
		Deque<Integer> stack = new LinkedList<Integer>();
		for(int i = 0; i<num.length(); i++){
			int tmp = Character.getNumericValue(num.charAt(i));
			while(!stack.isEmpty() && stack.peekLast() > tmp && size+num.length()-i-1 >= len){
				stack.removeLast();
				size--;
			}
			if(size<len){
				stack.addLast(tmp);
				size++;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(stack.removeFirst());
		}
		String res = sb.toString();
		int i = 0;
		while(i < res.length() && res.charAt(i) == '0')
			i++;
		if(i == res.length())
			return "0";
		else
			return res.substring(i);
	}
	public static void main(String[] args) {
		String num = "10200";
		int k = 1;
		System.out.println(removeKdigits(num, k));
	}
}