// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

// A subarray is a contiguous part of the array.

 

// Example 1:

// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// Example 2:

// Input: nums = [0,0,0,0,0], goal = 0
// Output: 15
 

// Constraints:

// 1 <= nums.length <= 3 * 104
// nums[i] is either 0 or 1.
// 0 <= goal <= nums.length
// Accepted
// 53,492
// Submissions
// 106,106
APPROACH 1: BRUTE FORCE
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int res = 0;
        for(int i =0;i<n;i++){
            int sum = 0;
            for(int j =i;j<n;j++){
                sum+=nums[j];
                if(sum==goal){
                    res++;
                }
            }
        }
        return res;
    }
}

APPROACH 2: HashMap + Prefix Sum
class Solution {//this solution will work for all the positive as well as negative no
    public int numSubarraysWithSum(int[] nums, int goal) {//pepcoding video
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);//puting a 0 for comparing
        int res=0,sum=0;
        for(int i =0;i<nums.length;i++){
            sum +=nums[i];
            if(map.containsKey(sum-goal)){
                res+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i=0,j=0,res=0;
        int sum =0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        while(j<nums.length){
            sum+=nums[j];
            if(map.containsKey(sum-goal)){
                res+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            j++;
        }
        return res;
    }
}
