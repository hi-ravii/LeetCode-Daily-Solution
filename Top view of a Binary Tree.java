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

// Time Complexity: O(N)

// Space Complexity: O(N)



//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
//rest explanation is in copy
class Solution
{
    static class Pair{
        Node root;
        int line;
        Pair(Node root,int line){
            this.root=root;
            this.line=line;
        }
        
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)

    {
        ArrayList<Integer> res = new ArrayList<>();
        // add your code
        if(root==null)return res;
        Map<Integer,Integer> map = new TreeMap<>();//TreeMap is used to store the data in sorted order of keys 
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair top =q.remove();//here datatype has become the pair
            int line = top.line;
            Node temp = top.root;
            if(!map.containsKey(line))map.put(line,temp.data);
            if(temp.left!=null)q.add(new Pair(temp.left,line-1));
            if(temp.right!=null)q.add(new Pair(temp.right,line+1));
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){//here we are iterating through the map and printing the values   
            res.add(entry.getValue());
        }
        return res;
    }
}












































