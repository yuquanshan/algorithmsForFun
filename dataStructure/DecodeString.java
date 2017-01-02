/**
* suppose a string is encoded in the following rule, 
* k[encoded_string], meaning the "encoded_string" is 
* repeated by k times, given an encoded string, return 
* the original string. you may assume the original data 
* doesn't contains any digits. digits are only used to 
* repeat numbers.
* public static String decodeString(String s){}
*/

import java.util.*;

public class DecodeString{
	static class StackNode{
		boolean isDigit;
		String content;
		StackNode(boolean isDigit, String content){
			this.isDigit = isDigit;
			this.content = content;
		}
	}
	public static String decodeString(String s){
		if(s == null)
			return null;
		Stack<StackNode> workingStack = new Stack<StackNode>();
		String res = "";
		int i = 0;
		while(i<s.length()){
			//System.out.println(i);
			if(s.charAt(i)>='0' && s.charAt(i)<='9'){
				String tmp = Character.toString(s.charAt(i));
				i++;
				while(i < s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
					tmp = tmp+s.charAt(i);
					i++;
				}
				workingStack.push(new StackNode(true,tmp));
			}else if(s.charAt(i)!=']' && s.charAt(i)!='[' && !workingStack.isEmpty()){
				if(workingStack.peek().isDigit){
					workingStack.push(new StackNode(false, Character.toString(s.charAt(i))));
				}else{
					workingStack.peek().content += s.charAt(i);
				}
				i++;
			}else if(s.charAt(i) == ']'){	// close its last repetition
				StackNode first = workingStack.pop();
				StackNode second = workingStack.pop();
				String tmp = new String(new char[Integer.parseInt(second.content)]).replace("\0",first.content);
				if(workingStack.isEmpty()){
					res = res+tmp;
				}else if(workingStack.peek().isDigit){
					workingStack.push(new StackNode(false,tmp));
				}else{
					workingStack.peek().content += tmp;
				}
				i++;
			}else if(s.charAt(i)!='['){
				res = res+s.charAt(i);
				i++;
			}else{
				i++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String s = "a3[a2[c]]";
		String res = decodeString(s);
		System.out.println(res);
	}
}
