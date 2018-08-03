/**
* write a in-order BFS iterator
* 	class BSTIterator{
*		BSTIterator(TreeNode root){}
*		public int next();
* 		public boolean isNext();	
* 	}
*/
import java.util.*;

public class BSTInorderIterator{
	private Stack<TreeNode> stack;
	BSTInorderIterator(TreeNode root){
		stack = new Stack<TreeNode>();
		if(root != null){
			TreeNode tmp = root;
			while(tmp != null){
				stack.push(tmp);
				tmp = tmp.left;
			}
		}
	}
	public int next(){
		if(isNext()){
			TreeNode node = stack.pop();
			TreeNode tmp = node.right;
			while(tmp != null){
				stack.push(tmp);
				tmp = tmp.left;
			}
			return node.val;
		}else{
			return -1;
		}
	}
	public boolean isNext(){
		return !stack.empty();
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2;
		node2.left = node3;
		node1.right = node4;
		BSTInorderIterator iter = new BSTInorderIterator(node1);
		while(iter.isNext())
			System.out.println(iter.next());
	}
}