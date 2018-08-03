/**
* given a max segment tree built on an array, according to BuildSegTreeOnArray.java,
* if the element with a index to another value, write a modify function to modify the 
* current seg tree.
* Definition of SegmentTreeNode:
* class SegmentTreeNode {
*     public int start, end, max;
*     public SegmentTreeNode left, right;
*     public SegmentTreeNode(int start, int end, int max) {
*         this.start = start;
*         this.end = end;
*         this.max = max;
*         this.left = this.right = null;
*     }
* }
* public static void modify(SegmentTreeNode root, int index, int value)
*/

import java.util.*;

class SegmentTreeNode {
	public int start, end, max;
	public SegmentTreeNode left, right;
	public SegmentTreeNode(int start, int end, int max) {
 		this.start = start;
 		this.end = end;
 		this.max = max;
 		this.left = this.right = null;
	}
}

public class ModifySegTree{
	public static void modify(SegmentTreeNode root, int index, int value){
		if(root != null && root.start <= index && root.end >= index){
			if(root.start == index && root.end == index){
				root.max = value;
			}else if(root.left != null && root.left.end >= index){
				modify(root.left, index, value);
				root.max = Math.max(root.left.max,root.right.max);
			}else{
				modify(root.right, index, value);
				root.max = Math.max(root.left.max,root.right.max);
			}
		}
	}
}