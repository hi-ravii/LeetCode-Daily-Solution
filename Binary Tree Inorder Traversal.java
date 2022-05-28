// Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

// Example 1:


// Input: root = [1,null,2,3]
// Output: [1,3,2]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [1]
// Output: [1]
 

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
 

// Follow up: Recursive solution is trivial, could you do it iteratively?
// Accepted
// 1,484,012
// Submissions
// 2,091,013
APPROACH 1 
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        
        while(curr!=null|| !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            res.add(curr.val);
            curr=curr.right;
        }
        return res;
    }
    
}

APPROACH 2
class Solution {
    public void helper(TreeNode root,List<Integer> res)
    {
        if(root!=null)
        {
            
            helper(root.left,res);
            res.add(root.val);
            helper(root.right,res);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res=new ArrayList<>();
       helper(root,res);
       return res;
        
        
    }
}