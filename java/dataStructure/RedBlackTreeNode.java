/**
* Node of red-black tree.
*/

public class RedBlackTreeNode{
	public RedBlackTreeNode parent;
	public RedBlackTreeNode left;
	public RedBlackTreeNode right;
	public int color;	// 0 is red, 1 is black
	public int val;
	public RedBlackTreeNode(int val, int color){
		this.val = val;
		this.color = color;
		parent = null;
		left = null;
		right = null;
	}
}
