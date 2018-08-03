public class DoublyListNode{
	int val;
	DoublyListNode next,prev;
	DoublyListNode(int val){
		this.val = val;
		this.next = this.prev = null;
	}
	public void printList(){
       	DoublyListNode tmp = this;
       	while(tmp != null){
      	    System.out.format("%d<->",tmp.val);
            tmp = tmp.next;
        }
        System.out.println("null");
    }
}