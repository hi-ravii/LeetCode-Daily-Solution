// Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

// Example 1:


// Input: root = [5,3,6,2,4,null,7], k = 9
// Output: true
// Example 2:


// Input: root = [5,3,6,2,4,null,7], k = 28
// Output: false
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -104 <= Node.val <= 104
// root is guaranteed to be a valid binary search tree.
// -105 <= k <= 105
// Accepted
// 324,224
// Submissions
// 549,554
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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int i =0,j=res.size()-1;
        while(i<j){
            if(res.get(i)+res.get(j)==k)return true;
            else if(res.get(i)+res.get(j)>k)j--;
            else i++;
        }
        return false;
    }
    public List<Integer> inorder(TreeNode root,List<Integer> res){
        if(root==null)return null;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
        return res;
    }
}