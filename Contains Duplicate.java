// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: true
// Example 2:

// Input: nums = [1,2,3,4]
// Output: false
// Example 3:

// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true
 

// Constraints:

// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109
// Accepted
// 2,000,668
// Submissions
// 3,272,046

APPROACH 1 : BRUTE FORCE

class Solution{
    public boolean containsDuplicate(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }    
}
APPROACH 2 : SORTING
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i =0;i<nums.length-1;i++)
            if(nums[i]==nums[i+1])return true;
        return false;
    }
}
APPROACH 3 : HASHSET
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer>set = new HashSet();
        for(int i =0;i<nums.length;i++){
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
        }
        return false;
    }
}
APPROACH 4 : HASHMAP
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer>map = new HashMap();
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i]))return true;
            map.put(nums[i],1);
        }
        return false;
    }
}
APPROACH 5 : HASHMAP
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>1)return true;
        }
        return false;
    }
}