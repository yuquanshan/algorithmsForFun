/**
 * Given a string of numbers and operators, return all possible results from 
 * computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 *
 * Example 1
 * Input: "2-1-1".
 *
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 *
 * Example 2
 * Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 *
 * public List<Integer> diffWaysToCompute(String input) 
 */

import java.util.*;

public class DifferentWaysOfAddingParentheses {
	public List<Integer> diffWaysToCompute(String input) {	// beat 66%
		List<Integer> res = new ArrayList<Integer>();
		ArrayList<Character> ops = new ArrayList<Character>();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int tmp = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				ops.add(c);
				nums.add(tmp);
				tmp = 0;
			} else tmp = tmp*10 + c - '0';
		}
		nums.add(tmp);
		return compRange(0, nums.size() - 1, ops, nums);
	}
	private List<Integer> compRange(int start, int end, List<Character> ops, 
		List<Integer> nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (start == end) res.add(nums.get(start));
		else {
			for (int i = start; i < end; i++) {
				List<Integer> left = compRange(start, i, ops, nums);
				List<Integer> right = compRange(i + 1, end, ops, nums);
				char op = ops.get(i);
				for (int l: left) {
					for (int r: right) {
						if (op == '+') res.add(l + r);
						if (op == '-') res.add(l - r);
						if (op == '*') res.add(l * r); 
					}
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String input = "2*3-4*5";
		DifferentWaysOfAddingParentheses test = 
			new DifferentWaysOfAddingParentheses();
		System.out.println(test.diffWaysToCompute(input).toString());
	}
}