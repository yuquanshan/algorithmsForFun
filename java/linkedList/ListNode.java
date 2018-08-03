 public class ListNode {
   	int val;
   	ListNode next;
   	ListNode(int val) {
    	this.val = val;
        this.next = null;
   	}
   	public void printList(){
   		ListNode tmp = this;
  		while(tmp != null){
  			System.out.format("%d->",tmp.val);
  			tmp = tmp.next;
  		}
  		System.out.println("null");
   	}
 }