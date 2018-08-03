/** Given a non-empty string str and an integer k, rearrange the string 
* such that the same characters are at least distance k from each other.
*
* All input strings are given in lowercase letters. If it is not possible 
* to rearrange the string, return an empty string "".
*
* Example 1:
* str = "aabbcc", k = 3
* Result: "abcabc"
*
* The same letters are at least distance 3 from each other.
* Example 2:
* str = "aaabc", k = 3  
* Answer: ""
* 
* It is not possible to rearrange the string.
* Example 3:
* str = "aaadbbcc", k = 2
* Answer: "abacabcd"
* Another possible answer is: "abcabcda"
*
* The same letters are at least distance 2 from each other.
* public String rearrangeString(String str, int k)
*/
import java.util.*;

public class RearrangeStringKApart{
    public static String rearrangeString(String str, int k) {
        if(str == null || str.length() <= 1 || k <= 0)
        	return str;
        StringBuilder sb = new StringBuilder();
        int[] array = new int[26];
        for(int i = 0; i<str.length(); i++)
        	array[str.charAt(i)-'a']++;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>(){
        	public int compare(int[] a, int[] b){
        		return b[1] - a[1];
        	}
        });
        for(int i = 0; i<26; i++){
        	if(array[i] > 0)
        		heap.add(new int[]{i,array[i]});
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        int size = str.length();
        int[] npos = new int[26];
        for(int i = 0; i<26; i++)
        	npos[i] = -k;
        while(size > 0){
        	int q = k;
        	while(!heap.isEmpty() && q > 0){
        		queue.add(heap.poll());
        		q--;
			}
			//System.out.format("%d, %d", size, queue.size());
        	if(q != 0 && size > queue.size())
        		return "";
        	while(!queue.isEmpty()){
        		int[] tmp = queue.remove();
        		if(str.length() - size >= npos[tmp[0]]+k){
        			tmp[1]--;
        			npos[tmp[0]] = str.length()-size;
        			sb.append((char)('a'+tmp[0]));
        			size--;
        			if(tmp[1] > 0)
        				heap.add(tmp);
        		}else{
        			queue.add(tmp);
        		}
        	}
        }
        return sb.toString();
    }
    public static void main(String[] args) {
    	String str = "aa"; //"aabbcc";
    	int k = 1;
    	System.out.println(rearrangeString(str,k));
    }
}
