/**
* in a linked list, remove all nodes with target value.
* public ListNode removeTar(ListNode head, int val)
*/

public class RemoveNodesWithTargetValue{
	public static ListNode removeTar(ListNode head, int val){
		if(head == null)
			return null;
		while(head.val == val){
			head = head.next;
			if(head == null)
				return null;
		}
		ListNode tmp = head;
		while(tmp.next != null){
			if(tmp.next.val == val){
				tmp.next = tmp.next.next;
			}else{
				tmp = tmp.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		System.out.println("Current list is:");
		ListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		int target = 3;
		head = removeTar(head,target);
		System.out.format("After removing %d, the list is:\n",target);
		tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}