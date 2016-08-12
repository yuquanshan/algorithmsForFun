/**
Given a bunch of logs with different lengths, find the largest length to 
saw which would yield at least k pieces with that length, all numbers must be integer.
*/
import java.util.*;

public class WoodCut{
	public static boolean goodCut(int[] logs, int k, int cut){	// indicate a cut is sufficient to produce 
		int count = 0;
		for (int i: logs){
			count += i/cut;
		}
		if (count >= k)
			return true;
		else
			return false;
	}
	public static int wayToCut(int[] logs, int k){
		if (logs.length == 0 || logs == null)
			return -1;
		int sum = 0;

		for (int i: logs)
			sum += i;
		
		if (sum < k)
			return -1;
		
		Arrays.sort(logs);
		int left = 1;
		int right = logs[logs.length-1];

		while(right - left > 1){
			int mid = (right+left)/2;
			if(goodCut(logs, k, mid))	// if the cut length is small enough to produce at least k pieces
				left = mid;
			else
				right = mid;
		}
		return left;
	}
	public static void main(String[] args) {
		int[] logs = {232, 124, 456};
		int k = 7;
		int cut = wayToCut(logs,k);
		if(cut == -1)
			System.out.println("Can't produce " + k + " pieces.");
		else
			System.out.println("Can procduce " + k + " pieces with length " + cut);
	}
}