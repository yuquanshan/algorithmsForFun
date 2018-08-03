/**
* sort letters with both lower and uppercase.
* try to do it one-pass and in-place.
* public static void sortLetters(char[] chars)
*/

import java.util.*;

public class SortLetters{
	public static void sortLetters(char[] chars){
		if(chars!=null && chars.length>1){
			int start = 0;
			for(int i = 97; i<=122; i++){
				int j = start;
				while(j< chars.length){
					if(chars[j]<97 || chars[j]>i){
						j++;
					}else{
						chars[j] = chars[start];
						chars[start] = (char)i; 
						start++;
						j++;
					}
				}
			}
			for(int i = 65; i<=90; i++){
				int j = start;
				while(j<chars.length){
					if(chars[j]>=97 || chars[j]>i){
						j++;
					}else{
						chars[j] = chars[start];
						chars[start] = (char)i;
						start++;
						j++;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		char[] chars = {'a','b','A','c','D'};
		System.out.format("The array is %s.\n",Arrays.toString(chars));
		sortLetters(chars);
		System.out.format("The sorted array is %s.\n",Arrays.toString(chars));
	}
}