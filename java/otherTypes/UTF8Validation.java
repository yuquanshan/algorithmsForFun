/**
* UTF-8 (one to four bytes) is encoded in the following rules. 
* 1. 	for 1-byte character, the first bit is a '0', followed by 
* 		its unicode code.
* 2.	for n-bytes character, the first n-bits are all one's, the 
* 		n+1 bit is 0, followed by n-1 bytes with most significant 
*		2 bits being '10'.
* given an array of integers, return whether it is a valid UTF-8 encoding.
* for example, given data = [197,130,1]. return true. since
* it represents 11000101 10000010 00000001, which is a 2-bytes char followed 
* by a 1-byte char. *only the least significant 8 bits of each integer is used 
* to store data*.
* public static boolean validUtf8(int[] data){}
*/

import java.util.*;

public class UTF8Validation{
	public static boolean validUtf8(int[] data){
		int i = 0;
		while(i<data.length){
			String cur = Integer.toBinaryString(data[i]);
			if(cur.length() < 8)	// an 1-byte char, good and pass
				i++;
			else{
				cur = cur.substring(cur.length()-8,cur.length());
				int j = 0;
				while(cur.charAt(j)== '1'){
					if(j > 3)
						return false;
					j++;
				}
				if(data.length - i < j || j == 1)
					return false;
				int tmp = i;
				for(i = tmp+1; i<tmp+j; i++){
					cur = Integer.toBinaryString(data[i]);
					if(cur.length() < 8)
						return false;
					else{
						cur = cur.substring(cur.length()-8,cur.length());
						if(cur.charAt(0) != '1' || cur.charAt(1) != '0')
							return false;
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[] data = {197, 130, 1};
		if(validUtf8(data))
			System.out.println("valid!");
		else
			System.out.println("not valid!");
	}
}