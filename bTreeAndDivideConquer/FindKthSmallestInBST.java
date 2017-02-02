/** Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
* 
* Note: 
* You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
* 
* Follow up:
* What if the BST is modified (insert/delete operations) often and you need to find the kth smallest 
* frequently? How would you optimize the kthSmallest routine?
*
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
* public int kthSmallest(TreeNode root, int k)
*/
public class FindKthSmallestInBST {
    public static int kthSmallest(TreeNode root, int k) {
       	int leftCount = countTree(root.left);
       	if(k == leftCount+1)
       		return root.val;
       	else if(k < leftCount+1)
       		return kthSmallest(root.left, k);
       	else
       		return kthSmallest(root.right, k - leftCount - 1);
    }
    private static int countTree(TreeNode root){
    	if(root == null)
    		return 0;
    	int count = 1;
    	return count + countTree(root.left)+countTree(root.right);
    }
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(3);
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(4);
    	TreeNode node4 = new TreeNode(5);
    	root.left = node1;
    	node1.right = node2;
    	root.right = node4;
    	node4.left = node3;
    	int k = 4;
    	System.out.println(kthSmallest(root, k));
    }
}