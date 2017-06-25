/* Reverse digits of an integer.
*
* Example1: x = 123, return 321
* Example2: x = -123, return -321
*
* Note:
* The input is assumed to be a 32-bit signed integer. 
* Your function should return 0 when the reversed integer overflows.
*
* public int reverse(int x)
*/

public class ReverseAnInteger {
	public int reverse(int x) {
		String str;
		if (x >= 0) str = Integer.toString(x);
		else str = Integer.toString(x).substring(1);
		String max = Integer.toString(Integer.MAX_VALUE);
		String min = Integer.toString(Integer.MIN_VALUE).substring(1);
		int len = str.length();
		StringBuilder sb = new StringBuilder();
		boolean flag = len == 10;
		if (x > 0) {
			for (int i = 0; i < len; i++) {
				if (flag && max.charAt(i) < str.charAt(len - 1 - i)) return 0;
				else if (max.charAt(i) == str.charAt(len - 1 - i)){
					sb.append(str.charAt(len - 1 - i));
				}else {
					sb.append(str.charAt(len - 1 - i));
					flag = false;
				}
			}
		}else {
			sb.append('-');
			for (int i = 0; i < len; i++) {
				if (flag && min.charAt(i) < str.charAt(len - 1 - i)) return 0;
				else if (min.charAt(i) == str.charAt(len - 1 - i)){
					sb.append(str.charAt(len - 1 - i));
				}else {
					sb.append(str.charAt(len - 1 - i));
					flag = false;
				}
			}
		}
		return Integer.parseInt(sb.toString());
	}

	public int reverse2(int x){	// shorter solution with try-catch clause
		String str = Integer.toString(x);
		if (x < 0) str = str.substring(1);
		StringBuilder sb = new StringBuilder();
		int l = str.length();
		for (int i = 0; i < l; i++) sb.append(str.charAt(l - 1 -i));
		int res = 0;
		try {
			res = Integer.parseInt(sb.toString());
			if (x < 0) res = -res;
		}catch(Exception e) {
			return 0;
		}
		return res;
	}

	public static void main(String[] args) {
		ReverseAnInteger test = new ReverseAnInteger();
		System.out.println(test.reverse2(100));
		System.out.println(test.reverse2(-2147483412));
	}
}