/**
simpe version of lowest common ancestor.
now each node (ParentTreeNode) has parent attribute
*/
import java.util.*;

public class LowestCommonAncestorSimple{
	public static ParentTreeNode lca(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B){
		// we can trace A and B back to the root.
		// start from A
		ArrayList<ParentTreeNode> traceA = new ArrayList<ParentTreeNode>();
		ParentTreeNode temp = A;
		traceA.add(temp);
		while(temp.parent != null){
			temp = temp.parent;
			traceA.add(temp);
		}
		ArrayList<ParentTreeNode> traceB = new ArrayList<ParentTreeNode>();
		temp = B;
		traceB.add(temp);
		while(temp.parent != null){
			temp = temp.parent;
			traceB.add(temp);
		}
		int backOffset = 1;
		int lenA = traceA.size();
		int lenB = traceB.size();
		temp = traceA.get(lenA-backOffset);
		while(backOffset <= Math.min(lenA,lenB) && traceA.get(lenA-backOffset) == traceB.get(lenB-backOffset)){
			temp = traceA.get(lenA-backOffset);
			backOffset++;
		}
		return temp;
	}
	public static void main(String[] args) {
		ParentTreeNode root = new ParentTreeNode(4);
		ParentTreeNode node1 = new ParentTreeNode(3);
		ParentTreeNode node2 = new ParentTreeNode(7);
		ParentTreeNode node3 = new ParentTreeNode(5);
		ParentTreeNode node4 = new ParentTreeNode(6);
		/*
				4
			   / \
			  3   7
			  	 / \
			  	5   6
		*/
		root.left = node1;
		node1.parent = root;
		root.right = node2;
		node2.parent = root;
		node2.left = node3;
		node3.parent = node2;
		node2.right = node4;
		node4.parent = node2;
		System.out.println("The LCA of " + node1.val + " and " + node3.val + " is " + lca(root,node1,node3).val+".");

		ParentTreeNode root1 = new ParentTreeNode(9);
		/*
			9
		*/
		System.out.println("The LCA of " + root1.val + " and " + root1.val + " is " + lca(root1,root1,root1).val+".");
	}
}