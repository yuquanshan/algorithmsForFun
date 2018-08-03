/**
* given a linked list, reverse k nodes at a time, the left out nodes should remain 
* the original order. e.g.,
* 1->2->3->4->5, if k = 2, should return 2->1->4->3->5.
* only constant memory is allowed.
* public static ListNode reverseK(ListNode head, int k)
* public ListNode reverseK(ListNode head, int k)
*/

public class ReverseEveryKNodes{
	public static ListNode reverseK(ListNode head, int k){
		if(head == null || head.next == null || k <= 1)
			return head;
		int count = 1;
		ListNode tmp = head;
		while(count <= k){
			if(tmp == null)
				return head;
			tmp = tmp.next;
			count += 1;
		}
		tmp = head;
		ListNode currHead = null;
		for(int i = 0; i < k; i++){
			ListNode mid = tmp;
			tmp = tmp.next;
			mid.next = currHead;
			currHead = mid;
		}
		head.next = reverseK(tmp,k);
		return currHead;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		int k = 2;
		System.out.println("Current list is ");
		head.printList();
		head = reverseK(head,k);
		System.out.format("The %d-group reversed list is:\n",k);
		head.printList();
	}
}