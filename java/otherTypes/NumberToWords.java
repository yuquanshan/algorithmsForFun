/** Convert a non-negative integer to its english words representation. 
* Given input is guaranteed to be less than 231 - 1.
*
* For example,
* 123 -> "One Hundred Twenty Three"
* 12345 -> "Twelve Thousand Three Hundred Forty Five"
* 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
* public String numberToWords(int num)
*/
import java.util.*;

public class NumberToWords{
	public static String numberToWords(int num){
		if(num == 0)
			return "Zero";
		String[] map = new String[100];
		map[1] = "One"; map[2] = "Two"; map[3] = "Three";
		map[4] = "Four"; map[5] = "Five"; map[6] = "Six";
		map[7] = "Seven"; map[8] = "Eight"; map[9] = "Nine";
		map[10] = "Ten"; map[11] = "Eleven"; map[12] = "Twelve";
		map[13] = "Thirteen"; map[14] = "Fourteen"; map[15] = "Fifteen";
		map[16] = "Sixteen"; map[17] = "Seventeen"; map[18] = "Eighteen";
		map[19] = "Nineteen"; map[20] = "Twenty"; map[30] = "Thirty";
		map[40] = "Forty"; map[50] = "Fifty"; map[60] = "Sixty";
		map[70] = "Seventy"; map[80] = "Eighty"; map[90] = "Ninety";
		String[] unit = new String[4];
		unit[0] = ""; unit[1] = " Thousand"; unit[2] = " Million"; unit[3] = " Billion";
		Stack<String> stack = new Stack<String>();
		while(num != 0){
			int rem = num % 1000;
			num = num / 1000;
			stack.push(threeNumbersToWords(rem, map));
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			String item = stack.pop();
			if(!item.equals("null") && item.length() > 0){
				if(sb.length() > 0)
					sb.append(" ");
				sb.append(item + unit[stack.size()]);
			}
		}
		return sb.toString();
	}
	private static String threeNumbersToWords(int num, String[] map){
		StringBuilder sb = new StringBuilder();
		int h = num / 100;
		num = num % 100;
		if(h > 0)
			sb.append(map[h] + " Hundred");
		if(num == 0)
			return sb.toString();
		if(h > 0) sb.append(" ");
		if(num <= 20)
			sb.append(map[num]);
		else{
			sb.append(map[10 * (num / 10)]);
			if(num % 10 > 0)
				sb.append(" " + map[num % 10]);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		int num = 1000;
		System.out.println(numberToWords(num));
	}
}