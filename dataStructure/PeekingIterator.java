/** Peek iterator
* Given an Iterator class interface with methods: next() and hasNext(), 
* design and implement a PeekingIterator that support the peek() 
* operation -- it essentially peek() at the element that will be returned by the next call to next().
* Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
* Call next() gets you 1, the first element in the list.
* Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
* You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
* 
* Follow up: How would you extend your design to be generic and work with all types, not just integer?
*/
import java.util.*;

class PeekingIterator implements Iterator<Integer> {
	Integer forpeek;
	Iterator<Integer> iter;
	public PeekingIterator(Iterator<Integer> iterator) {
	    iter = iterator;
	    forpeek = iterator.hasNext()?iterator.next():null;
	}

	public Integer peek() {
        return forpeek;
	}

	@Override
	public Integer next() {
	    Integer res = forpeek;
	    forpeek = iter.hasNext()?iter.next():null;
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return !(forpeek == null);
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1); list.add(2); list.add(3);
		PeekingIterator piter = new PeekingIterator(list.iterator());
		System.out.println(piter.peek());
		System.out.println(piter.next());
		System.out.println(piter.peek());
		System.out.println(piter.next());
		System.out.println(piter.peek());
		System.out.println(piter.next());
		if(!piter.hasNext())
			System.out.println("Done!");
		else
			System.out.println("Oops!");
	}
}