/** Given a string, sort it in decreasing order based on the frequency of characters.
*
* Example 1:
* 
* Input:
* "tree" 
* Output:
* "eert"
* Explanation:
* 'e' appears twice while 'r' and 't' both appear once.
* So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
* 
* Example 2:
* Input:
* "cccaaa"
* Output:
* "cccaaa"
* Explanation:
* Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
* Note that "cacaca" is incorrect, as the same characters must be together.
*
* Example 3:
* Input:
* "Aabb"
* 
* Output:
* "bbAa"
* Explanation:
* "bbaA" is also a valid answer, but "Aabb" is incorrect.
* Note that 'A' and 'a' are treated as two different characters.
*
* public String frequencySort(String s)
*/

import java.util.*;

public class CharacterFreqSort{
	static class CharFreq{
		int freq;
		char c;
		CharFreq(char c, int freq){
			this.c = c;
			this.freq = freq;
		}
	}
	public static String frequencySort(String s){
		int[] carray = new int[256];
		for(int i = 0; i<s.length(); i++){
			carray[s.charAt(i)]++;
		}
		PriorityQueue<CharFreq> heap = new PriorityQueue<CharFreq>(new Comparator<CharFreq>(){
			public int compare(CharFreq cf1, CharFreq cf2){
				return cf2.freq-cf1.freq;
			}
		});

		for(int c = 0; c<256; c++){
			if(carray[c] > 0)
				heap.add(new CharFreq((char)c, carray[c]));
		}
		/*for(char c = 'A'; c<='Z'; c++){
			if(int[c] > 0)
				heap.add(new CharFreq(c, int[c]));
		}*/
		StringBuilder sb = new StringBuilder();
		while(!heap.isEmpty()){
			CharFreq tmp = heap.poll();
			for(int i = 0; i<tmp.freq; i++)
				sb.append(tmp.c);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s = "Aabb";
		System.out.println(frequencySort(s));
	}
}