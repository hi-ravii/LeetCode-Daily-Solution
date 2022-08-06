// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

// Example 1:

// Input: root = [3,1,4,null,2], k = 1
// Output: 1
// Example 2:

// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3

// Constraints:

// The number of nodes in the tree is n.
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public void inorder(TreeNode root, int k, int[] res)// BST inorder is ascendingly sorted
    {
        if (root == null)// base case when we reach to null node we return to the parent by deleting the
                         // current activation block
            return;

        inorder(root.left, k, res);// Recursing the Left subtree

        res[0] = res[0] + 1;// increamenting the index as we are visiting the node in a sorted fashion
                            // //Root

        if (res[0] == k) {// when the desired index is found
            res[1] = root.val;// overwridding the value, with the value present at kth index//-1 is for index
                              // out of bound
            return;// saving the space and not traversing the whole tree, as the desired index
                   // element is found
        }

        inorder(root.right, k, res);// Recursing the Right subtree

        return;// deleting the current activation block as all the function are completed,
               // returning to the callinng function
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] res = { 0, -1 };

        inorder(root, k, res);// calling the inorder to get the samllest kth element

        return res[1];// if the index is out of bound then -1 is returned, else the value is returned
    }
}

APPROACH 2:
