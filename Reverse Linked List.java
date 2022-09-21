// Given the head of a singly linked list, reverse the list, and return the reversed list.

 

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// Example 2:


// Input: head = [1,2]
// Output: [2,1]
// Example 3:

// Input: head = []
// Output: []
 

// Constraints:

// The number of nodes in the list is the range [0, 5000].
// -5000 <= Node.val <= 5000
 

// Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

// Accepted
// 2,296,126
// Submissions
// 3,226,591
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
APPROACH 1 : ITERATIVE

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head,forw = null , prev = null;
        while(curr!=null){
            forw = curr.next;
        curr.next=prev;
        prev = curr;
        curr = forw;
        
        }
        return prev;
    }
    
}
APPROACH 2 : RECURSIVE
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
    
}
APPRACH 3 : USING STACK
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        while(curr!=null){
            st.push(curr);
            curr = curr.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!st.isEmpty()){
            temp.next = st.pop();
            temp = temp.next;
        }
        temp.next = null;
        return dummy.next;
    }
    
}
APPROACH 4 : USING ARRAYLIST
class Solution {
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            al.add(curr.val);
            curr = curr.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for(int i = al.size()-1;i>=0;i--){
            temp.next = new ListNode(al.get(i));
            temp = temp.next;
        }
        return dummy.next;
    }
    
}
APPROACH 5 : USING ARRAY
class Solution {
    public ListNode reverseList(ListNode head) {
        int n = 0;
        ListNode curr = head;
        while(curr!=null){
            n++;
            curr = curr.next;
        }
        int[] arr = new int[n];
        curr = head;
        int i = 0;
        while(curr!=null){
            arr[i] = curr.val;
            i++;
            curr = curr.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for(int j = arr.length-1;j>=0;j--){
            temp.next = new ListNode(arr[j]);
            temp = temp.next;
        }
        return dummy.next;
    }
    
}

