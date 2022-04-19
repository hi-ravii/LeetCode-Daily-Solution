// You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 

// Example 1:


// Input: root = [1,3,null,null,2]
// Output: [3,1,null,null,2]
// Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
// Example 2:


// Input: root = [3,1,4,null,null,2]
// Output: [2,1,4,null,null,3]
// Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 

// Constraints:

// The number of nodes in the tree is in the range [2, 1000].
// -231 <= Node.val <= 231 - 1
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
class Solution {
    // Creating three global pointers
   TreeNode previous = null;
   TreeNode first = null;
   TreeNode second = null;
   
   public void recoverTree(TreeNode root) {
       // Finding the two swapped nodes
       solve(root);
       
       //Swaping the value of nodes
       int temp = first.val;
       first.val = second.val;
       second.val = temp;
   }
    //New Function to find the two nodes
   public void solve(TreeNode root){
       
       if(root == null){
           return;
       }
       
       //Doing inorder traversal i.e, sarting from left then right
       solve(root.left);
       
       // If current node is smaller than previous, then previous node is invalid
       if(previous != null && root.val < previous.val){
           
           //Storing previous node
           if(first == null){
               first = previous;
           }
           
           //If both nodes are adjacent, save the current node in that case
           second = root;
           
       }
       
       //Making current node as previous node
       previous = root;
       
       //Moving to right sub-tree
       solve(root.right);
       
   }
}