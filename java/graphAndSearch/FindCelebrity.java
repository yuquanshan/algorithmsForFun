/** Suppose you are at a party with n people (labeled from 0 to n - 1) 
* and among them, there may exist one celebrity. The definition of a 
* celebrity is that all the other n - 1 people know him/her but he/she 
* does not know any of them.
*
* Now you want to find out who the celebrity is or verify that there 
* is not one. The only thing you are allowed to do is to ask questions 
* like: "Hi, A. Do you know B?" to get information of whether A knows B. 
* You need to find out the celebrity (or verify there is not one) by 
* asking as few questions as possible (in the asymptotic sense).
*
* You are given a helper function bool knows(a, b) which tells you 
* whether A knows B. Implement a function int findCelebrity(n), your 
* function should minimize the number of calls to knows.
*
* public int findCelebrity(int n)
*/

public class FindCelebrity{
	public int findCelebrity(int n){
		if(n == 0)
			return -1;
		if(n == 1)
			return 0;
		int start = 0;
		int end = n - 1;
		while(start < end){	// no need to use two pointer at all
			if(knows(start, end))
				start++;
			else if(knows(end, start))
				end--;
			else{
				start++;
				end--;
			}
		}
		if(start > end)
			return -1;
		for(int i = 0; i < n; i++){
			if(i != start && (!knows(i, start) || knows(start, i)))
				return -1;
		}
		return start;
	}
}