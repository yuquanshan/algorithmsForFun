/** A binary watch has 4 LEDs on the top which represent the hours (0-11), 
* and the 6 LEDs on the bottom represent the minutes (0-59).
*
* Each LED represents a zero or one, with the least significant bit on the right.
*
* Given a non-negative integer n which represents the number of LEDs that are 
* currently on, return all possible times the watch could represent.
*/
import java.util.*;

public class BinaryWatch{
	public static List<String> readBinaryWatch(int num){
		int bits = 0;
		List<String> res = new ArrayList<String>();
		dfs(bits, 0, num, res);
		return res;
	}
	public static void dfs(int bits, int i, int left, List<String> res){
		if(10-i >= left){
			if(left == 0){
				int[] time = parseTime(bits);
				if(time[0]<12 && time[1]<=9)
					res.add(Integer.toString(time[0])+":0"+Integer.toString(time[1]));
				else if(time[0]<12 && time[1]<=59)
					res.add(Integer.toString(time[0])+":"+Integer.toString(time[1]));
			}else{
				dfs(bits, i+1, left, res);
				dfs(bits+(1<<i), i+1, left-1, res);
			}
		}
	}
	public static int[] parseTime(int bits){
		int[] res = new int[2];
		int hour = 0, min = 0;
		for(int i = 0; i<6; i++){
			min += (bits%2 << i);
			bits = bits >> 1;
		}
		for(int i = 0; i<4; i++){
			hour += (bits%2 << i);
			bits = bits >> 1;
		}
		res[0] = hour; res[1] = min;
		return res;
	}
	public static void main(String[] args) {
		int n = 2;
		System.out.println(readBinaryWatch(n).toString());
	}
}