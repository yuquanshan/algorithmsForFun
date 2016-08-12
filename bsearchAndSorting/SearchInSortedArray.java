/**
Given a sorted int array, return an index of an element if found. 
*/
import java.util.*;

public class SearchInSortedArray{
	public static int findItRange(int[] array, int elem, int start, int end){
		if (start == end){
			if (elem == array[start]){
				return start;
			}else{
				return -1;
			}
		}else{
			int mid = (end - start)/2;
			if (elem == array[mid]) {
				return mid;
			}else if (elem > array[mid]){
				return findItRange(array, elem, mid+1, end);
			}else{
				return findItRange(array, elem, start, mid);
			}
		}
	}
	public static void main(String[] args) {
		int[] a = {1,3,5,7,9};
		int ind = findItRange(a, 1, 0, a.length);
		if (ind != -1) {
			System.out.println("The index of 1 is " + new Integer(ind).toString()+".");
		}else{
			System.out.println("Cannot find 1.");
		}
		ind = findItRange(a,0,0,a.length);
		if (ind != -1) {
			System.out.println("The index of 0 is " + new Integer(ind).toString()+".");
		}else{
			System.out.println("Cannot find 0.");
		}
	}
}