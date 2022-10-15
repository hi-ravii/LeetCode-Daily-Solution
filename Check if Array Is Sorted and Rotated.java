// Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

// There may be duplicates in the original array.

// Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

 

// Example 1:

// Input: nums = [3,4,5,1,2]
// Output: true
// Explanation: [1,2,3,4,5] is the original sorted array.
// You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
// Example 2:

// Input: nums = [2,1,3,4]
// Output: false
// Explanation: There is no sorted array once rotated that can make nums.
// Example 3:

// Input: nums = [1,2,3]
// Output: true
// Explanation: [1,2,3] is the original sorted array.
// You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100

APPROACH 1: CHECKING FOR NO . OF NON SORTED elements
if non sorted elements is more than 1 then return false else return true;
class Solution {
    public boolean check(int[] nums) {
        
        int checker = 0;
        
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] > nums[i]) checker++;
        }
        
		
		//checking if the last element is greater than the first
        if (nums[nums.length - 1] > nums[0]) checker++;//important edge case
        //One thing to be kept in mind is that for a cycle to be correctly present in case of rotation the last element must be smaller than the first, else the array won't be sorted so that case has to be handled.
        
        return checker > 1 ? false : true;
    }
}
APPROACH 2: pointer which points toward the first non sorted element and then check for the rest 
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if(nums[n-1]>nums[0])
        {
            for(int i=0;i<n-1;i++)
            {
                if(nums[i]>nums[i+1])
                    return false;
            }
            return true;
        }
        else
        {
            int count=0;
            for(int i=0;i<n-1;i++)
            {
                if(nums[i]>nums[i+1])
                {
                    count=i+1;
                    break;
                }
            }
            for(int i=count;i<n-1;i++)
            {
                if(nums[i]>nums[i+1])
                    return false;
            }
            return true;
        }
    }
}