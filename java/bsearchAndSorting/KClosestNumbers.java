/**
* given a sorted array and a target, return k numbers in the array which
* are the closest to the target in ascending order. 
* public int[] kClosest(int[] A, int target, int k)
*/
import java.util.*;
public class KClosestNumbers{
	public static int[] kClosest(int[] A, int target, int k){
		int[] res = new int[k];
		if(A == null || A.length<k || k<1)
			return res;
		if(A.length == 1){
			res[0] = A[0];
			return res;
		}
		int start = 0;
		int end = A.length-1;
		while(end - start > 1){
			int mid = start + (end-start)/2;
			if (A[mid] == target) {
				start = mid;
				break;
			}else if(A[mid]< target){
				start = mid;
			}else{
				end = mid;
			}
		}
		int left = start;
		int right = start+1;	// we don't worry index OutOfBound exception because of A.length==1 statement
		int countdown = k;
		while(countdown != 0 && left >= 0 && right <= A.length-1){
			if (A[right]-target >= target - A[left]) {
				res[k-countdown] = A[left];
				left--;
				countdown = countdown-1;
			}else{
				res[k-countdown] = A[right];
				right++;
				countdown = countdown-1;
			}
		}
		int countsofar = countdown;
		if(left < 0){
		    for(int i = right; i<right+countsofar;i++){
		        res[k-countdown] = A[i];
		        countdown--;
		    }
		}
		if(right > A.length-1){
		    for(int i = left; i>left-countsofar;i--){
		        res[k-countdown] = A[i];
		        countdown--;
		    }
		}
		return res;
	}
	public static void main(String[] args) {
		int[] array = {1,2,3};
		int t = 2;
		int k = 3;
		int[] res = kClosest(array,t,k);
		System.out.println(Arrays.toString(res));
	}
}