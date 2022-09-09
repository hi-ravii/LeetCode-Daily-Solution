// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

// Constraints:

// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
// 0 <= k <= nums.length
// Accepted
// 239.5K
// Submissions
// 377.3K
APPROACH 1 : BRUTE FORCE
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for(int i =0;i<n;i++){
            int count = 0;
            for(int j =i;j<n;j++){
                if(nums[j]==0){
                    count++;
                }
                if(count<=k){
                    res = Math.max(res,j-i+1);
                }
            }
        }
        return res;      
    }
}

APPROACH 2 : SLIDING WINDOW
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0,maxSize=0;//max size to store max valid window size 
        int zeroCount=0;//we will take a count which will count the no. of zeros present in the current window
        for(j =0;j<nums.length;j++){//moving j till end of array
            if(nums[j]==0)zeroCount++;//while hitting zero every time we increase its zero count
            while(zeroCount>k ){//if count become greater than k which means invalid window then we start moving i to decrease the size of the window as well as decrease count every time a 0 is found at i index
                if(nums[i]==0){
                    zeroCount--;
                }
                i++;//moving the window forward
            }
            maxSize=Math.max(maxSize,j-i+1);//storing max window size
        }
        return maxSize;
    }
}