/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the 
 * sum of the squares of its digits, and repeat the process until 
 * the number equals 1 (where it will stay), or it loops endlessly 
 * in a cycle which does not include 1. Those numbers for which 
 * this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * public boolean isHappy(int n) 
 */

import java.util.*;

public class HappyNumber {
	public boolean isHappy(int n) {
		if (n <= 0) return false;
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(n);
		while (true) {
			int tmp = n;
			n = 0;
			while(tmp != 0) {
				int a  = tmp%10;
				tmp = tmp/10;
				n += a*a;
			}
			if (n == 1) return true;
			else if (visited.contains(n)) return false;
			else visited.add(n);
		}
	}
	public static void main(String[] args) {
		HappyNumber test = new HappyNumber();
		System.out.println(test.isHappy(18));
	}
}