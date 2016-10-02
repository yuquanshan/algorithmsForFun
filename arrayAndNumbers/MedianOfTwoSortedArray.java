/**
find median of two sorted array.
public static int findMedian(int[] A, int[] B)
(didn't know how to implement in O(log(A.length+B.length)) for the first time)
*/
import java.util.*;

public class MedianOfTwoSortedArray{
	public static double findMedian(int[] A, int[] B){
		int tolLen = A.length+B.length;
		if(tolLen%2 == 1)
			return findKth(A,0,B,0,(tolLen+1)/2);
		else
			return (findKth(A,0,B,0,tolLen/2)+findKth(A,0,B,0,tolLen/2+1))/2.0;
	}
	public static int findKth(int[] A, int As, int[] B, int Bs,int k){ 	// find the Kth element in A (starting from As) and in B (starting from Bs)
		if(As >= A.length)
			return B[Bs+k-1];
		if(Bs >= B.length)
			return A[As+k-1];
		if(k == 1)
			return Math.min(A[As],B[Bs]);
		if(A[As+k/2-1]<B[Bs+k/2-1]){
			return findKth(A,As+k/2,B,Bs,k-k/2);
		}else{
			return findKth(A,As,B,Bs+k/2,k-k/2);
		}
	}
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5};
		int[] B = {2,3,4,5,6};
		System.out.format("The median of %s and %s is %f.\n",Arrays.toString(A),Arrays.toString(B),findMedian(A,B));
	}
}