/**
merge several sorted linked list and return it as one sorted list.
*/
import java.util.*;
public class MergeMultipleSortedLists{
	public static ListNode mergeLists(List<ListNode> lists){
		if(lists == null || lists.size() == 0)
			return null;
		int indx = 0;	// keep track of minimum head
		int smallestsofar = 0;
		boolean flag = true;	// when all head become null, it is false
		int size = lists.size();
		ListNode pseudohead = new ListNode(0);
		ListNode tmp = pseudohead;
		while(flag){
			indx = 0;
			flag = false;
			smallestsofar = Integer.MAX_VALUE;
			for(int i = 0; i<size; i++){
				if(lists.get(i) != null){
					flag = true;
					if(lists.get(i).val <= smallestsofar){
						indx = i;
						smallestsofar = lists.get(i).val;
					}
				}
			}
			tmp.next = lists.get(indx);
			if(flag)
				lists.set(indx,lists.get(indx).next);
			tmp = tmp.next;
		}
		return pseudohead.next;
	}
	public static void main(String[] args) {
		ListNode list1 = new ListNode(2);
		list1.next = new ListNode(4);
		ListNode list2 = null;
		ListNode list3 = new ListNode(-1);
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		ListNode head = mergeLists(lists);
		System.out.println("The merged list is: ");
		ListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}