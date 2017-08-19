/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * public int countPrimes(int n)
 *
 */

import java.util.*;

public class CountPrimes {
	public int countPrimes(int n) { 	// TLE solution
		if (n < 2) return 0;
		int[] array = new int[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i, array, count)) {
				array[count++] = i;
			}
		}
		return count;
	}
	private boolean isPrime(int n, int[] array, int count) {
		for (int i = 0; i < count; i++) {
			if (n == array[i]*(n/array[i])) return false;
			if (array[i]*array[i] > n) break;
		}
		return true;
	}
	public int countPrimes2(int n) { // Sieve of Eratosthenes
		if (n <= 1) return 0;
        boolean[] array = new boolean[n+1];
		int i = 2;
		int notp = 0;
		while(i*i <= n - 1) {
			if (!array[i]) {
				int j = i;
				while (i*j <= n -1) {
					if (!array[i*j]) {
						notp++;
						array[i*j] = true;
					}
					j++;
				}
			}
			i++;
		}
		return n - 2 - notp;
	}
	public static void main(String[] args) {
		CountPrimes test = new CountPrimes();
		System.out.println(test.countPrimes(1500000));
	}
}