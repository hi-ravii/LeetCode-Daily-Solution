// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

// Example 1:

// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5
// Example 2:

// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4
 

// Constraints:

// 1 <= k <= nums.length <= 104
// -104 <= nums[i] <= 104
// Accepted
// 1,397,268
// Submissions
// 2,167,828
APPROCH :1

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int []ans = new int[k];
        int n = nums.length-1;
        int j =0;
        for(int i =n;i>=n-k+1;i--){
            ans[j]=nums[i];
            j++;
        }
        return ans[k-1];
    }
}