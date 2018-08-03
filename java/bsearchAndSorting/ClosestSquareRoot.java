/**
 * find the closest integer to the square root of another integer
 * 
 * public int closestSqrt(int k)
*/

public class ClosestSquareRoot {
	public int closestSqrt(int k) {
		if (k < 0) return 0;
		int left = 0;
		int right = k;
		while(right - left > 1) {
			int mid = left + (right - left)/2;
			if (mid*mid == k) return mid;
			else if (mid*mid > k) right = mid;
			else left = mid;
		}
		if (k - left*left > right*right - k) return right;
		else return left; 
	}
	public static void main(String[] args) {
		ClosestSquareRoot test = new ClosestSquareRoot();
		System.out.println(test.closestSqrt(10));
	}
}