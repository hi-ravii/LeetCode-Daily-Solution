// Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

 

// Example 1:

// Input: nums = [2,1,2]
// Output: 5
// Example 2:

// Input: nums = [1,2,1]
// Output: 0
 

// Constraints:

// 3 <= nums.length <= 104
// 1 <= nums[i] <= 106

APPROACH 1 : BRUTE FORCE
class Solution {
    public int largestPerimeter(int[] nums) {
        int max = 0;
        for(int i =0;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                for(int k =j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]>nums[k] && nums[i]+nums[k]>nums[j] && nums[j]+nums[k]>nums[i]){
                        max = Math.max(max,nums[i]+nums[j]+nums[k]);
                    }
                }
            }
        }
        return max;        
    }
}

APPROACH 2 : SORTING
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i =nums.length-1;i>=2;i--){
            if(nums[i]<nums[i-1]+nums[i-2])return nums[i]+nums[i-1]+nums[i-2];
        }
        return 0;
    }
}

