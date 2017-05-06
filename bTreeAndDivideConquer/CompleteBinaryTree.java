/**
* determine if a tree is complete or not.
* public boolean isComplete(TreeNode root)
*/

// do it using BFS
import java.util.*;
public class CompleteBinaryTree{
    public static boolean isComplete(TreeNode root){
        if(root == null)
            return true;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean flag = false;   // indicate one null has been encountered, if complete tree, queue shouldn't take any node anymore
        while(queue.peek()!=null){
            TreeNode tmp = queue.remove();
            if(tmp.left != null){
                if(flag)
                    return false;
                queue.add(tmp.left);
            }else{
                flag = true;
            }
            if(tmp.right != null){
                if(flag)
                    return false;
                queue.add(tmp.right);
            }else{
                flag = true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        /*
                1
               / \
              2   3
             /
            4
        */
        if (isComplete(root))
            System.out.println("The tree is complete.");
        else
            System.out.println("The tree is no complete.");         
    }
}