/**
* given a linked list, determine if it has a cycle.
* public static boolean hasCycle(ListNode head)
*/

public class LinkedListCycle{
	public static boolean hasCycle(ListNode head){
		if(head == null){
			return false;
		}
		if(head.next == null){
			return head.next == head;
		}
		ListNode slow = head;
		ListNode fast = head;
		boolean flag = true;
		while(flag || fast != null && fast.next != null){
			flag = false;
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = head;
		if(hasCycle(head))
			System.out.println("There is a cycle.");
		else
			System.out.println("There is no cycle.");
	}
}