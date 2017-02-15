/** Given an array of words and a length L, format the text such that 
* each line has exactly L characters and is fully (left and right) justified.
*
* You should pack your words in a greedy approach; that is, pack as many words 
* as you can in each line. Pad extra spaces ' ' when necessary so that each 
* line has exactly L characters.
*
* Extra spaces between words should be distributed as evenly as possible. 
* If the number of spaces on a line do not divide evenly between words, 
* the empty slots on the left will be assigned more spaces than the slots 
* on the right.
*
* For the last line of text, it should be left justified and no extra space 
* is inserted between words.
*
* For example,
* words: ["This", "is", "an", "example", "of", "text", "justification."]
* L: 16.
*
* public List<String> fullJustify(String[] words, int maxWidth)
*/
import java.util.*;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0)
        	return res;
        int pt = 0;
        Queue<String> workq = new LinkedList<String>();
        Stack<Integer> stack = new Stack<Integer>();
        while(pt < words.length){
        	int count = 0;
        	while(pt < words.length && count + words[pt].length() <= maxWidth) { 
        		workq.add(words[pt]);
        		count += words[pt++].length() + 1;
        	}
        	int num = workq.size();
        	int space = maxWidth - count + num;
        	System.out.format("%d, %d\n", space, num);
        	while(num > 2) {
        		int tmp = space/(--num);
        		space -= tmp;
        		stack.push(tmp);
        	}
        	stack.push(space);
        	StringBuilder sb = new StringBuilder();
	        if(pt < words.length) {
	        	while(!workq.isEmpty()) {
	        		sb.append(workq.poll());
	        		if(!stack.isEmpty()) {
	        			int n = stack.pop();
	        			for(int i = 0; i < n; i++)
	        				sb.append(' ');
	        		}
	        	}
        	}else{
        		while(!workq.isEmpty()){
        			sb.append(workq.poll());
        			if(!workq.isEmpty()) sb.append(' ');
        		}
        		while(sb.length() < maxWidth)
        			sb.append(' ');
        	}
        	res.add(sb.toString());
        }
        return res;
    }
    public static void main(String[] args) {
    	String[] words = {""}; //{"What","must","be","shall","be."};
    	int maxWidth = 2;
    	List<String> res = fullJustify(words, maxWidth);
    	for(String s: res)
    		System.out.println('\"'+s+'\"');
    }
}