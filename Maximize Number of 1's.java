// Given a binary array arr of size N and an integer M. Find the maximum number of consecutive 1's produced by flipping at most M 0's.
 

// Example 1:

// Input:
// N = 3
// arr[] = {1, 0, 1}
// M = 1
// Output:
// 3
// Explanation:
// Maximum subarray is of size 3
// which can be made subarray of all 1 after
// flipping two zeros to 1.
// Example 2:

// Input:
// N = 11
// arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
// M = 2
// Output:
// 8
// Explanation:
// Maximum subarray is of size 8
// which can be made subarray of all 1 after
// flipping two zeros to 1.
 

// Your Task:
// Complete the function findZeroes() which takes array arr and two integers n, m, as input parameters and returns an integer denoting the answer.
 

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)
 

// Constraints:
// 1 <= N <= 107
// 0 <= M <= N
// 0 <= arri <= 1
APPROACH 1: BRUTE FORCE
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max =0;
        for(int i =0;i<nums.length;i++){
            int count =0;
            for(int j =i;j<nums.length;j++){
                if(nums[j]==0)count++;
                if(count>m)break;
                max = Math.max(max,j-i+1);
            }
        }
        return max;
    }
}
AAPROACH 2: Sliding Window
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max =0;
        int count =0;
        int i =0;
        for(int j =0;j<nums.length;j++){
            if(nums[j]==0)count++;
            while(count>m){
                if(nums[i]==0)count--;
                i++;
            }
            max = Math.max(max,j-i+1);
        }
        return max;
    }
}
APPROACH 3 : Sliding Window Optimized
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max =0;
        int count =0;
        int i =0;
        for(int j =0;j<nums.length;j++){
            if(nums[j]==0)count++;
            if(count>m){
                if(nums[i]==0)count--;
                i++;
            }
            max = Math.max(max,j-i+1);
        }
        return max;
    }
}