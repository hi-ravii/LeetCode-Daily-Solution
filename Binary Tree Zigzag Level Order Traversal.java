// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100
// Accepted
// 721,588
// Submissions
// 1,340,279
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res= new LinkedList<>();
        Queue<TreeNode> q =new LinkedList<>();
        if(root == null)return res;
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int len =q.size();// important as q size should be initailliezed prior
            List<Integer> sub = new LinkedList<>();
            for(int i =0; i<len;++i){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                if(flag == true) sub.add(q.poll().val);//filling left ->right in sub
                else sub.add(0,q.poll().val);//filling right ->left in sub
            }
            res.add(sub);
            flag =!flag; //changing flag
        }
        return res;
        
    }
}