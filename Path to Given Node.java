// Problem Description

// Given a Binary Tree A containing N nodes.

// You need to find the path from Root to a given node B.

// NOTE:

// No two nodes in the tree have same data values.
// You can assume that B is present in the tree A and a path always exists.


// Problem Constraints
//  1 <= N <= 105 

//  1 <= Data Values of Each Node <= N

//  1 <= B <= N



// Input Format
// First Argument represents pointer to the root of binary tree A.

// Second Argument is an integer B denoting the node number.



// Output Format
// Return an one-dimensional array denoting the path from Root to the node B in order.



// Example Input
// Input 1:

//  A =

//            1
//          /   \
//         2     3
//        / \   / \
//       4   5 6   7 


// B = 5

// Input 2:

//  A = 
//             1
//           /   \
//          2     3
//         / \ .   \
//        4   5 .   6


// B = 1




// Example Output
// Output 1:

//  [1, 2, 5]
// Output 2:

//  [1]


// Example Explanation
// Explanation 1:

//  We need to find the path from root node to node with data value 5.
//  So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]
// Explanation 2:

//  We need to find the path from root node to node with data value 1.
//  As node with data value 1 is the root so there is only one node in the path.
//  So we will return [1]

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 * 
 * typedef struct TreeNode treenode;
 * 
 * treenode* treenode_new(int val) {
 *     treenode* node = (treenode *) malloc(sizeof(treenode));
 *     node->val = val;
 *     node->left = NULL;
 *     node->right = NULL;
 *     return node;
 * }
 */
/**
 * @input A : Root pointer of the tree 
 * @input B : Integer
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
int* solve(treenode* A, int B, int *len1) {
    List<Integer> res = new AraayList<>();
    if(A==null)return res;
    path(A,B,res);
    return res;
}
public boolean path(TreeNode A,int B,List<Integer> res){
    if(root==null)return false;
    else{
        res.add(root.val);
    }
    if(root.val==B)return true;
    if(path(root.left,B,res)||path(root.right,B,res)) return true;
    else {
        res.remove(res.size()-1);
        return false;
    }

}
