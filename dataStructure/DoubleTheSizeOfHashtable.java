/**
* given a hash table with a certain size, double the size of the hash table 
* return the new hash table.
* public static ListNode[] rehashing(ListNode[] hashTable)
*/

public class DoubleTheSizeOfHashtable{
	public static ListNode[] rehashing(ListNode[] hashTable){
		if(hashTable == null || hashTable.length == 0)
			return null;
		int length = hashTable.length;
		ListNode[] newhashTable = new ListNode[length*2];
		for(int i = 0; i<length*2; i++)
			newhashTable[i] = null;
		for(int i = 0; i<length; i++){ 	// enumerate the original hash table
			ListNode head = hashTable[i];
			while(head != null){
				ListNode tmp = head.next;
				/*head.next = newhashTable[(head.val%(length*2)+length*2)%(length*2)];
				newhashTable[(head.val%(length*2)+length*2)%(length*2)] = head;
				*/
				ListNode tmp1 = newhashTable[(head.val%(length*2)+length*2)%(length*2)];
				head.next = null;
				if(tmp1 == null){
					newhashTable[(head.val%(length*2)+length*2)%(length*2)] = head;
				}else{
					while(tmp1.next != null){
						tmp1 = tmp1.next;
					}
					tmp1.next = head;
				}
				head = tmp;
			}
		}
		return newhashTable;
	}
	public static void main(String[] args) {
		ListNode[] hashTable = new ListNode[4];
		for(int i = 0; i< 4; i++)
			hashTable[i] = null;
		ListNode node1 = new ListNode(21);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(14);
		node1.next = node2;
		hashTable[1] = node1;
		hashTable[2] = node3;
		System.out.println("The current hash table is:");
		for(int i = 0; i< hashTable.length; i++){
			if(hashTable[i]!=null)
				hashTable[i].printList();
			else
				System.out.println("null");
		}
		hashTable = rehashing(hashTable);
		System.out.println("The new hash table is:");
		for(int i = 0; i< hashTable.length; i++){
			if(hashTable[i]!=null)
				hashTable[i].printList();
			else
				System.out.println("null");
		}
	}
}