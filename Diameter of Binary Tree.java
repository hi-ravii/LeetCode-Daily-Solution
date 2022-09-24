// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

 

// Example 1:


// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
// Example 2:

// Input: root = [1,2]
// Output: 1
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -100 <= Node.val <= 100
// Accepted
// 817,802
// Submissions
// 1,480,960
APPROACH 1: RECURSSION
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
    int sum =0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        sum =height(root.left)+height(root.right);
        return Math.max(sum,Math.max(right,left));
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        int r = height(root.right);
        int l = height(root.left);
        return Math.max(l,r)+1;
    }
}


// time complexity: O(n^2)
// space complexity: O(n)

APPROACH 2: RESCURRSION (OPTIMAL)
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;// if height function return -1 then return false else true;
    }
    //we start checking from bottom to top
    public int height (TreeNode root){// fuction which return -1 if not a balanced binary tree else return the height of the tree
        if(root==null)return 0;
        int l = height(root.left);//dfs traversal to lef tside of the node
        if(l==-1)return -1;//if root get -1 from it bottom node due to the diff bigget then 1 it will return -1
        int r = height(root.right);//dfs traversal to right side of the node
        if(r==-1)return -1;//if root get -1 from it bottom node due to the diff bigget then 1 it will return -1
        if(Math.abs(l-r)>1)return -1;//if at any point diff get bigget then 1 it will return -1
        return Math.max(l,r)+1;// else return its height
    }
}
// time complexity: O(n)
// space complexity: O(n)

EASIEST APPROACH 
class Solution {
    int sum =0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return sum ;
        
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        int left = height(root.left);
        int right = height(root.right);
        sum = Math.max(sum,(left+right) );
        return Math.max(left,right)+1;
    }
}