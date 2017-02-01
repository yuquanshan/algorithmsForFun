/**
* use Morris traversal (threaded binary tree) to implement a 
* in-order interator of a binary tree.
*	public class MorrisBSTIterator {
*	    public MorrisBSTIterator(TreeNode root){}
*	    public boolean hasNext(){}
*	    public TreeNode next(){}
*	}
*/

public class MorrisBSTIterator{
	private TreeNode current;
	public MorrisBSTIterator(TreeNode root){
		current = root;
	}
	public boolean hasNext(){
		return current != null;
	}
	public TreeNode next(){
		if(hasNext()){
			if(current.left == null){
				TreeNode res = current;
				current = current.right;
				return res;
			}else{
				TreeNode pre = current.left;
				while(pre.right != null && pre.right != current){
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = current;
					current = current.left;
					return next();
				}else{
					pre.right = null;
					TreeNode res = current;
					current = current.right;
					return res;
				}
			}
		}else{
			return null;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(12);
        /*
                            8
                           / \
                          5   11
                         / \  / \
                        1  7 10  12
                          /
                         6
        */
        MorrisBSTIterator iter = new MorrisBSTIterator(root);
        while(iter.hasNext()){
                System.out.println("Visit: " + iter.next().val);
        }
	}
}