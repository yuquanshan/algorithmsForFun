/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner
 * as shown in the figure. rec1: (A, B) -> (C, D), rec2: (E, F) -> (G, H).
 *
 * int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
 */
#include <iostream>
#include <algorithm>

using namespace std;

class RecArea
{
public:
  int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
  {
    // first find the intersection between [A, C] and [E, G]
    int itv1 = (min(C, G) > max(A, E)) ? min(C, G) - max(A, E) : 0;
    // second find the intersection between [B, D] and [F, H]
    int itv2 = (min(D, H) > max(B, F)) ? min(D, H) - max(B, F) : 0;
    return  (C - A) * (D - B) + (G - E) * (H - F) - itv1 * itv2;
  }
};

int main()
{
  RecArea test;
  cout << test.computeArea(-3, 0, 3, 4, 0, -1, 9, 2) << endl;
  return 0;
}
