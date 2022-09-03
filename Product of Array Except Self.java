// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]
 

// Constraints:

// 2 <= nums.length <= 105
// -30 <= nums[i] <= 30
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

// Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

// Accepted
// 1,336,362
// Submissions
// 2,072,573
APPROACH 1 : BRUTE FORCE
Intuition and Algorithm The brute force approach is simple. Loop through each element x and find if there is another value that equals to target - x. As finding another value requires looping through the rest of array, its runtime complexity is O(n^2). See the code below.

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[]=new int[n];
        for(int i =0;i<n;i++){
            int product =1;
            for(int j =0;j<n;j++){
                if(i==j)continue;
                product*=nums[j];
            }
            res[i]=product;
        }
        return res;
    }
}

APPROACH 2: PREFIX SUFFIX ARRAY(explanation in copy)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int suff[]=new int[n];
        int pref[]=new int[n];
        suff[n-1]=1;
        pref[0]=1;
        for(int i =n-1;i>=0;i--){
            suff[i]=suff[i+1]*nums[i+1];
        }
        for(int i =1;i<n;i++){
            pref[i]=pref[i-1]*nums[i-1];
        }
        int[]res = new int [n];
        for(int i =0;i<n;i++){
            res[i]=suff[i]*pref[i];
        }
        return res;
    }
}