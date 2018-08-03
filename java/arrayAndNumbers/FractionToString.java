/** Given two integers representing the numerator and denominator of a fraction, 
* return the fraction in string format.
* 
* If the fractional part is repeating, enclose the repeating part in parentheses.
* 
* For example,
* 
* Given numerator = 1, denominator = 2, return "0.5".
* Given numerator = 2, denominator = 1, return "2".
* Given numerator = 2, denominator = 3, return "0.(6)".
* 
* public String fractionToDecimal(int numerator, int denominator)
*/
import java.util.*;

public class FractionToString{
	public static String fractionToDecimal(int numerator, int denominator){
		StringBuilder sb = new StringBuilder();
		int sign = 0;
		long num = (long)numerator;
		long den = (long)denominator;
		if(num < 0){
			num = -num; sign++;
		}
		if(den < 0){
			den = -den; sign++;
		}
		String sg = (sign%2 == 0)?"":"-";
		long decPart = num/den;
		num = num%den;
		//System.out.println(decPart);
		if(num == 0){
			if(decPart == 0)
				return Long.toString(decPart);
			else
				return sg+Long.toString(decPart);
		}
		HashMap<Long, Integer> map = new HashMap<Long, Integer>(); // number to position
		num *= 10;
		int count = 0;
		while(num != 0 && !map.containsKey(num)){
			while(num < den){
				sb.append('0');
				map.put(num, count);
				num *= 10;
				count++;
			}
			map.put(num, count);
			sb.append(num/den);
			count++;
			num = (num%den)*10;
		}
		if(num == 0)
			return sg+Long.toString(decPart)+'.'+sb.toString();
		String frac = sb.toString();
		int pos = map.get(num);
		return sg+Long.toString(decPart)+'.'+frac.substring(0,pos)+'('+frac.substring(pos)+')';
	}
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-2147483648,1));
	}
}