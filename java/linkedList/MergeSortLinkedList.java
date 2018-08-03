/**
* use merge sort to sort linked list list in O(nlogn) time and constant space 
* complexity.
* public ListNode mergeSort(ListNode head, int len)
*/

public class MergeSortLinkedList{
	public static ListNode sort(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		int count = 0;
		ListNode tmp = head;
		while(tmp != null){
			tmp = tmp.next;
			count += 1;
		}
		return mergeSort(head,count);
	}
	public static ListNode mergeSort(ListNode head, int len){
		if(head == null || head.next == null)
			return head;
		if(len == 1){
			head.next = null;
			return head;
		}
		int left = len/2;
		ListNode heada = head;
		for(int i = 0; i < left; i++){
			heada = heada.next;
		}
		ListNode head1 = mergeSort(head,left);
		ListNode head2 = mergeSort(heada,len-left);
		return mergeTwo(head1,head2);
	}
	public static ListNode mergeTwo(ListNode head1, ListNode head2){
		if(head2 == null)
			return head1;
		if(head1 == null)
			return head2;
		ListNode pseudoHead = new ListNode(0);
		ListNode tmp = pseudoHead;
		while(head2 != null || head1 != null){
			if(head2 == null){
				tmp.next = head1;
				head1 = head1.next;
			}else if(head1 == null){
				tmp.next = head2;
				head2 = head2.next;
			}else{
				if(head1.val < head2.val){
					tmp.next = head1;
					head1 = head1.next;
				}else{
					tmp.next = head2;
					head2 = head2.next;
				}
			}
			tmp = tmp.next;
		}
		tmp.next = null;
		return pseudoHead.next;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(-1);
		head.next.next.next.next = new ListNode(5);
		head = sort(head);
		System.out.println("The sorted list is: ");
		ListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}