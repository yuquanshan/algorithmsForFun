/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/
#include <iostream>

using namespace std;

struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};

class SwapNodesInPair {
public:
  ListNode* swapPairs(ListNode* head)
  {
    // play with linus' "good taste" :)
    ListNode** first = &head;
    while (*first != NULL && (*first)->next != NULL)
    {
      ListNode** ptr = &((*first)->next);
      ListNode* second = (*first)->next;
      (*first)->next = second->next;
      second->next = *first;
      *first = second;
      first = ptr;
    }
    return head;
  }
};

int main()
{
  SwapNodesInPair test;
  ListNode node1(0);
  ListNode node2(1);
  ListNode node3(2);
  node1.next = &node2;
  node2.next = &node3;
  ListNode* head = &node1;
  while (head != NULL) {
    cout << head->val << " ";
    head = head->next;
  }
  cout << endl;
  head = test.swapPairs(&node1);
  while (head != NULL) {
    cout << head->val << " ";
    head = head->next;
  }
  cout << endl;
  return 0;
}
