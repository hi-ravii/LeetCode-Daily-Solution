// 16. 3Sum Closest
// Medium

// 7395

// 405

// Add to List

// Share
// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.

 

// Example 1:

// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// Example 2:

// Input: nums = [0,0,0], target = 1
// Output: 0
// Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

// Constraints:

// 3 <= nums.length <= 1000
// -1000 <= nums[i] <= 1000
// -104 <= target <= 104
// Accepted
// 906,989
// Submissions
// 1,965,210

APPROACH 1 : BRUTE FORCE 
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    int diff = Math.abs(sum-target);
                    if(diff<min){
                        min = diff;
                        ans = sum;
                    }
                }
            }
        }
        return ans;        
    }
}
APPROACH 2 : USING TWO POINTERS
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n =nums.length;
        int min = Integer.MAX_VALUE;
        int ans =0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int start=i+1,end=n-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum==target)return target;
                else if(sum<target)start++;
                else end--;
                int diff =Math.abs(sum-target);
                if(diff<min){
                    min = diff;
                    ans = sum;
                }
            }
        }
        return ans;
    }
}