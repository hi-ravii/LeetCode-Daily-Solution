// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.
 

// Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//key is the number and value is the frequency
        for(int i : nums){ map.put(i, map.getOrDefault(i, 0) + 1); }//put the number and its frequency into the map
        
        Queue<Integer> maxheap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));//maxheap to store the keys of the map in descending order of their frequency
        for(int key : map.keySet())//map.keySet() returns all the keys contained in this map
            maxheap.add(key);
        {//add all the keys to the maxheap
            maxheap.add(key);
        }
        
        int ans[] = new int[k];//array to store the answer with size k
        for(int i = 0; i < k; i++){//add the first k elements of the maxheap to the answer array
            ans[i] = maxheap.poll();//poll() removes the head of the queue
        }
        
        return ans; //return the answer array
    }
}