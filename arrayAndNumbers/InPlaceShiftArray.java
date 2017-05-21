/** given an array, in-place right-shift it by k
* public int[] inPlaceShift(int[] array)
*/
import java.util.*;

public class InPlaceShiftArray {
	public void inPlaceShift(int[] array, int k) {
		if (array == null || array.length <= 1 || k%array.length == 0) return;
		helper(array, array.length - k, 0);
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

	public void inPlaceShift2(int[] array, int k) {
		if (array == null || array.length <= 1 || k%array.length == 0) return;
		int left = 0, right = array.length - 1;
		while (right > left) {
			int temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
		}
		left = 0; right = k - 1;
		while (right > left) {
			int temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
		}
		left = k; right = array.length - 1;
		while (right > left) {
			int temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
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
