/**
* given an array of numbers, find a way to get 24 using operators + - * %
* public static String get24(int[] nums) 
* (a question witnessed in SnapChat interview, never seen in lint/leetcode 
* don't know how to do at all in the first time)
*/

import java.util.*;

class PassingPackage{
	public ArrayList<Integer> nums;
	public int ops;	// number of operators to insert
	public PassingPackage(ArrayList<Integer> nums, int ops){
		this.nums = nums;
		this.ops = ops;
	}
}

public class Game24{
	public static String get24(int[] nums){
		if(nums == null || nums.length == 0)
			return null;
		if(nums.length == 1){
			if(nums[0] == 24)
				return Integer.toString(nums[0]);
			else
				return null;
		}
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++){
			array.add(nums[i]);
		}
		for(int i = 0; i<nums.length-1; i++){
			for(int j = i+1; j<nums.length; j++){
				ArrayList<Integer> inputArray = new ArrayList<Integer>(array);
				inputArray.remove(j);
				inputArray.remove(i);
				ArrayList<String> stack = new ArrayList<String>();
				stack.add(Integer.toString(nums[i]));
				stack.add(Integer.toString(nums[j]));
				PassingPackage passing = new PassingPackage(inputArray, 1);
				if(dfs(passing,stack)){
					String res = translate(stack);
					return res;
				}
			}
		}
		return null;
	}

	public static Boolean dfs(PassingPackage passing, ArrayList<String> stack){
		if(parseStack(stack) == 24)
			return true;
		ArrayList<Integer> array = passing.nums;
		ArrayList<String> operators = new ArrayList<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("%");
		for(int i = 0; i<array.size(); i++){
			ArrayList<Integer> input = new ArrayList<Integer>(array);
			input.remove(i);
			stack.add(Integer.toString(array.get(i)));
			if(dfs(new PassingPackage(input, passing.ops+1),stack))
				return true;
			stack.remove(stack.size()-1);
		}
		if(passing.ops > 0){
			for(String op: operators){
				stack.add(op);
				if(dfs(new PassingPackage(new ArrayList<Integer>(array),passing.ops-1),stack))
					return true;
				stack.remove(stack.size()-1);
			}
		}
		return false;
	}

	public static int parseStack(ArrayList<String> stack){
		Stack<Integer> intStack = new Stack<Integer>();
		for(String s: stack){
			if(s.equals("+")){
				int second = intStack.pop();
				int first = intStack.pop();
				intStack.push(first+second);
			}else if(s.equals("-")){
				int second = intStack.pop();
				int first = intStack.pop();
				intStack.push(first-second);
			}else if(s.equals("*")){
				int second = intStack.pop();
				int first = intStack.pop();
				intStack.push(first*second);
			}else if(s.equals("%")){
				int second = intStack.pop();
				int first = intStack.pop();
				if(second == 0)	// dividing 0 is illegal!
					return 0;
				intStack.push(first/second);
			}else{
				intStack.push(Integer.parseInt(s));
			}
		}
		return intStack.pop();	// ideally should be the only element in the stack
	}
	public static String translate(ArrayList<String> stack){
		Stack<String> stringStack = new Stack<String>();
		for(String s: stack){
			if(s.equals("+")){
				String second = stringStack.pop();
				String first = stringStack.pop();
				stringStack.push('('+first+'+'+second+')');
			}else if(s.equals("-")){
				String second = stringStack.pop();
				String first = stringStack.pop();
				stringStack.push('('+first+'-'+second+')');
			}else if(s.equals("*")){
				String second = stringStack.pop();
				String first = stringStack.pop();
				stringStack.push('('+first+'*'+second+')');
			}else if(s.equals("%")){
				String second = stringStack.pop();
				String first = stringStack.pop();
				stringStack.push('('+first+'/'+second+')');
			}else{
				stringStack.push(s);
			}
		}
		return stringStack.pop();
	}
	public static void main(String[] args) {
		int[] nums = {70,2,3};
		String str = get24(nums);
		if(str != null)
			System.out.format("Given %s, %s = 24.\n", Arrays.toString(nums), str);
		else
			System.out.format("Given %s, cannot get 24.\n", Arrays.toString(nums));
	}
}