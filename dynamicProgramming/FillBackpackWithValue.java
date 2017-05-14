/**
* given n items with different sizes and values, how much value can you fill in a backpack?
*/
import java.util.*;
// achieving O(m) space
public class FillBackpackWithValue{
	public static int fill(int m, int[] A, int[] V){
		if(A == null || A.length == 0 || m==0){
			return 0;
		}
		int n = A.length;
		int[] array1 = new int[m+1];
		int[] array2 = new int[m+1];
		int toggle = 0;
		for(int i = 0; i < m+1; i++)
			array1[i] = 0;
		for(int i = 1; i <= n; i++){
			if(toggle == 0){
				toggle = 1;
				array2[0] = 0;
				for(int j = 1; j<= m; j++){
					if(A[i-1]<=j){
						array2[j] = Math.max(array1[j],array1[j-A[i-1]]+V[i-1]);
					}else{
						array2[j] = array1[j];	// can't fill with ith item in bag with capacity j
					}
				}
			}else{
				toggle = 0;
				array1[0] = 0;
				for(int j = 1; j<=m; j++){
					if(A[i-1]<=j){
						array1[j] = Math.max(array2[j],array2[j-A[i-1]]+V[i-1]);
					}else{
						array1[j] = array2[j];
					}
				}
			}
		}
		if(n%2 == 1)
			return array2[m];
		else
			return array1[m];
	}
	public static void main(String[] args) {
		int[] A = {2,3,5,7};
		int[] V = {1,5,2,4};
		int m = 10;
		System.out.println("Item size: "+Arrays.toString(A));
		System.out.println("Item value: "+Arrays.toString(V));
		System.out.println("Bag size: "+m);
		System.out.println("The maximum value which can be filled is "+fill(m,A,V));
	}
}