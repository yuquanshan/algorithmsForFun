/*
Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

#include <iostream>
#include <algorithm>

using namespace std;

class LongestParlinSubstr
{
public:
  // using Manacher’s algorithm, the key fact is
  // .....|..P1..C..P2..|.......
  // let C be the center of a Palindrone, | <- C is its left radius
  // under the "sphere" of C, P1 and P2 are *partially* symmetric
  // (until C's right '|'). noting this fact allows us to skip
  // useless steps when expanding P2. Of course P2 may expand
  // beyond C's right '|', becoming the new trailer blazer (new C)
  // exploring the virginland, lighting for P2's right fellas.
  // ref: https://articles.leetcode.com/longest-palindromic-substring-part-ii/
  // total complexity is 2n, n for visiting each character, the other n
  // for exploring the virginland.
  string longestPalindrome2(string s)
  {
    int virlen = s.length() * 2 + 1;  // virtual length after helper expansion
    int longestsofar = 0;
    int longeststart = 0;
    int P[virlen];    // storing center i's radius
    int center = 0;   // tracking current center
    int P[0] = 0;

    for (int i = 1; i < virlen; i++) {
      // if i is covered by center's radius
      if (center + P[center] > i) {
        int mirror = 2 * center - i;
        // in the hope of boosting i's expansion
        P[i] = min(P[mirror], center + P[center] - i);
      } else {
        P[i] = 0;
      }

      while (i - P[i] - 1 >= 0 && i + P[i] + 1 < virlen
             && helperMapper(i-P[i]-1, s) == helperMapper(i+P[i]+1, s)) {
        P[i]++;
      }
      if (2 * P[i] + 1 > longestsofar) {
        longestsofar = 2 * P[i] + 1;
        longeststart = i - P[i];
      }
      // is i the new trailer blazer (center)?
      if (P[i] + i > center + P[center]) {
        center = i;
      }
    }
    return s.substr(longeststart / 2, longestsofar / 2);
  }
  // dynamic programming approach O(n^2); another center-expanding algorithm
  // was given in java.
  string longestPalindrome(string s)
  {
    if (s.length() <= 1) {
      return s;
    }
    int len = s.length();
    int tbl[len][len];
    int longestsofar = 1;
    int longestpos = 0;
    for (int i = 1; i < len; i++) {
    	fill(tbl[i], tbl[i] + len, 0);
    }
    fill(tbl[0], tbl[0] + len, 1);
    for (int k = 0; k < len - 1; k++) {
      if (s[k + 1] == s[k]) {
        tbl[1][k] = 1;
        longestsofar = 2;
        longestpos = k;
      }
    }
    for (int i = 2; i < len; i++) {
      // i + 1 is the current substr len
      for (int j = 0; j <= len - i - 1; j++) {
        if (tbl[i - 2][j + 1] == 1 && s[j + i] == s[j]) {
          tbl[i][j] = 1;
          longestsofar = i + 1;
          longestpos = j;
        }
      }
    }
    return s.substr(longestpos, longestsofar);
  }
private:
  // equivalently inserting specially character in order to help
  // centering the palindrone with even length
  char helperMapper(int pos, string& s)
  {
    if (pos % 2 == 1) {
      return s[(pos - 1) / 2];
    } else {
      // return a special character
      return '#';
    }
  }
};

int main()
{
  // string s = "babaddtattarrattatddetartrateedredividerb";
  string s = "babad";
  LongestParlinSubstr test;
  string res = test.longestPalindrome(s);
  cout << res << endl;
  res = test.longestPalindrome2(s);
  cout << res << endl;
  return 0;
}
