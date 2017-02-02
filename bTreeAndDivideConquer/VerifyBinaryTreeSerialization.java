/** One way to serialize a binary tree is to use pre-order traversal. 
* When we encounter a non-null node, we record the node's value. If it 
* is a null node, we record using a sentinel value such as #.
*
*	     _9_
*   	/   \
*  	   3     2
*  	  / \   / \
*    4   1  #  6
*   / \ / \   / \
*   # # # #   # #
* For example, the above binary tree can be serialized to the string 
* "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
*
* Given a string of comma separated values, verify whether it is a correct preorder traversal
* serialization of a binary tree. Find an algorithm without reconstructing the tree.
*
* Each comma separated value in the string must be either an integer or 
* a character '#' representing null pointer.
*
* You may assume that the input format is always valid, 
* for example it could never contain two consecutive commas such as "1,,3".
*
* Example 1:
* "9,3,4,#,#,1,#,#,2,#,6,#,#"
* Return true
* 
* Example 2:
* "1,#"
* Return false
* 
* Example 3:
* "9,#,#,1"
* Return false
* public boolean isValidSerialization(String preorder)
*/
import java.util.*;

public class VerifyBinaryTreeSerialization{
	public static boolean isValidSerialization(String preorder){
		String[] array = preorder.split(",");
		Stack<String> stack = new Stack<String>();
		Stack<Integer> state = new Stack<Integer>();
		int count = 0;
		for(String a: array){
			count++;
			if(a.equals("#")){
				if(stack.isEmpty())
					break;
				if(state.peek() == 1){
					state.pop();
					state.push(2);
				}else{
					while(!state.isEmpty() && state.peek() == 2){
						state.pop();
						stack.pop();
					}
				}
				if(state.isEmpty())
					break;
				state.pop(); state.push(2);
			}else{
				stack.push(a);
				state.push(1);
			}
		}
		return (count == array.length) && stack.isEmpty();
	}
	public static void main(String[] args) {
		String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		if(isValidSerialization(preorder))
			System.out.println("Test1 passed!");
	}
}