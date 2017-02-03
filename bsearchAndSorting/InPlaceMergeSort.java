/**
* implement an in-place merge sort in java, see 
* http://stackoverflow.com/questions/2571049/how-to-sort-in-place-using-the-merge-sort-algorithm
* as a reference.
*/
import java.util.*;

public class InPlaceMergeSort{
	public static void imsort(int[] array, int start, int end){
		if(start+1 == end){
			int tmp = array[start];
			array[start] = array[end];
			array[end] = tmp;
		}else if(end > start+1){
			int halfLen = (end-start+1)/2;
			imsort(array, end-halfLen+1, end);
			int fhLen = (end-start+1)-halfLen;
			int ninoLen = fhLen - fhLen/2;
			int wLen = fhLen/2;		// length of (unsorted) work area, should be smaller or equal than nino half, if smaller then waste
			imsort(array, start, start+ninoLen-1);
			wmerge(array, start, start+ninoLen, start+fhLen, end);
			int remLen = (end-start+1) - (wLen+halfLen);
			while(remLen > 1){
				wLen = remLen/2;
				fhLen = remLen - remLen/2;
				int ss = start+remLen;
				imsort(array, start, start+fhLen-1);
				wmerge(array, start, start+fhLen, ss, end);
				remLen = remLen-wLen;
			}
			if(remLen == 1){
				int pt = start;
				while(pt < end){
					if(array[pt]>array[pt+1]){
						int tmp = array[pt];
						array[pt] = array[pt+1];
						array[pt+1] = tmp;
						pt++;
					}else{
						break;
					}
				}
			}
		}
	}
	private static void wmerge(int[] array, int start, int ws, int start2, int end){	// merge partial result to work area ()
		System.out.format("begining: %s ws:%d we: %d\n", Arrays.toString(array), ws, start2-1);
		int len1 = ws-start;
		int len2 = end - start2 + 1;
		int i = 0;
		int j = 0;
		while(i < len1 && j < len2){
			if(array[start+i] <= array[start2+j])
				swap(array, start+i++, ws++);
			else
				swap(array, start2+j++,ws++);
		}
		while(i<len1 && ws < end)
			swap(array, start+i++, ws++);
		while(j<len2 && ws < end)
			swap(array, start2+j++, ws++);
		System.out.format("ending: %s\n", Arrays.toString(array));
	}
	private static void swap(int[] array, int p1, int p2){
		int tmp = array[p1];
		array[p1] = array[p2];
		array[p2] = tmp;
	}
	public static void main(String[] args) {
		int[] array = {4,3,7,1,5,2,6};
		System.out.format("Original sort is %s.\n",Arrays.toString(array));
		imsort(array, 0, array.length-1);
		System.out.format("Sorted array is %s.\n", Arrays.toString(array));
	}
}