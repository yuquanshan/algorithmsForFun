/**
* convert sorted list to balanced BST.
* public TreeNode sortedListToBST(ListNode head)
*/

public class ConvertSortedListToBST{
	public static TreeNode sortedListToBST(ListNode head){
		if(head == null)
			return null;
		int len = 1;
		ListNode tmp = head;
		while(tmp.next != null){
			tmp = tmp.next;
			len += 1;
		}
		return subTree(head,len);
	}
	public static TreeNode subTree(ListNode head, int len){
		if(head == null || len == 0)
			return null;
		int mid = (len+1)/2-1;
		ListNode subhead = head;
		int count = 0;
		while(count<mid){
			subhead = subhead.next;
			count += 1;
		}
		TreeNode tree = new TreeNode(subhead.val);
		System.out.format("head is %d\n",tree.val);
		TreeNode left =  subTree(head, mid);
		TreeNode right = subTree(subhead.next,len-mid-1);
		tree.left = left;
		tree.right = right;
		return tree;
	}
	public static void inorderPrintTree(TreeNode head){
		if(head!=null){
			System.out.format("%d ",head.val);
			inorderPrintTree(head.left);
			inorderPrintTree(head.right);
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(21);
		head.next.next = new ListNode(25);
		head.next.next.next = new ListNode(25);
		head.next.next.next.next = new ListNode(31);	
		TreeNode tree = sortedListToBST(head);
		System.out.print("Inorder Print Tree: ");
		inorderPrintTree(tree);
		System.out.println("");
	}
}