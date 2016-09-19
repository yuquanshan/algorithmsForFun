/**
given a linked list, remove the nth node from the end of the list.
*/

public class RemoveNthFromEnd{
	public static ListNode removeN(ListNode head, int n){
		ListNode senti = head;
		ListNode me = null;
		ListNode mydad = null;
		for(int i = 0; i < n; i++){
			senti = senti.next;
			if(senti == null && i != n-1)	// this list doesn't have n nodes at all
				return head;
		}
		if(senti == null)	// there are n nodes in the list, remove head
			return head.next;
		mydad = head;
		me = head.next;
		
		while(senti.next != null){
			senti = senti.next;
			me = me.next;
			mydad = mydad.next;
		}
		mydad.next = me.next;
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println("Current list:");
		ListNode ptr = head;
		while(ptr != null){
			System.out.format("%d->",ptr.val);
			ptr = ptr.next;
		}
		System.out.println("null\n");
		int n = 2;
		head = removeN(head,n);
		System.out.format("After removing %dth from end, the list is:\n",n);
		ptr = head;
		while(ptr != null){
			System.out.format("%d->",ptr.val);
			ptr = ptr.next;
		}
		System.out.println("null\n");
	}
}