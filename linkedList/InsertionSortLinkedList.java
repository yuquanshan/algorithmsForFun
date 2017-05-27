/**
* implement insertion sort in linked list.
* public ListNode insertionSort(ListNode head)
*/

public class InsertionSortLinkedList{
	public static ListNode insertionSort(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode newhead = head;
		head = head.next;
		newhead.next = null;
		while(head != null){
			ListNode tmp = head;
			head = head.next;
			// insert tmp to new list
			if(tmp.val < newhead.val){
				tmp.next = newhead;
				newhead = tmp;
			}else{
				boolean flag = true;
				ListNode node = newhead;
				while(node.next != null){
					if(node.next.val > tmp.val){
						tmp.next = node.next;
						node.next = tmp;
						flag = false;
						break;
					}
					node = node.next;
				}
				if(flag){
					node.next = tmp;
					tmp.next = null;
				}
			}
		}
		return newhead;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(0);
		ListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		head = insertionSort(head);
		System.out.println("After insertion sort, the list is:");
		tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}