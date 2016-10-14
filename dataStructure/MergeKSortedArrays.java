/**
* given k sorted arrrays, merge them into one sorted array.
* public static List<Integer> merge(int[][] arrays)
*/
import java.util.*;

class QueueNode{
	public int ai;	// array number
	public int i;
	public int val;
	QueueNode(int ai, int i, int val){
		this.ai = ai;
		this.i = i;
		this.val = val;
	}
}

class CusComp implements Comparator<QueueNode>{
	public int compare(QueueNode n1, QueueNode n2){
		return n1.val - n2.val;
	}
}

public class MergeKSortedArrays{
	public static List<Integer> merge(int[][] arrays){
		if(arrays == null)
			return null;
		PriorityQueue<QueueNode> heap = new PriorityQueue<QueueNode>(arrays.length,new CusComp());
		for(int i = 0; i < arrays.length; i++){
			if(arrays[i].length != 0){
				heap.add(new QueueNode(i,0,arrays[i][0]));
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(heap.size()!=0){
			QueueNode tmpNode = heap.poll();
			list.add(tmpNode.val);
			if(tmpNode.i != arrays[tmpNode.ai].length-1){
				heap.add(new QueueNode(tmpNode.ai,tmpNode.i+1,arrays[tmpNode.ai][tmpNode.i+1]));
			}
		}
		return list;
	}
	public static void main(String[] args) {
		int[][] arrays = {{1,3,5,7},{2,4,6},{0,8,9,10,11}};
		List<Integer> list = merge(arrays);
		System.out.println(list.toString());
	}
}