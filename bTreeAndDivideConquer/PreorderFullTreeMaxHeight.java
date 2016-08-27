/**
given a preorder traversal result of a *full* binary tree, e.g., "NNLNLLL", 
return the max height of the tree.
original problem see http://stackoverflow.com/questions/14612428/find-tree-height-given-preorder.
*/
import java.util.*;

class StackNode{
	public int maxSoFar = 0;
	public int branchReaped = 0; 	// # of branched 'reaped', if it equals 2, pop it out. 
}

public class PreorderFullTreeMaxHeight{
	public static int maxHeight(String trav){
		int length = trav.length();
		if(trav == null || length==0){
			return 0;
		}
		if(trav.charAt(0) == 'L')
			return 1;
		boolean enter = true;
		Stack<StackNode> stack = new Stack<StackNode>();
		int pt = 0; 	// current pointer of the string
		StackNode popedNode = null;
		while(enter == true || !stack.empty()){
			if(enter)
				enter = false;
			if(pt == length)
				break;
			char currChar = trav.charAt(pt++);
			if(currChar == 'N'){
				stack.push(new StackNode());
			}else if (currChar == 'L'){
				StackNode workingNode = stack.peek();
				if (workingNode.maxSoFar < 2){
					workingNode.maxSoFar = 2;
					//System.out.println("Max height updated to " + workingNode.maxSoFar);
				}
				workingNode.branchReaped++;
				while(workingNode.branchReaped >= 2){	// keep poping overkill, actually "== 2" is enough
					popedNode = stack.pop();
					if(stack.empty())
						break;
					workingNode = stack.peek();
					workingNode.branchReaped++;
					if(workingNode.maxSoFar < popedNode.maxSoFar+1){
						workingNode.maxSoFar = popedNode.maxSoFar+1;
						//System.out.println("Max height updated to " + workingNode.maxSoFar);
					}
				}
			}
		}
		return popedNode.maxSoFar;
	}
	public static void main(String[] args) {
		String trav = "NNLNLLL";
		//String trav = "NLL";
		System.out.println("The max height of the tree is " + maxHeight(trav)+".");
	}
}