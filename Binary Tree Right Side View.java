// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

// Example 1:


// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]
// Example 2:

// Input: root = [1,null,3]
// Output: [1,3]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
// Accepted
// 684,807
// Submissions
// 1,145,652
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
    
    int level=0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(root,res,level);
        return res;
    }
    public void solve(TreeNode root , List<Integer> res, int level ){
        TreeNode cur = root;//current node
        if(cur==null)return;//if current node is null, return
        
        if(level==res.size())res.add(cur.val);//if current level is not in the list, add it
        solve(cur.right,res,level+1); //go to right child
        solve(cur.left,res,level+1);//go to left child
    }
}