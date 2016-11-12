/**
* given two words start and end and a dictionary dict, find the length of 
* shortest word ladder between start and end.
* public static int ladderLength(String start, String end, Set<String> dict)
*/
import java.util.*;

public class ShortestWordLadder{
  public static int ladderLength(String start, String end, Set<String> dict){
    if(start.equals(end)){
      return 1;
    }
    dict.add(end);
    Queue<String> queue = new LinkedList<String>();
    Set<String> visited = new HashSet<String>();
    queue.add(start);
    int len = 1;
    while(queue.size()!=0){
      int size = queue.size();
      len++;
      for(int i=0; i<size; i++){
        String str = queue.remove();
        List<String> neighbors = neighbors(str,dict);
        for(String s: neighbors){
          if(!visited.contains(s)){
            visited.add(s);
            if(s.equals(end))
              return len;
            else
              queue.add(s);
          }
        }
      }
    }
    return Integer.MAX_VALUE;
  }
  public static List<String> neighbors(String str, Set<String> dict){
    ArrayList<String> res = new ArrayList<String>();
    for(int i = 0; i<str.length(); i++){
      for(char c = 'a'; c<='z'; c++){
        if(str.charAt(i)!=c){
          String nstr = str.substring(0,i)+c+str.substring(i+1);
          if(dict.contains(nstr)){
            res.add(nstr);
          }
        }
      }
    }
    return res;
  }
  public static void main(String[] args) {
    String start = "hit";
    String end = "cog";
    Set<String> set = new HashSet<String>();
    set.add("hot");
    set.add("dot");
    set.add("dog");
    set.add("lot");
    set.add("log");
    int res = ladderLength(start,end,set);
    System.out.format("The length of shortest word ladder is %d.\n",res);
  }
}