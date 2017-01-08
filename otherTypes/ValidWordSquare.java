/** Given a sequence of words, check whether it forms a valid word square.
*
* A sequence of words forms a valid word square if the kth row and column 
* read the exact same string, where 0 ≤ k < max(numRows, numColumns).
* 
* Note:
* The number of words given is at least 1 and does not exceed 500.
* Word length will be at least 1 and does not exceed 500.
* Each word contains only lowercase English alphabet a-z.
* Example 1:
* 
* Input:
* [
*   "abcd",
*   "bnrt",
*   "crmy",
*   "dtye"
* ] 
* Output:
* true
*
* Example 2:
* Input:
* [
*   "abcd",
*   "bnrt",
*   "crm",
*   "dt"
* ]
* Output:
* true
* 
* Therefore, it is a valid word square.
* Example 3:
* Input:
* [
*  "ball",
*  "area",
*  "read",
*  "lady"
* ]
* Output:
* false
*
* public boolean validWordSquare(List<String> words)
*/
import java.util.*;

public class ValidWordSquare{
  public static boolean validWordSquare(List<String> words){
    for(int i = 0; i<words.size(); i++){
      for(int j = 0; j<words.get(i).length(); j++){
        if(j >= words.size() || words.get(j).length() < i+1 || words.get(i).charAt(j) != words.get(j).charAt(i))
          return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    List<String> words = new ArrayList<String>();
    words.add("abcd"); words.add("bnrt"); words.add("crm"); words.add("dt");
    if(validWordSquare(words))
      System.out.println("Test1 passed");
  }
}