/**
* Convert a BST to an ascending order doubly linked list.
* public DoublyListNode bst2DoublyList(TreeNode root)
*/

// a very general approach, you can do it even with singly list

class NodeTuple{
	DoublyListNode start;
	DoublyListNode end;
	NodeTuple(DoublyListNode start, DoublyListNode end){
		this.start = start;
		this.end = end;
	}
}

public class BSTtoAscendingOrderDoublyList{
	public static DoublyListNode bst2DoublyList(TreeNode root){
		if(root == null)
			return null;
		DoublyListNode node = new DoublyListNode(root.val);
		NodeTuple leftTuple = inOrderTraverse(root.left);
		NodeTuple rightTuple = inOrderTraverse(root.right);
		DoublyListNode start = node;
		DoublyListNode end = node;
		if(leftTuple.end != null){
			start = leftTuple.start;
			node.prev = leftTuple.end;
			leftTuple.end.next = node;
		}
		if(rightTuple.start != null){
			end = rightTuple.end;
			node.next = rightTuple.start;
			rightTuple.start.prev = node;
		}
		return start;
	}
	public static NodeTuple inOrderTraverse(TreeNode root){
		if(root == null)
			return new NodeTuple(null, null);
		DoublyListNode node = new DoublyListNode(root.val);
		NodeTuple leftTuple = inOrderTraverse(root.left);
		NodeTuple rightTuple = inOrderTraverse(root.right);
		DoublyListNode start = node;
		DoublyListNode end = node;
		if(leftTuple.end != null){
			start = leftTuple.start;
			node.prev = leftTuple.end;
			leftTuple.end.next = node;
		}
		if(rightTuple.start != null){
			end = rightTuple.end;
			node.next = rightTuple.start;
			rightTuple.start.prev = node;
		}
		return new NodeTuple(start,end);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(5);
		DoublyListNode head = bst2DoublyList(root);
		head.printList();
	}
}