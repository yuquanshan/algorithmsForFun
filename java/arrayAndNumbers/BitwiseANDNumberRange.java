/**
 * given a range of numbers from n to m
 * find the result of all those numbers bitwise AND together
 * public int andAllNums(int n, int m)
 */
import java.util.*;

public class BitwiseANDNumberRange {
	public int andAllNums(int n, int m) {
		if (m < n) return 0;
		int xor = n ^ m;
		if (xor == 0) return n;	// there is only one number
		// try to find the lowest bit n and m start to differ
		int pos = 0;
		while (xor != 0) {
			xor = xor >> 1;
			pos++;
		}
		int acc = 0; 
		while (pos > 0) {
			acc += (1 << (--pos));
		}
		int nn = n & (Integer.MAX_VALUE - acc);
		int mm = m & (Integer.MAX_VALUE - acc);
		return nn;		
	}
	public static void main(String[] args) {
		BitwiseANDNumberRange test = new BitwiseANDNumberRange();
		System.out.println(test.andAllNums(5,6));
	}
}
