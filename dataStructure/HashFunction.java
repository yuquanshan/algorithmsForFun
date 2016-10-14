/**
* write a 33-based hash function to calculate the hash code
* of a character array. hash = /sum_{i=0}^{n}char[0]*33^{n-1-i}%HASH_SIZE
* public int hashCode(char[] key,int HASH_SIZE)
*/
import java.util.*;

public class HashFunction{
	public static int hashCode(char[] key,int HASH_SIZE){
		if(key == null || key.length==0)
			return 0;
		long res = (int)key[0];
		for(int i = 1; i < key.length; i++){
			res = (res*33+(int)key[i])%HASH_SIZE;
		}
		return (int)res;
	}
	public static void main(String[] args) {
		int HASH_SIZE = 2324141;
		char[] key = {'a','b'};
		System.out.format("The char array is %s, it's hash code is %d.\n",Arrays.toString(key),hashCode(key,HASH_SIZE));
	}
}