// Given a Binary Tree of size N, you need to find all the possible paths from root node to all the leaf node's of the binary tree.

// Example 1:

// Input:
//        1
//     /     \
//    2       3
// Output: 1 2 #1 3 #
// Explanation: 
// All possible paths:
// 1->2
// 1->3

// Example 2:

// Input:
//          10
//        /    \
//       20    30
//      /  \
//     40   60
// Output: 10 20 40 #10 20 60 #10 30 #

// Your Task:
// Your task is to complete the function Paths() that takes the root node as an argument and return all the possible path. (All the path are printed '#' separated by the driver's code.)

// Note: The return type
// cpp: vector
// java: ArrayList>
// python: list of list

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(H).
// Note: H is the height of the tree.

// Constraints:
// 1<=N<=103
class Tree{
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, res, path);
        return res;

    }
    public void helper(Node root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path){
        if(root == null) return;
        path.add(root.data);
        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }
        helper(root.left, res, path);
        helper(root.right, res, path);
        path.remove(path.size() - 1);
    }
    
}

