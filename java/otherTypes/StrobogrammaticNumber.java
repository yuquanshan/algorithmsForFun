/* A strobogrammatic number is a number that looks the same 
* when rotated 180 degrees (looked at upside down).
* Write a function to determine if a number is strobogrammatic. 
* The number is represented as a string.
* For example, the numbers "69", "88", and "818" are all strobogrammatic.
* public boolean isStrobogrammatic(String num)
*/
import java.util.*;

public class StrobogrammaticNumber{
	public static boolean isStrobogrammatic(String num){
		if(num == null || num.length() == 0)
			return true;
		HashMap<Character, Character> smap = new HashMap<Character, Character>();
		smap.put('6','9'); smap.put('9','6');
		smap.put('0','0'); 
		smap.put('1','1');
		smap.put('8','8');
		int start = 0;
		int end = num.length()-1;
		while(start <= end){
			if(!smap.containsKey(num.charAt(start)) || num.charAt(end) != smap.get(num.charAt(start)))
				return false;
			start++; end--;
		}
		return true;
	}
	public static void main(String[] args) {
		String num = "86198";
		if(isStrobogrammatic(num))
			System.out.println("Test1 passed!");
		num = "81318";
		if(!isStrobogrammatic(num))
			System.out.println("Test2 passed!");
	}
}