// Given the root of a binary tree, invert the tree, and return its root.

 

// Example 1:


// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]
// Example 2:


// Input: root = [2,1,3]
// Output: [2,3,1]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
// Accepted
// 1,151,236
// Submissions
// 1,588,713
APPROACH 1 : RECURSSION
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

APPROACH 2 : ITERATION USING STACK

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            TreeNode temp1 = temp.left;
            temp.left = temp.right;
            temp.right = temp1;
            if(temp.left!=null) stack.push(temp.left);
            if(temp.right!=null) stack.push(temp.right);
        }
        return root;
    }
}

APPROACH 3 : ITERATION USING QUEUE

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr!=null){
                q.add(curr.left);
                q.add(curr.right);
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
            }
            
        }
        return root;
    }
}