/** Implement a basic calculator to evaluate a simple expression string.
*
* The expression string may contain open ( and closing parentheses ), 
* the plus + or minus sign -, non-negative integers and empty spaces .
* 
* You may assume that the given expression is always valid.
*
* Some examples:
* "1 + 1" = 2
* " 2-1 + 2 " = 3
* "(1+(4+5+2)-3)+(6+8)" = 23
* Note: Do not use the eval built-in library function.
* public int calculate(String s)
*/
import java.util.*;

public class BasicCalculator{
	public static int calculate(String s){
		// i gonna use reverse polish order
		int i = 0;
		Deque<String> stack = new LinkedList<String>();
		Stack<Character> signstack = new Stack<Character>();
		while(i < s.length()){
			//System.out.println(i);
			if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(')
				signstack.push(s.charAt(i));
			else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
				String str = "";
				while(i<s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
					str = str+s.charAt(i++);
				i--;
				stack.addLast(str);
				if(!signstack.isEmpty() && (signstack.peek() == '+' || signstack.peek() == '-'))
					stack.addLast(Character.toString(signstack.pop()));
			}else if(s.charAt(i) == ')'){
				while(signstack.peek()!='('){
					stack.addLast(Character.toString(signstack.pop()));
				}
				signstack.pop();
				if(!signstack.isEmpty() && (signstack.peek() == '+' || signstack.peek() == '-'))
					stack.addLast(Character.toString(signstack.pop()));
			}
			i++;
		}
		while(!signstack.isEmpty())
			stack.addLast(Character.toString(signstack.pop()));
		/*System.out.println("signstack:");
		while(!signstack.isEmpty())
			System.out.println(signstack.pop());
		System.out.println("stack:");
		while(!stack.isEmpty())
			System.out.println(stack.removeLast());*/
		return evalReversePolish(stack);
	}
	private static int evalReversePolish(Deque<String> stack){	// evaluate reverse polish order
		if(stack.isEmpty())
			return 0;
		Stack<Integer> workingstack = new Stack<Integer>();
		while(!stack.isEmpty()){
			String s = stack.removeFirst();
			if(s.equals("+")){
				int second = workingstack.pop();
				int first = workingstack.pop();
				workingstack.push(first+second);
			}else if(s.equals("-")){
				int second = workingstack.pop();
				int first = workingstack.pop();
				workingstack.push(first-second);
			}else{
				workingstack.push(Integer.parseInt(s));
			}
		}
		return workingstack.pop();
	}
	public static void main(String[] args) {
		String s = "(1+(4+5+2)-3)+(6 + 8)";
		System.out.println(calculate(s));
	}
}