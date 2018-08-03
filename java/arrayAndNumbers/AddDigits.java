/**
 * Given a non-negative integer num, repeatedly add all its digits 
 * until the result has only one digit.
 * 
 * For example:
 *
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * public int addDigits(int num)
 */

public class AddDigits {
	public int addDigits(int num) {	// a recursive approach
		if (num < 10) return num;
		int tmp = 0;
		while (num != 0) {
			tmp += num%10;
			num = num/10;
		}
		return addDigits(tmp);
	}
	public int addDigits2(int num) {	// number theory: digit root
		return num == 0?0:(1+(num-1)%9);
	}
}