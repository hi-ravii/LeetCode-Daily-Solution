// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109
// Accepted
// 1,239,264
// Submissions
// 3,013,302
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[]=new int[2];
        int l=0,r=nums.length-1;
        int res =-1;
        ans[0]=firstOcurrence(nums,target,l,r,res);
        ans[1]=secondOcurrence(nums,target,l,r,res);
        return ans;
    }
    public int firstOcurrence(int[] nums, int target,int l,int r,int res){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target==nums[mid]){//if we get the target 
                res=mid;//we store it to res
                r=mid-1;//to find the first occurence we move to the left part
            }//rest code remains the same
            else if(target>nums[mid])l=mid+1;
            else r=mid-1;
        }
        return res;
    }
    public int secondOcurrence(int[] nums, int target,int l,int r,int res){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target==nums[mid]){//if we get the target
                res=mid;//we store it in mid
                l=mid+1;//we move to the right part to find the rightmost(last) occurenece
            }//rest code remains same
            else if(target>nums[mid])l=mid+1;
            else r=mid-1;
        }
        return res;
    }
}