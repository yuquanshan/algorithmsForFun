/**
* given an array of integers, return the number of all three combinations 
* that construct edges of a triangle, i.e., satisfy triangle inequality.
* public static int triangleCount(int S[])
* (don't know why it's a hard problem...)
*/
import java.util.*;

public class TriangleEdges{
	public static int triangleCount(int S[]){
		if(S == null || S.length<3)
			return 0;
		int count = 0;
		Arrays.sort(S);
		for(int i = 0; i<S.length-2; i++){
			for(int j = i+1; j<S.length-1; j++){
				int start = j+1;
				int end = S.length-1;
				while(end - start > 1){
					int mid = start + (end-start)/2;
					if(S[mid]>=S[i]+S[j])
						end = mid;
					else
						start = mid;
				}
				if(S[end]<S[i]+S[j]){
					count+=end-j;
				}else if(S[start]<S[i]+S[j]){
					count+=start-j;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[] S = {1,2,3,4,5,6,7};
		System.out.format("Given %s, the number of triangle-qualified combs is %d.\n",Arrays.toString(S),triangleCount(S));
	}
}