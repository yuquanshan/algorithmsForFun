/**
* merge two sorted arrays, assume array A has m elements and 
* n extra empty spaces, B has n elements.
*public static void merge(int[] A, int m, int[] B, int n)
* (didn't realize how to do that in place in the first time!)
*/
import java.util.*;

public class InPlaceMergeTwoSortedArray{
	public static void merge(int[] A, int m, int[] B, int n){
		if(m > 0 && n > 0){
			int s = m+n;
			while(s>0){
				if(m == 0){
					A[s-1] = B[n-1];
					n -= 1;
					s -= 1;
				}else if(n == 0){
					A[s-1] = A[m-1];
					m -= 1;
					s -= 1;
				}else if(A[m-1] >= B[n-1]){
					A[s-1] = A[m-1];
					s -= 1;
					m -= 1;
				}else{
					A[s-1] = B[n-1];
					s -= 1;
					n -= 1;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] A = {1,2,6,0,0};
		int[] B = {4,5};
		int m = 3;
		int n = 2;
		merge(A, m, B, n);
		System.out.println(Arrays.toString(A));
	}
}
