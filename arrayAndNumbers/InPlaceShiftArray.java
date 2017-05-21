/** given an array, in-place shift it by k
* public int[] inPlaceShift(int[] array)
*/
import java.util.*;

public class InPlaceShiftArray {
	public void inPlaceShift(int[] array, int k) {
		if (array == null || array.length <= 1 || k == 0) return;
		helper(array, k, 0);
	}
	private void helper(int[] array, int k, int start) {
		int len = array.length - start;
		k = k%len;
		if (k == 0 || start >= array.length - 1) return;
		int rem = len - k;
		int pt1 = start;
		int pt2 = start + k;
		while (pt1 - start < Math.min(rem, k)) {
			int tmp = array[pt2];
			array[pt2++] = array[pt1];
			array[pt1++] = tmp;
		}
		if (rem > k) {	
			helper(array, k, start + k);
		} else {
			helper(array, k - rem, start + rem);
		}
	}
	public static void main(String[] args) {
		InPlaceShiftArray test = new InPlaceShiftArray();
		int[] array = {1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(array));
		test.inPlaceShift(array, 5);
		System.out.println(Arrays.toString(array));
	}
}
