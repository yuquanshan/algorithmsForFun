/**
* given two integers as interval start and end.
* build an integer segment tree with the following node.
* class SegmentTreeNode {
*     public int start, end;
*     public SegmentTreeNode left, right;
*     public SegmentTreeNode(int start, int end) {
*         this.start = start, this.end = end;
*         this.left = this.right = null;
*     }
* }
* public static SegmentTreeNode build(int start, int end)
*/

class SegmentTreeNode {
    public int start, end;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start; 
        this.end = end;
        this.left = this.right = null;
    }
}

public class BuildSegTree{
	public static SegmentTreeNode build(int start, int end){
		if(start > end)
			return null;
		if(start == end)
			return new SegmentTreeNode(start,end);
		int mid = start+(end-start)/2;
		SegmentTreeNode left = build(start,mid);
		SegmentTreeNode right = build(mid+1,end);
		SegmentTreeNode res = new SegmentTreeNode(start,end);
		res.left = left;
		res.right = right;
		return res;
	}
}