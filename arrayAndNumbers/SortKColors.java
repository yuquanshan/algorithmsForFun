/**
given k colors (1,2,3,...,k), and an array of colors, sort them in 
the order of 1,2,3,...,k.
public static void sortColors(int[] colors, int k)
(didn't realize there is another more space efficient and quick way 
to sort in the first time)
*/
import java.util.*;

public class SortKColors{
	public static void inplaceSort(int[] colors, int k){
		if(colors != null && colors.length > 1){
			int start = 0;
			for(int i = 1; i <= k; i++){
				for(int j = start; j<colors.length; j++){
					if(colors[j]==i){
						colors[j] = colors[start];
						colors[start] = i;
						start++;
					}
				}
			}
		}
	}

	public static void coutingSort(int[] colors, int k){
		if(colors != null && colors.length > 1){
			int[] bucket = new int[k];
			for(int i: colors){
				bucket[i-1]++;
			}
			int pt = 0;
			for(int i=0; i<k; i++){
				for(int j = 0; j < bucket[i]; j++){
					colors[pt] = i+1;
					pt++;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] colors = {3,2,2,1,4};
		int k = 4;
		System.out.format("Current colors are %s.\n",Arrays.toString(colors));
		inplaceSort(colors,k);
		System.out.format("In-place sort result is %s.\n",Arrays.toString(colors));
		int[] colors1 = {3,2,2,1,4};
		coutingSort(colors1,k);
		System.out.format("Couting sort result is %s.\n",Arrays.toString(colors1));
	}
}