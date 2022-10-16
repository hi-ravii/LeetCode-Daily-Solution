// Given an array, rotate the array to the right by k steps, where k is non-negative.

 

// Example 1:

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:

// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
 

// Constraints:

// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105
 

// Follow up:

// Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
// Could you do it in-place with O(1) extra space?
// Accepted
// 1,293,343
// Submissions
// 3,303,435

APPROACH 1 : USING TEMP ARRAY

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k =k%n;// if k is greater than n then we will get same array as output so we will take mod of k with n 
        int[]res=new int[n];
        int j =0;
        for(int i=n-k;i<n;i++){
            res[j++]=nums[i];
        }
        for(int i=0;i<n-k;i++){
            res[j++]=nums[i];
        }
        for(int i =0;i<n;i++){
            nums[i]=res[i];
        }
    }
}

APPROACH 2: USING REVERSE
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        rev(nums,0 , n-k-1);
        rev(nums,n-k,n-1);
        rev(nums,0,n-1);
        
    }
    public void rev (int[] nums,int s , int e){
        while(s<e){
            int temp = nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
}