// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]
 

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
 

// Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
// Accepted
// 7.6M
// Submissions
// 15.6M
APPROACH 1: BRUTE FORCE
Intuition and Algorithm The brute force approach is simple. Loop through each element x and find if there is another value that equals to target - x. As finding another value requires looping through the rest of array, its runtime complexity is O(n^2). See the code below.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target)return new int[]{i,j};
            }
        }
        return new int[]{};
    }
}
APPROACH 2: HASHMAP
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int res = target-nums[i];
            if(map.containsKey(res)){
                int index =map.get(res);
                if(index ==i)continue;
                else return new int[]{i,map.get(res)};
            }
        }
        return new int[]{};
    }
}