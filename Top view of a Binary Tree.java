// Problem Statement: Given below is a binary tree. The task is to print the top view of the binary tree. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

// Example 1:

// Input: 



// Output: 2 1 3
// Example 2:

// Input: 



// Output: 40 20 10 30 100
// Solution:

// Intuition:  We can mark straight lines like in the image below and mark them with +ve and -ve indexes. The first node of every line will be my top view.



// Approach: 

// First we have to make a queue of pair which have nodes and their respective +ve and -ve indexes.
// Then we need a map data structure to store the lines and the nodes. This map will store the data in the form of sorted orders of keys(Lines).
// Here we will follow the level order traversal.
// Traverse through the nodes starting with root,0 and store them to the queue.
// Until the queue is not empty, store the node  and line no. in 2 separate variable .
// Then check if that line is present in the map or not
// If not present then store the line and the node->val to the map
// Otherwise store the node->left and node->right along with there line nos. to the queue.
// Then print the node->val from the map
// Code:
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0)); 
        while(!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd; 
            Node temp = it.node; 
            if(map.get(hd) == null) map.put(hd, temp.data); 
            if(temp.left != null) {
                
                q.add(new Pair(temp.left, hd - 1)); 
            }
            if(temp.right != null) {
                
                q.add(new Pair(temp.right, hd + 1)); 
            }
        }
    
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
        
    }
}
Time Complexity: O(N)

Space Complexity: O(N)