// Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

// Example 1:


// Input: root = [1,null,2,3]
// Output: [3,2,1]
// Example 2:

// Input: root = []
// Output: []
// Example 3:

// Input: root = [1]
// Output: [1]
 

// Constraints:

// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
 

// Follow up: Recursive solution is trivial, could you do it iteratively?
// Accepted
// 727,580
// Submissions
// 1,129,750
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        if (curr == null) return res;

        Stack < TreeNode > st = new Stack < > ();
        while (curr != null || !st.isEmpty()) {

            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    res.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        res.add(temp.val);
                    }
                } else curr = temp;
            }
        }
        return res;
    }
}
APPROACH 2
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1= new Stack<>();
        Stack<TreeNode> st2= new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        if(curr==null)return res;
        st1.push(curr);
        while(!st1.isEmpty()){
            curr = st1.pop();
            st2.push(curr);
            if(curr.left!=null) st1.push(curr.left);
            if(curr.right!=null) st1.push(curr.right);
        }
        while(!st2.isEmpty()){
            res.add(st2.pop().val);
        }
        return res;
    }
}

APPROACH 3
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(root,res);
        return res;
    }
    public void solve(TreeNode root, List<Integer> res){
        if(root!=null){
            solve(root.left,res);
            solve(root.right,res);
            res.add(root.val);
        }
    }
}