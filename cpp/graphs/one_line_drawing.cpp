/**
 * given a interconnected node, can you use one line to reconstruct
 * the network?
 * void oneLineDrawing(int** links, int n)
 * links: 2-D array indicating the double links between nodes
 * n: the length of the links
 * can be used as astrarium solver in Dragon Age: Inquisition.
 */

#include <iostream>
#include <iterator>
#include <algorithm>
#include <map>
#include <set>
#include <vector>

using namespace std;

class OneLineDrawing
{
public:
  void oneLineDrawing(int links[][2], int n)
  {
    unique_ptr<vector<int>> v(new vector<int>());
    unique_ptr<map<int, set<int>*>> m(new map<int, set<int>*>());
    vector<int> ns;
    for (int i = 0; i < n; i++) {
      int a = links[i][0];
      int b = links[i][1];
      if (m->find(b) != m->end()) {
        m->find(b)->second->insert(a);
      } else {
        set<int>* tmp = new set<int>();
        m->insert(pair<int, set<int>*>(b, tmp));
        m->find(b)->second->insert(a);
        ns.push_back(b);
      }
      if (m->find(a) != m->end()) {
        m->find(a)->second->insert(b);
      } else {
        set<int>* tmp = new set<int>();
        m->insert(pair<int, set<int>*>(a, tmp));
        m->find(a)->second->insert(b);
        ns.push_back(a);
      }
    }
    for (auto it = ns.begin(); it != ns.end(); it++) {
      v->push_back(*it);
      int res = dfs_search(m.get(), *it, v.get(), n);
      if (res == 1) {
        for (auto it1 = v->begin(); it1 != v->end(); it1++) {
          cout << *it1 << " ";
        }
        cout << endl;
        break;
      } else {
        v->pop_back();
      }
    }
    for (auto it = m->begin(); it != m->end(); it++) {
      delete it->second;
    }
  }
  int dfs_search(map<int, set<int>*>* nodes, int curr,
                 vector<int>* lst, int countdown)
  {
    if (countdown == 0) return 1;
    auto f = nodes->find(curr);
    if (f == nodes->end()) {
      return 0;
    }
    vector<int> s;
    copy(f->second->begin(), f->second->end(), back_inserter(s));
    for (auto it = s.begin(); it != s.end(); it++) {
      int nc = *it;
      lst->push_back(nc);
      nodes->find(curr)->second->erase(nc);
      nodes->find(nc)->second->erase(curr);
      countdown--;
      if (dfs_search(nodes, nc, lst, countdown) != 0) {
        return 1;
      } else {
        countdown++;
        lst->pop_back();
        nodes->find(curr)->second->insert(nc);
        nodes->find(nc)->second->insert(curr);
      }
    }
    return 0;
  }
};


int main()
{
  OneLineDrawing test;
  // triangle
  int triangle[3][2] = {{1, 2}, {2, 3}, {3, 1}};
  test.oneLineDrawing(triangle, 3);
  // Kabbalah (tree of life)
  int kabbalah[22][2] =
  {
  {1, 2},
  {1, 3},
  {1, 6},
  {2, 6},
  {2, 3},
  {2, 4},
  {3, 6},
  {3, 5},
  {4, 5},
  {4, 6},
  {4, 7},
  {5, 6},
  {5, 8},
  {6, 7},
  {6, 8},
  {6, 9},
  {7 ,8},
  {7, 9},
  {7, 10},
  {8, 9},
  {8, 10},
  {9, 10}
  };
  // test.oneLineDrawing(kabbalah, 22);
  int fervenial[22][2] =
  {
  {1, 2},
  {1, 3},
  {2, 3},
  {3, 4},
  {4, 5},
  {3, 5},
  {3, 6},
  {3, 7},
  {6, 8},
  {8, 10},
  {10, 9},
  {9, 7},
  {8, 11},
  {11, 12},
  {12, 10},
  {10, 13},
  {13, 14},
  {14, 9},
  {3, 8},
  {3, 9},
  {6, 10},
  {7, 10}
  };
  test.oneLineDrawing(fervenial, 22);
  return 0;
}
