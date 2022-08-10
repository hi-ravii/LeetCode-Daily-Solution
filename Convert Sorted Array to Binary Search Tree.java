// Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 

// Example 1:


// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted:

// Example 2:


// Input: nums = [1,3]
// Output: [3,1]
// Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in a strictly increasing order.
// Accepted
// 804,149
// Submissions
// 1,192,759
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
APPROACH 1: RECURSIVE
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0, nums.length - 1);
    }
    
    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end) return null;//if length of nums is 0 then return null
        int mid = (start + end) / 2;//find the middle element of the array 
        TreeNode root = new TreeNode(nums[mid]);//create a new node with the middle element of the array 
        root.left = sortedArrayToBST(nums, start, mid - 1);//create the left subtree with the elements from start to mid - 1 
        root.right = sortedArrayToBST(nums, mid + 1, end);//create the right subtree with the elements from mid + 1 to end
        return root;//return the root node
    }
}


