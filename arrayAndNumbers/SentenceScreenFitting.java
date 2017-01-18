/**
* given a rows*cols screeen and a sentence represented by a list 
* of words, find how many same sentences the screen can hold, two 
* consecutive words in a line must be separated by a single space.
* for example, rows = 3, cols = 6, sentence = ["a", "bcd", "e"], 
* output = 3, because 
*	a-bcd- 
*	e-a---
*	bcd-e-
* public static int wordsTyping(String[] sentence, int rows, int cols){}
* (the naive word-by-word fitting in my first approach would lead to TLE)
*/

import java.util.*;

public class SentenceScreenFitting{
	public static int wordsTyping(String[] sentence, int rows, int cols){
		/*
			explanation: given, say, ["hello", "world"], and col = 7, if we can "bend"
			the word, then the first row would be "hello w", however, we can't "bend"
			any word, so, the *effective space* the first row can offer is "hello " = 6.
			and if we expand the first two rows, we have
				hello X
				world X
			"X" is the space that exits in the lines, however cannot contribute anything 
			for fitting the sentence.
			so the basic idea of this bright algorithm is calculate the effective space 
			each row can contribute. after that we can concatenate those effective spaces 
			together and fit the sentence without considering the word would "bend" or not.
			original solution see https://discuss.leetcode.com/topic/62455/21ms-18-lines-java-solution/5
		*/
		String str = String.join(" ", sentence) + " ";
		int slen = str.length();
		int effective_space = 0;
		for(int i = 1; i<=rows; i++){
			effective_space += cols;
			if(str.charAt(effective_space%slen) == ' '){	// ' ' will show in the first space in the next line, extra bonus!
				effective_space++;
			}else{
				while(effective_space > 0 && str.charAt((effective_space-1)%slen)!=' ')	// if word "bends", shrink effective space, can create a map for different offset, so time of repetivie "effective_space--" can be saved!
					effective_space--;
			}
		}
		return effective_space/slen;
	}
	public static void main(String[] args) {
		String[] sentence = {"I", "had", "apple", "pie"};
		int rows = 4, cols = 5;
		System.out.println(wordsTyping(sentence,rows,cols));
	}
}