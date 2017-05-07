/**
* write a function to serialize a binary tree to a string, and another function
* to recover the serialized tree from that string.
public class SerAndDeser {
	public String serialize(TreeNode root) {}
	public TreeNode deserialize(String data) {}	
}
*/
import java.util.*;

public class SerAndDeser{
	public static String serialize(TreeNode root){
		ArrayList<String> ser = new ArrayList<String>();
		if(root == null)
			return Arrays.toString(ser.toArray());
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		ser.add(new Integer(root.val).toString());
		while(queue.size() != 0){
			int len = queue.size();
			for(int i=0; i<len; i++){
				TreeNode tmp = queue.remove(0);
				if(tmp.left != null){
					queue.add(tmp.left);
					ser.add(new Integer(tmp.left.val).toString());
				}else{
					ser.add("#");
				}
				if(tmp.right != null){
					queue.add(tmp.right);
					ser.add(new Integer(tmp.right.val).toString());
				}else{
					ser.add("#");
				}
			}
		}
		return Arrays.toString(ser.toArray());
	}
	public static TreeNode deserialize(String data){
		if(data == null || data.equals("[]"))
			return null;
		String[] array = data.replace("[","").replace("]","").split(", ");
		TreeNode root = new TreeNode(Integer.parseInt(array[0]));
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		int offset = 1;
		while(queue.size() != 0){
			int len = queue.size();
			for(int i = 0; i<len; i++){
				TreeNode pop = queue.remove(0);
				if(!array[offset].equals("#")){
					TreeNode tmp = new TreeNode(Integer.parseInt(array[offset]));
					queue.add(tmp);
					pop.left = tmp;
					offset++;
				}else{
					offset++;
				}
				if(!array[offset].equals("#")){
					TreeNode tmp = new TreeNode(Integer.parseInt(array[offset]));
					queue.add(tmp);
					pop.right = tmp;
					offset++;
				}else{
					offset++;
				}
			}
		}
		return root;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		String ser = serialize(root);
		System.out.println("The serialization string is " + ser);
		TreeNode newRoot = deserialize(ser);
		if(StrictlyIdenticalTrees.isIdentical(root,newRoot))
			System.out.println("Correctly deserialized.");
		else
			System.out.println("Failed.");
	}
}