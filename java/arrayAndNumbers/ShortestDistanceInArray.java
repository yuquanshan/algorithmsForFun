/**
* Given a list of words and two words word1 and word2, return the shortest 
* distance between these two words in the list.
* 
* For example,
* Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
* 
* Given word1 = "coding", word2 = "practice", return 3.
* Given word1 = "makes", word2 = "coding", return 1.
* 
* public int shortestDistance(String[] words, String word1, String word2)
*/

public class ShortestDistanceInArray {
    public int shortestDistance(String[] words, String word1, String word2) {
        int shortest = Integer.MAX_VALUE;
        String tmp = null;
        int pos = 0;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1) || words[i].equals(word2)) {
                if(tmp == null) {
                    tmp = words[i];
                    pos = i;
                } else if(tmp.equals(words[i])) pos = i;
                else {
                    shortest = shortest>i-pos?i-pos:shortest;
                    tmp = words[i];
                    pos = i;
                }
            }
        }
        return shortest;
    }
    public static void main(String[] args) {
    	String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    	String word1 = "coding";
    	String word2 = "practice";
    	ShortestDistanceInArray test = new ShortestDistanceInArray();
    	System.out.println(test.shortestDistance(words, word1, word2));
    }
}