/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

class TwoSum
{
public:
  vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> map;
    vector<int> res;
    for (int i = 0; i < nums.size(); i++) {
      auto it = map.find(target - nums[i]);
      if (it != map.end()) {
        res.push_back(it->second);
        res.push_back(i);
        break;
      } else {
        map.insert({{nums[i], i}});
      }
    }
    return res;
  }
};

int main()
{
  TwoSum test;
  int array[] = {2, 7, 11, 15};
  int target = 9;
  vector<int> nums(array, array + 4);
  vector<int> res = test.twoSum(nums, target);
  for (auto it : res) {
    cout << it << " ";
  }
  cout << endl;
  return 0;
}
