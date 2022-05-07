// Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

// Return true if there is a 132 pattern in nums, otherwise, return false.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: false
// Explanation: There is no 132 pattern in the sequence.
// Example 2:

// Input: nums = [3,1,4,2]
// Output: true
// Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
// Example 3:

// Input: nums = [-1,3,2,0]
// Output: true
// Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

// Constraints:

// n == nums.length
// 1 <= n <= 2 * 105
// -109 <= nums[i] <= 109
APROACH 1: BRUTE FORCE {TLE}

class Solution {
    public boolean find132pattern(int[] nums) {
        for(int i = 0; i < nums.length - 2; ++i){
            if(nums[i] >= nums[i + 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length - 1; ++j){
                if(nums[j] <= nums[j + 1]){
                    continue;
                }
                for(int k = j + 1; k < nums.length; ++k){
                    if(nums[k] >= nums[j] || nums[k] <= nums[i]){
                        continue;
                    }
                    return true;
                }
                
                i = j;
                break;
            }
        }
        
        return false;
    }
    
}
APROACH 2 : USING STACK

class Solution {
    
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return false;
        }
        int[] mins = new int[n];
        // make list of mins at num index
        mins[0]=nums[0];
        for(int i=1;i<n;i++){
            mins[i] = Math.min(mins[i-1],nums[i]);
        }
        Stack<Integer> stack = new Stack<>(); // keep track of potential k's in decreasing order
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(nums[i]);
            };
            while(!stack.isEmpty() && stack.peek() <= mins[i]){ // while potential k is smaller than i
                stack.pop();
            }
            if(stack.isEmpty()){ // no more potential k's
                stack.push(nums[i]);
                continue;
            }
            if(stack.peek() >= nums[i]){ // bigger than j
                stack.push(nums[i]);
            }else if(stack.peek() > mins[i]){ // between i and j
                return true;
            }
        }
        return false;
    }
}
APROACH 3: GREEDY {WITHOUT STACK}

class Solution {
    
    public boolean find132pattern(int[] nums) {
        int[] rmax = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            rmax[i] = i + 1 < nums.length ? Math.max(rmax[i + 1], nums[i]) : nums[i];
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            if (min > nums[i - 2] && (rmax[i] <= min || nums[i - 1] >= max)) {
                min = nums[i - 2];
                max = nums[i - 1];
            } else {
				max = Math.max(nums[i - 1], max);
			}
            if (min < nums[i] && nums[i] < max) {
                return true;
            }
        }
        return false;
    }

}