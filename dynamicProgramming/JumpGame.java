/**
given an array, each element in the array represent the maximum distance 
you can jump from that position. how to jump from the frist position of 
the array to the last position of the array with the minimum number of jumps.
*/
import java.util.*;

public class JumpGame{
	public static int jump(int[] A){
		if(A.length == 0)
			return 0;
		int last = A.length-1;	// last index
		A[last] = 0;	// in case there is only one element
		for(int i=last-1; i>=0; i--){
			if(A[i]>=last - i){
				A[i] = 1;
			}else if(A[i] == 0){
				A[i] = Integer.MAX_VALUE;
			}else{
				int min = Integer.MAX_VALUE;
				for(int j=i+1; j<=i+A[i]; j++){
					if(A[j]!=Integer.MAX_VALUE && A[j]+1<min)
						min = A[j]+1;
				}
				A[i] = min;
			}
		}
		return A[0];
	}
	public static void main(String[] args) {
		int[] array  = {2,3,1,1,4};
		System.out.println("The array is "+Arrays.toString(array)+".");
		System.out.format("The min number of jumps from first to last is %d.\n",jump(array));
	}
}