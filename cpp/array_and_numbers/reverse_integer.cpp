/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
*/

#include <iostream>

using namespace std;

class ReverseInt
{
public:
  int reverse(int x)
  {
    int res = 0;
    while (x != 0) {
      // overflow check...
      if (res < INT_MIN / 10 || res > INT_MAX / 10) {
        return 0;
      }
      if ((res < 0 && res * 10 < INT_MIN - x % 10) ||
          (res > 0 && res * 10 > INT_MAX - x % 10)) {
        return 0;
      }
      res = res * 10 + x % 10;
      x /= 10;
    }
    return res;
  }
};

int main()
{
  ReverseInt test;
  int x = 123;
  cout << x << "->" << test.reverse(x) << endl;
  x = 1534236469;
  cout << x << "->" << test.reverse(x) << endl;
  return 0;
}
