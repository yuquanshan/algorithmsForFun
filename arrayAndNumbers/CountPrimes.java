/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * public int countPrimes(int n)
 *
 */

public class CountPrimes {
	public int countPrimes(int n) {
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
			if (i*i > n) break;
		}
		return true;
	}
	public static void main(String[] args) {
		CountPrimes test = new CountPrimes();
		System.out.println(test.countPrimes(1500000));
	}
}