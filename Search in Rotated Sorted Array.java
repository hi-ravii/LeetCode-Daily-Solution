// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:

// Input: nums = [1], target = 0
// Output: -1
 

// Constraints:

// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// All values of nums are unique.
// nums is an ascending array that is possibly rotated.
// -104 <= target <= 104
// Accepted
// 1,610,034
// Submissions
// 4,211,828
class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target==nums[mid])return mid;
            //if the left side is sorted
            if(nums[l]<=nums[mid]){
                //and target lies in left half i.e, between left and mid
                if(target>=nums[l]&&target<nums[mid]){
                    r=mid-1;
                }//if target doesnt lie in left half
                else l=mid+1;
            }
            else{//if right half is sorted
                if(target<=nums[r]&&target>nums[mid]){//and target lies between mid and right
                    l=mid+1;
                }//if not lies on right half then move to the left of mid
                else r=mid-1;
            }
        }
        return -1;
    }
}