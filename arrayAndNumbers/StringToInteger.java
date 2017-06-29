/** 
* Implement atoi to convert a string to an integer.
*
* Hint: Carefully consider all possible input cases. 
* If you want a challenge, please do not see below and 
* ask yourself what are the possible input cases.
*
* Notes: It is intended for this problem to be specified 
* vaguely (ie, no given input specs). You are responsible 
* to gather all the input requirements up front.
*
* public int myAtoi(String str)
*/

public class StringToInteger {
	public int myAtoi(String str) {
		if (str == null || str.length() == 0) return 0;
		String max = Integer.toString(Integer.MAX_VALUE);
		String min = Integer.toString(Integer.MIN_VALUE).substring(1);
		int count = 0;
		while (str.charAt(count) == ' ') count++;
		str = str.substring(count);
		if (str.length() == 0) return 0;
		StringBuilder sb = new StringBuilder();
		if ((str.charAt(0) < '0' || str.charAt(0) > '9') && 
			str.charAt(0) != '+' && str.charAt(0) != '-') return 0;
		sb.append(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
			sb.append(str.charAt(i));
		}
		str = sb.toString();
		if (str.charAt(0) == '-') {
			str = str.substring(1);
			if (str.length() > 10) return Integer.MIN_VALUE;
			int res = 0;
			boolean alert = true;
			for (int i = 0; i < str.length(); i++) {
				if (alert && str.length() == 10) {
					if (str.charAt(i) > min.charAt(i)) return Integer.MIN_VALUE;
					else if (str.charAt(i) < min.charAt(i)) alert = false;
				}
				res = res*10 + str.charAt(i) - '0';
			}
			return -res;
		} else {
			if (str.charAt(0) == '+') str = str.substring(1);
			if (str.length() > 10) return Integer.MAX_VALUE;
			int res = 0;
			boolean alert = true;
			for (int i = 0; i < str.length(); i++) {
				if (alert && str.length() == 10) {
					if (str.charAt(i) > max.charAt(i)) return Integer.MAX_VALUE;
					else if (str.charAt(i) < max.charAt(i)) alert = false;
				}
				res = res*10 + str.charAt(i) - '0';
			}
			return res;
		}
	}
	public static void main(String[] args) {
		StringToInteger test = new StringToInteger();
		System.out.println(test.myAtoi(Integer.toString(Integer.MIN_VALUE)));
		System.out.println(test.myAtoi("   -1123u3761867"));
	}
}