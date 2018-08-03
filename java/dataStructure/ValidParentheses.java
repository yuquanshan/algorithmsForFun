/**
* given a string with paretheses '(', ')', '{', '}', 
* '[', ']'. determine if the string's parentheses are 
* matching.
* public static boolean isValidParentheses(String s)
*/
import java.util.*;

public class ValidParentheses{
	public static boolean isValidParentheses(String s){
		if(s==null || s.length() == 0)
			return true;
		Stack<Character> stack = new Stack<Character>();

		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == '(' || s.charAt(i)=='{' || s.charAt(i) == '[')
				stack.push(s.charAt(i));
			else if(s.charAt(i) == ')'){
				if(stack.empty() || stack.peek() != '(')
					return false;
				else
					stack.pop();
			}else if(s.charAt(i) == '}'){
				if(stack.empty() || stack.peek() != '{')
					return false;
				else
					stack.pop();
			}else if(s.charAt(i) == ']'){
				if(stack.empty() || stack.peek() != '[')
					return false;
				else
					stack.pop();
			}
		}
		if(stack.empty())
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		String s = "(s[h]yq)";
		String res = isValidParentheses(s)?"matching":"not matching";
		System.out.format("%s is %s\n", s, res);
		s = "{haha}]";
		res = isValidParentheses(s)?"matching":"not matching";
		System.out.format("%s is %s\n", s, res);
	}
}