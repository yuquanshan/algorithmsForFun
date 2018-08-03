/**
* given two binary trees, determine if two trees are *strictly* identical,
* if tweak exits, the two trees are not identical.
*
* public boolean isIdentical(TreeNode a, TreeNode b)
*/

public class StrictlyIdenticalTrees{
    public static boolean isIdentical(TreeNode a, TreeNode b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        if(a.val == b.val)
            return isIdentical(a.left,b.left) && isIdentical(a.right,b.right);
        return false;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        /* tree 1    tree 2
            1           1
           / \         / \
          2   3       2   3
        */
        if (isIdentical(root1,root2))
            System.out.println("Tree 1 and 2 are identical.");
        else
            System.out.println("Tree 1 and 2 are not identical.");
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(2);
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        /* tree 3    tree 4
            1           1
           / \         / \
          3   2       2   3
        */
        if (isIdentical(root3,root4))
            System.out.println("Tree 3 and 4 are identical.");
        else
            System.out.println("Tree 3 and 4 are not identical.");
    }
}