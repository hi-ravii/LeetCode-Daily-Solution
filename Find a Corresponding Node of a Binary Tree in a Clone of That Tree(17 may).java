// Given two binary trees original and cloned and given a reference to a node target in the original tree.

// The cloned tree is a copy of the original tree.

// Return a reference to the same node in the cloned tree.

// Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

 

// Example 1:


// Input: tree = [7,4,3,null,null,6,19], target = 3
// Output: 3
// Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
// Example 2:


// Input: tree = [7], target =  7
// Output: 7
// Example 3:


// Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
// Output: 4
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// The values of the nodes of the tree are unique.
// target node is a node from the original tree and is not null.
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> stack_o = new ArrayDeque();
        Deque<TreeNode> stack_c = new ArrayDeque();
        TreeNode node_o = original, node_c = cloned;

        while (!stack_o.isEmpty() || node_o != null) {
            while (node_o != null) {
                stack_o.add(node_o);
                stack_c.add(node_c);

                node_o = node_o.left;
                node_c = node_c.left;
            }
            node_o = stack_o.removeLast();
            node_c = stack_c.removeLast();
            if (node_o == target) {
                return node_c;
            }
            node_o = node_o.right;
            node_c = node_c.right;
        }
        return null;
    }
}