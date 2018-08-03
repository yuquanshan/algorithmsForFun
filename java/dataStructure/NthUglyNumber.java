/**
* ugly number is the number with only factors 2,3,5, 
* 1 is also a ugly number. find the nth ugly number.
* public static int nthUglyNumber(int n) 
*/
import java.util.*;

public class NthUglyNumber{
	public static int nthUglyNumber(int n){
		if(n <= 1)
			return 1;
		long[] list = new long[n];
		list[0] = 1;
		long i1,i2,i3;
		for(int i = 1; i<n; i++){
			i1 = findMinLarger(list,i-1,2);
			i2 = findMinLarger(list,i-1,3);
			i3 = findMinLarger(list,i-1,5);
			list[i] = Math.min(i3,Math.min(i1,i2));
			//System.out.format("%d:%d\n",i,list[i]);
		}
		return (int)list[n-1];
	} 
	public static long findMinLarger(long[] array, int last, int i){
		int start = 0;
		int end = last;
		while(end - start > 1){
			int mid = start + (end - start)/2;
			if(array[mid]*i <= array[last])
				start = mid;
			else
				end = mid;
		}
		if(array[start]*i>array[last])
			return array[start]*i;
		else
			return array[end]*i;
	}
	public static void main(String[] args) {
		int i = 1665;
		System.out.format("The %dth ugly number is %d.\n",i,nthUglyNumber(i));
	}
}
