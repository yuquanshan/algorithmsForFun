/**
* find the longest absolute file path in a file system 
* for example, given fs as follows
* "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile.ext"
* dir
*    subdir1
*        file1.ext
*        subsubdir1
*    subdir2
*        subsubdir2
*            file2.ext
* should return 32, because "dir/subdir2/subsubdir2/file2.ext" 
* contains 32 characters.
* note that a file contains '.' and directory doesn't contain '.'
* public static int lengthLongestPath(String input){}
*/
import java.util.*;

public class LongestAbsFilePath{
	public static int lengthLongestPath(String input){
		int curLen = 0;
		input = input+'\n';
		int len = input.length();
		Stack<Integer> stack = new Stack<Integer>(); // store the depth of dir
		Stack<Integer> stack1 = new Stack<Integer>(); 	// store the length of current dir+'/'
		int pointer = 0;
		int res = 0;
		while(pointer!=len){
			String df = "";
			int depth = 0;
			while(input.charAt(pointer)!='\n'){
				if(input.charAt(pointer) == '\t')
					depth++;
				else
					df = df+input.charAt(pointer);
				pointer++;
			}
			pointer++;
			if(df.contains(".")){	// it's a file
				while(!stack.isEmpty() && stack.peek() >= depth){
					stack.pop();
					curLen -= stack1.pop();
				}
				res = Math.max(res, curLen+df.length());
			}else{	// it's a directory
				df = df+'/';
				while(!stack.isEmpty()&&stack.peek()>=depth){
					stack.pop();
					curLen -= stack1.pop();
				}
				stack.push(depth);
				stack1.push(df.length());
				curLen += df.length();
			}	
		}
		return res;
	}
	public static void main(String[] args) {
		//String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		String input = "dir\n    file.txt";
		System.out.format("Given\n %s\nThe length of the longest abs file path is %d.\n",input,lengthLongestPath(input));
	}
}