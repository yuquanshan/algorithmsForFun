/**
* given the number of pairs of parentheses, return all possible
* legal parentheses forms.
* e.g., given n= 3, return "((()))", "(()())", "(())()", "()(())", "()()()"
* public static ArrayList<String> generateParenthesis(int n){}
* (appeared in Google interview)
*/
import java.util.*;

public class GenerateParentheses{
	public static ArrayList<String> generateParenthesis(int n){
		if(n == 0)
			return new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		String s = "(";
		appendParenthese(s,n-1,1,res);
		return res;
	}
	public static void appendParenthese(String s, int left, int right, ArrayList<String> res){
		if(left == 0 && right == 0)
			res.add(s);
		else{
			if(left > 0)
				appendParenthese(s+'(', left-1, right+1, res);
			if(right > 0)
				appendParenthese(s+')', left, right-1, res);
		}
	}
	public static void main(String[] args) {
		int n = 3;
		ArrayList<String> res = generateParenthesis(n);
		System.out.format("The possible parentheses when n = %d is %s.\n", n, res.toString());
	}
}