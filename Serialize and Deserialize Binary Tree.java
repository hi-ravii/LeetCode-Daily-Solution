// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

// Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

// Example 1:


// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]
// Example 2:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 104].
// -1000 <= Node.val <= 1000
// Accepted
// 620,372
// Submissions
// 1,149,053
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

GFG Solution 
class Tree 
{
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    //code here
	    if(root==null)return ;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr==null){
                A.add(-1);
                continue;
            }
            A.add(curr.data);
            q.add(curr.left);
            q.add(curr.right);
        }
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        if(A.size()==0)return null;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(A.get(0));
        q.add(root);
        for(int i =1;i<A.size();i++){
            Node curr = q.poll();
            if(A.get(i)!=-1){
                Node left = new Node(A.get(i));
                curr.left = left;
                q.add(left);
            }
            if(A.get(++i)!=-1){
                Node right = new Node(A.get(i));
                curr.right = right;
                q.add(right);
            }
        }
        return root;
    }
};