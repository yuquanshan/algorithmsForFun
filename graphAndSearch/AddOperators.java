/** Given a string that contains only digits 0-9 and a target value, 
* return all possibilities to add binary operators (not unary) +, 
* -, or * between the digits so they evaluate to the target value.
*
* Examples: 
* "123", 6 -> ["1+2+3", "1*2*3"] 
* "232", 8 -> ["2*3+2", "2+3*2"]
* "105", 5 -> ["1*0+5","10-5"]
* "00", 0 -> ["0+0", "0-0", "0*0"]
* "3456237490", 9191 -> []
* public List<String> addOperators(String num, int target)
*/
import java.util.*;

public class AddOperators{
	public static List<String> addOperators(String num, int target){
		List<String> res = new ArrayList<String>();
		if(num == null || num.length() == 0)
			return res;
		int[] array = new int[num.length()];
		for(int i = 0; i < num.length(); i++)
			array[i] = Integer.valueOf(num.charAt(i));
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> ops = new ArrayList<Integer>();	// positions to add + or -, after ith number
		mergeDfs(list, array, ops, 0, res, target);	// merge by *
		return res;
	}
	private static void mergeDfs(List<Integer> list, int[] array, List<Integer> ops, int i, List<String> res, int target){
		if(i == array.length - 1)
			lowerDfs(0, 0, list, array, ops, res, target);
		// first option: merge by *
		int tmp = list.remove(list.size()-1);
		list.add(tmp * array[i + 1]);
		mergeDfs(list, array, ops, i + 1, res);
		list.remove(list.size()-1);
		list.add(tmp);
		// second option: separate by + or -
		list.add(array[i + 1]);
		ops.add(i);
		mergeDfs(list, array, ops, i + 1, res);
		list.remove(list.size());
	}
	private static void lowerDfs(int acc, int offset, List<Integer> list, int[] array, List<Integer> ops, List<String> res, int target){	// DFS for + and -
		if(offset == list.size() - 1){
			if(acc == target)
				putRes(array, ops, );
		}
	}
}