/**
* given a nested list, write a iterator which flattens it.
* for example, given [[1,1],2,[1,1]], the iterator should
* return [1,1,2,1,1].
*	public class NestedIterator implements Iterator<Integer> {
*	    public NestedIterator(List<NestedInteger> nestedList){}
*	    public Integer next(){}
*	    public boolean hasNext(){}
*	    public void remove() {}
*	}
* and 
* public interface NestedInteger {
*
*     // @return true if this NestedInteger holds a single integer,
*     // rather than a nested list.
*     public boolean isInteger();
*
*     // @return the single integer that this NestedInteger holds,
*     // if it holds a single integer
*     // Return null if this NestedInteger holds a nested list
*     public Integer getInteger();
*
*     // @return the nested list that this NestedInteger holds,
*     // if it holds a nested list
*     // Return null if this NestedInteger holds a single integer
*     public List<NestedInteger> getList();
* }
* (failed to give a correct algorithm on time for the first time)
*/
import java.util.*;
public class NestedListIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    public NestedListIterator(List<NestedInteger> nestedList){
        stack = new Stack<NestedInteger>();
    	for(int i = nestedList.size()-1; i>=0; i--){
    		stack.push(nestedList.get(i));
    	}
    }
    public Integer next(){
    	if(hasNext()){
    		return stack.pop().getInteger();
    	}else{
    		return -1;
    	}
    }
    public boolean hasNext(){
    	while(!stack.empty()){
    		if(stack.peek().isInteger()){
    			return true;
    		}
    		List<NestedInteger> top = stack.pop().getList();
    		for(int i = top.size()-1; i>=0; i--){
    			stack.push(top.get(i));
    		}
    	}
    	return false;
    }
    public void remove(){}
}

