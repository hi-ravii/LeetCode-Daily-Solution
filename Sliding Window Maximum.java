// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

 

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
// Accepted
// 626,893
// Submissions
// 1,348,958
APPROACH 1 : BRUTE FORCE
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        for(int i =0;i<nums.length-k+1;i++){
            int max = Integer.MIN_VALUE;
            for(int j =i;j<=i+k-1;j++){
                max = Math.max(max,nums[j]);
            }
            res[i]=max;
        }
        return res;
    }
}

APPROACH 2 : SLIDING WINDOW


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        //result array size will be (nums.length - k + 1)
        Deque<Integer> q = new LinkedList<>();//deque is used to store the index of the element in the array
        //all normal methods of queue is used foe left side offer/add or offerFirst/addFirst and poll/remove or pollFirst/removeFirst
        //for the right side we use addLast/offerLast and pollLast/removeLast
        
        int i = 0;
        int j = 0;
        
        while(j < nums.length){
            // calculation
            if(q.size() == 0){//for the first element in the array
                q.add(nums[j]);//just add it directly
            }
            else{
                while(q.size() > 0 && q.peekLast() < nums[j]){//we compare with the rightmoast element in the queue as it will be the largest element in the queue
                    //if the last element in the deque is less than the current element then remove it
                    //we remove the last element because it is the smallest element in the deque
                    //it doesnt matter to remove smaller elemnt as in the last we want the larger no in the window
                    q.removeLast();
                }
                q.add(nums[j]);//add the current element to the deque
            }
            // now move j pointer
            if(j - i + 1 < k) j++;
            // if we hit the window size
            else if(j - i + 1 == k){
                // answer -> calculation;
                ans[i] = q.peek();//we want the largest element in the window which will be in the left side of the deque
                // slide the window
                // calculation for removing the first element of window while moving forward
                if(nums[i] == q.peek()){
                    //if the first element in the window is the largest element in the window and we move the window forward then we remove the first element
                    q.remove();
                }
                // now slide the pointer
                i++;
                j++;
            }
        }
        return ans;
    }
}