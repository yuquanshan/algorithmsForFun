/** Given a binary tree, return all root-to-leaf paths.
*
* For example, given the following binary tree:
* 
*    1
*  /   \
* 2     3
*  \
*   5
* All root-to-leaf paths are:
* 
* ["1->2->5", "1->3"]
*
* public List<String> binaryTreePaths(TreeNode root)
*/
import java.util.*;

public class AllRootToLeafPaths{
	public List<String> binaryTreePaths(TreeNode root){
		List<String> res = new ArrayList<String>();
		if(root == null)
			return res;
		if(root.left == null && root.right == null){
			res.add(Integer.toString(res.val));
			return res;
		}
		if(root.left != null){
			List<String> left = binaryTreePaths(root.left);
			for(String s: left)
				res.add(Integer.toString(res.val)+"->"+s);
		}
		if(root.right != null){
			List<String> right = binaryTreePaths(root.right);
			for(String s: right)
				res.add(Integer.toString(res.val)+"->"+s);
		}
	}
}