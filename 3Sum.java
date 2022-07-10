// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

 

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[1] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:

// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.
 

// Constraints:

// 3 <= nums.length <= 3000
// -105 <= nums[i] <= 105
// Accepted
// 2.1M
// Submissions
// 6.6M
APPROACH 1: using set
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n==0)return new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j =i+1;
            int k = n-1;
            while(j<k){
                int sum =nums[i]+nums[j]+nums[k];
                if(sum==0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                if(sum>0)k--;
                if(sum<0)j++;
            }
        }
        return new ArrayList<>(set);
    }
}
Approach 2: 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n==0)return new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j =i+1;
            int k = n-1;
            while(j<k){
                int sum =nums[i]+nums[j]+nums[k];
                if(sum==0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                if(sum>0)k--;
                if(sum<0)j++;
            }
        }
        return new ArrayList<>(set);
    }
}
