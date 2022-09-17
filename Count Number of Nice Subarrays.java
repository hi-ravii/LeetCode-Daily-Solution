// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

// Return the number of nice sub-arrays.

 

// Example 1:

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
// Example 2:

// Input: nums = [2,4,6], k = 1
// Output: 0
// Explanation: There is no odd numbers in the array.
// Example 3:

// Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
// Output: 16
 

// Constraints:

// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10^5
// 1 <= k <= nums.length
// Accepted
// 62,829
// Submissions
// 106,206
APPROACH 1 : BRUTE FORCE
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int res =0;
        for(int i =0;i<n;i++){
            int odd =0;
            for(int j =i;j<n;j++){
                if(nums[j]%2==1)odd++;
                if(odd==k)res++;
            }
        }
        return res;        
    }
}
APPROACH 2: SLIDING WINDOW
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int res =0;
        int odd =0;
        int i =0;
        int j =0;
        while(j<n){
            if(nums[j]%2==1)odd++;
            if(odd==k){
                int temp =j;
                while(j<n && nums[j]%2==0)j++;
                int right =j-temp;
                int left =1;
                while(nums[i]%2==0){
                    left++;
                    i++;
                }
                res+=left*right;
                i++;
                odd--;
            }
            j++;
        }
        return res;                    
    }
}

APPROACH 3: HASHMAP

