// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

// Return the head of the copied linked list.

// The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
// Your code will only be given the head of the original linked list.

// Example 1:

// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Example 2:

// Input: head = [[1,1],[2,1]]
// Output: [[1,1],[2,1]]
// Example 3:

// Input: head = [[3,null],[3,0],[3,null]]
// Output: [[3,null],[3,0],[3,null]]

// Constraints:

// 0 <= n <= 1000
// -104 <= Node.val <= 104
// Node.random is null or is pointing to some node in the linked list.

APPROACH 1 : POINTERS //explained in copy 

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        
        //first form the list with current nodes and new nodes
        // if list is 1->2->3
        // we make it 1->1->2->2->3->3
        Node curr = head;
        while(curr != null) {
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }
        
        //Now we have actual nodes and new Nodes
        // understand this clearly first
        // curr.next.random = curr.random.next;
		
        curr = head;
        while(curr!=null) {
            if(curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        //separate out both the lists and return the new list
        curr = head;
        Node curr1 = head.next;
        Node copyLIST = curr1;
        while(curr != null) {
            curr.next = curr.next.next;
            if(curr1.next != null) {
                curr1.next = curr1.next.next;
            } 
            curr = curr.next;
            curr1 = curr1.next;
        }
        return copyLIST;
    }
}
APPROACH 2 : HASHMAP
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Map<Node,Node>map = new HashMap<>();
        while(curr!=null){
            //while loop to fill map with original node and new node with same value as original node
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            //while loop to mark next and random pointers of new nodes
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr=curr.next;
        }
        return map.get(head);
    }
}
// Time Complexity : O(N+N)
// Space Complexity : O(N)