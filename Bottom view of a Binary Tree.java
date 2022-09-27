// Problem Statement: Given a binary tree, print the bottom view from left to right. A node is included in the bottom view if it can be seen when we look at the tree from the bottom.

// Example 1:

// Input: 



// Output: 3 1 2
// Explanation:

// Explanation: 

// If you look up from the bottom from left to right then first we get 3, then 1 and 2.

// Example 2:

// Input: 



// Output: 40 20 60 30
// Explanation: 

// If you look up from the bottom from left to right then first we get 40, then 20, 60(it blocks 10), and 30.

// Disclaimer: Don’t jump directly to the solution, try it out yourself first

// Solution

// Intuition:  We can mark straight lines like in the image below and mark them with +ve and -ve indexes. The Last node of every line will be my Bottom view.



// Approach: 

// First we have to make a queue of pair which have nodes and their respective +ve and -ve indexes.
// Then we need a map data structure to store the lines and the nodes. This map will store the data in the form of sorted orders of keys(Lines).
// Here we will follow the level order traversal.
// Traverse through the nodes starting with root,0 and store them to the queue.
// Until the queue is not empty, store the node  and line no. in 2 separate variables .
// Then store the line and the node->val to the map, if there will be any node value present that corresponds to a line in the map , it will be replaced by the new node value and by this we will get the last node of each line.
// Store the node->left and node->right along with their line nos. to the queue.
// Then print the node->val from the map
// Tip: Here there is only 1 small difference from the Top View of the Tree. Here we don’t need to check whether the node is previously present on the map or node before entering it. We have to replace the node of each line if that was previously present on the map.

// Code:
class Solution
{
    public class pair{
        int line ;
        Node root;
        pair(Node root, int line){
            this.root = root;
            this.line =line;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)return res;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,0));
        while(!q.isEmpty()){
            pair top = q.poll();
            int line = top.line;
            Node temp = top.root;
            map.put(line,temp.data);
            if(temp.left!=null)q.add(new pair(temp.left,line-1));
            if(temp.right!=null)q.add(new pair(temp.right,line+1));
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            res.add(entry.getValue()); 
        }
        return res;
    }
}
Time Complexity: O(N)

Space Complexity: O(N)