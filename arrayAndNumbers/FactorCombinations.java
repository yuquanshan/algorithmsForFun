/** Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible
 * combinations of its factors.
 *
 * Note: 
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Examples: 
 * input: 1
 * output: 
 * []
 * input: 12
 * output:
 * [
 *  [2, 6],
 *  [2, 2, 3],
 *  [3, 4]
 * ]
 * public List<List<Integer>> getFactors(int n)
 */
import java.util.*;

public class FactorCombinations {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    int start = 2;
    while (start * start <= n) {
      if (n%start == 0) {
        LinkedList<LinkedList<Integer>> tmp = helper(n/start, start);
        for (LinkedList<Integer> l: tmp) {
          l.addFirst(start);
          res.add(l);
        }
      }
      start++;
    }
    return res;
  }
  public LinkedList<LinkedList<Integer>> helper(int n, int start) {
    LinkedList<LinkedList<Integer>> res = 
      new LinkedList<LinkedList<Integer>>();
    while (start * start <= n) {
      if (n%start == 0) {
        LinkedList<LinkedList<Integer>> tmp = helper(n/start, start);
        for (LinkedList<Integer> l: tmp) {
          l.addFirst(start);
          res.add(l);
        }
      }
      start++;
    }
    LinkedList<Integer> self = new LinkedList<Integer>();
    self.add(n);
    res.add(self);
    return res;
  }
  public static void main(String[] args) {
    FactorCombinations test = new FactorCombinations();
    List<List<Integer>> res = test.getFactors(12);
    for (List<Integer> l: res) System.out.println(l);
  }
}