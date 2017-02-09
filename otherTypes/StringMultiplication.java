/** Given two non-negative integers num1 and num2 represented as strings, 
* return the product of num1 and num2.
*
* Note:
*
* The length of both num1 and num2 is < 110.
* Both num1 and num2 contains only digits 0-9.
* Both num1 and num2 does not contain any leading zero.
* You must not use any built-in BigInteger library or convert the inputs to integer directly.
*
* public String multiply(String num1, String num2)
*/
import java.util.*;

public class StringMultiplication{
	public static String multiply(String num1, String num2){
		if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
			return "0";
		final int k = 220;
		int[] array = new int[k];
		int len1 = num1.length();
		int len2 = num2.length();
		for(int i = num2.length() - 1; i >= 0; i--){
			for(int j = num1.length() - 1; j >= 0; j--){
				int start = k - (len2 - i + len1 - j - 1);
				int a = num1.charAt(j) - '0';
				int b = num2.charAt(i) - '0';
				int tmp = array[start] + a*b;
				array[start] = tmp%10;
				tmp = tmp/10;
				while(tmp != 0){
					int mid = array[--start] + tmp;
					tmp = mid/10;
					array[start] = mid%10;
				}
			}
		}
		int s = 0;
		StringBuilder sb = new StringBuilder();
		while(s < k && array[s] == 0) s++;
		if(s == k)
			return "0";
		for(int i = s; i < k; i++)
			sb.append(array[i]);
		return sb.toString();
	}
	public static void main(String[] args) {
		String num1 = "9";
		String num2 = "9";
		System.out.println(multiply(num1, num2));
	}
}