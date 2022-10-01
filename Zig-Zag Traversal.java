// Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.


 
 

// Example 1:

// Input:
//       1
//     /   \
//    3     2
// Output:1 3 2

// Example 2:

// Input:
//            10
//          /     \
//         20     30
//       /    \
//     40     60
// Output: 10 20 30 60 40 
// Your Task:
// The task is to complete the function findSpiral() which takes root node as input parameter and returns the elements in spiral form of level order traversal as a list. The newline is automatically appended by the driver code.
// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(N).

// Constraints:
// 0 <= Number of nodes <= 105
// 0 <= Data of a node <= 105

GFG QUESTION

class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        // Your code here
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)return res;
        q.add(root);
        Boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> sub = new ArrayList<>();
            for(int i =0;i<size;i++){
                Node curr = q.peek();
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
                if(flag==true)sub.add(q.poll().data);
                else sub.add(0,q.poll().data);
                
            }
            
            for(int i :sub){
                res.add(i);
            }
            flag=!flag;
        }
        return res;
    }
}

LEETCODE QUESTION
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        Queue<TreeNode> q =new LinkedList<>();
        if(root==null)return res;
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int len=q.size();
            List<Integer> sub = new LinkedList<>();
            for(int i=0;i<len;++i){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                if(flag == true) sub.add(q.poll().val);
                else sub.add(0,q.poll().val);
            }
            res.add(sub);
            flag=!flag;
        }
        return res;
    }
}