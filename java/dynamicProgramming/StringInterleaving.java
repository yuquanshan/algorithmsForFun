/**
* given three strings s1, s2, s3, return if s3 can be obtained by interleaving s1 and s2. 
* public boolean interleaving(String s1, String s2, String s3)
*/

public class StringInterleaving{
	public static boolean interleaving(String s1, String s2, String s3){
		if(s1 == null){
			if(s2 == null)
				return (s3 == null) || (s3.length()==0);
		}else if(s2 == null){
			return s1.equals(s3);
		}
		if(s1.length()+s2.length() != s3.length())
			return false;
		if(s1.length()==0)
			return s2.equals(s3);
		if(s2.length()==0)
			return s1.equals(s3);
		// table[i][j] records whether first i chars in s1 and first j chars in s2 can interleave first i+j chars in s3
		boolean[][] table = new boolean[s1.length()+1][s2.length()+1];
		table[0][0] = true;
		for(int i = 1; i<=s1.length();i++){
			if(s1.charAt(i-1) == s3.charAt(i-1))
			 	table[i][0] = table[i-1][0];
		}
		for(int i = 1; i<=s2.length();i++){
			if(s2.charAt(i-1) == s3.charAt(i-1))
				table[0][i] = table[0][i-1];
		}
		for(int i = 1; i<=s1.length(); i++){
			for(int j=1; j<=s2.length(); j++){
				int success = 0;
				if(s1.charAt(i-1) == s3.charAt(i+j-1) && table[i-1][j]){
					table[i][j] = true;
					success++;
				}
				if(s2.charAt(j-1) == s3.charAt(i+j-1) && table[i][j-1]){
					table[i][j] = true;
					success++;
				}
				if(success == 0)
					table[i][j] = false;
			}
		}
		return table[s1.length()][s2.length()];
	}
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		if(interleaving(s1,s2,s3))
			System.out.println(s3 + " can be obtained by interleaving "+s1+" and "+s2);
		else
			System.out.println(s3 + " cannot be obtained by interleaving "+s1+" and "+s2);
	}
}