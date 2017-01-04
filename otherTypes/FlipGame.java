/** You are playing the following Flip Game with your friend: Given a string 
* that contains only these two characters: + and -, you and your friend take 
* turns to flip two consecutive "++" into "--". The game ends when a person 
* can no longer make a move and therefore the other person will be the winner.
*
* Write a function to determine if the starting player can guarantee a win.
*
* For example, given s = "++++", return true. The starting player can guarantee 
* a win by flipping the middle "++" to become "+--+".
* public boolean canWin(String s)
*/

public class FlipGame{
	public static boolean canWin(String s){
		if(s == null || s.length() <= 1)
			return false;
		char[] c = s.toCharArray();
		return mustWin(c);
	}
	public static boolean mustWin(char[] c){
		boolean res = false;
		for(int i = 0; i<c.length-1; i++){
			if(c[i] == '+' && c[i+1] == '+'){
				c[i] = '-'; c[i+1] = '-';
				res = res || mustLose(c);
				c[i] = '+'; c[i+1] = '+';
			}
		}
		return res;
	}
	public static boolean mustLose(char[] c){
		boolean res = true;
		for(int i = 0; i<c.length-1; i++){
			if(c[i] == '+' && c[i+1] == '+'){
				c[i] = '-'; c[i+1] = '-';
				res = res && mustWin(c);
				c[i] = '+'; c[i+1] = '+';
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String s = "++++";
		if(canWin(s))
			System.out.format("given %s, starter can guarantee a win\n",s);
		else
			System.out.format("given %s, starter cannot guarantee a win\n",s);
	}
}
