/**
* given an array, each elements in the array indicates the maximum jump distance 
* from that position. determine if you can jump from the first position to the last position.
* public boolean canJump(int[] A)
*/


// can use greedy algorithm with complexity O(n), which is better than dynamic programming.
import java.util.*;

public class JumpGameReachable{
	public static boolean canJump(int[] A){
		if(A.length <= 1)
			return true;
		int sentinel = A.length-1;	// the min index that can reach the last position, if you can jump over sentinel, you are good to go
		for(int i = A.length-2; i>=0; i--){
			if(i+A[i] >= sentinel)
				sentinel = i;
		}
		return (sentinel==0);
	}
	public static void main(String[] args) {
		int[] array1 = {2,3,1,1,4};
		int[] array2 = {3,2,1,0,4};
		System.out.println("First array is "+Arrays.toString(array1)+".");
		if(canJump(array1))
			System.out.println("You can jump from first to last.\n");
		else
			System.out.println("You can't jump from first to last.\n");
		System.out.println("Second array is "+Arrays.toString(array2)+".");
		if(canJump(array2))
			System.out.println("You can jump from first to last.");
		else
			System.out.println("You can't jump from first to last.");
	}
}