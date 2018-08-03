/**
* given k sorted list, merge them together.
* public static ListNode mergeKLists(List<ListNode> lists)
*/

import java.util.*;

class NodeComp implements Comparator<ListNode>{
	public int compare(ListNode n1, ListNode n2){
		return n1.val - n2.val;
	}
}

public class MergeKSortedLists{
	public static ListNode mergeKLists(List<ListNode> lists){
		if(lists == null || lists.size() == 0)
			return null;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),new NodeComp());
		for(int i = 0; i<lists.size(); i++){		// initial fill
			if(lists.get(i) != null){
				heap.add(lists.get(i));
			}
		}
		ListNode head = heap.poll();
		ListNode last = head;
		while(heap.peek()!=null){
			ListNode tmp = heap.poll();
			System.out.format("The number is %d\n",tmp.val);
			if(tmp.next != null)
				heap.add(tmp.next);
			last.next = tmp;
			last = tmp;
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(-1);
		node1.next = node2;
		LinkedList<ListNode> lists = new LinkedList<ListNode>();
		lists.add(node1);
		lists.add(null);
		lists.add(node3);
		ListNode head = mergeKLists(lists);
		head.printList();
	}
}