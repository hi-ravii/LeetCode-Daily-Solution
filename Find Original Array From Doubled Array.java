// An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.

// Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.

 

// Example 1:

// Input: changed = [1,3,4,2,6,8]
// Output: [1,3,4]
// Explanation: One possible original array could be [1,3,4]:
// - Twice the value of 1 is 1 * 2 = 2.
// - Twice the value of 3 is 3 * 2 = 6.
// - Twice the value of 4 is 4 * 2 = 8.
// Other original arrays could be [4,3,1] or [3,1,4].
// Example 2:

// Input: changed = [6,3,0,1]
// Output: []
// Explanation: changed is not a doubled array.
// Example 3:

// Input: changed = [1]
// Output: []
// Explanation: changed is not a doubled array.
 

// Constraints:

// 1 <= changed.length <= 105
// 0 <= changed[i] <= 105
// Accepted
// 109,063
// Submissions
// 265,065
APPROACH 1 : BRUTE FORCE
class Solution {
    public int[] findOriginalArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int[]ans = new int[n/2];
        if(n%2!=0)return new int[]{};
        for(int v :nums){
            map.put(v,map.getOrDefault(v,0)+1);
        }
        
        int k =0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int x = nums[i];
            int key = x*2;
            if(map.get(x)<=0)continue;// if we have already decreased it's value when we were checking y/2 value, like 2,4 we will remove 4 also when we will check 2 but our iteration will come again on 4.
      
            if(map.getOrDefault(key,0)<=0)return new int[]{};// if we have y but not y*2 return vacant array
            ans[k++]=x;
            // if we have both y and y*2, store in our ans array
           // decrease the frequency of y and y*2
            map.put(x,map.get(x)-1);
            map.put(key,map.get(key)-1);   
        }
        return ans;
    }
}