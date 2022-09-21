// You are given the head of a singly linked-list. The list can be represented as:

// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:

// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

// Example 1:


// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
// Example 2:


// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
 

// Constraints:

// The number of nodes in the list is in the range [1, 5 * 104].
// 1 <= Node.val <= 1000
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
class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)return ;
        
        //Find the middle of the list
        ListNode slow = head;//slow head pe
        ListNode fast = head;//fast head.next se
        while(fast!=null&&fast.next!=null){//slow humare middle pe poch jayega
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode second =slow.next;//Second is At the starting point of second half
        ListNode prev = null;
        slow.next = null;//last node of first half pointing to null
        while(second!=null){// basic reversing function
            ListNode forw = second.next;
            second.next = prev;
            prev =second;
            second = forw;
        }
        
        //give output as prev as the head of the reverse linked list
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        
        
        ListNode first = head;//first pointer at the head of first list
        second = prev;//second pointet at the head of the second reverse list
        while(second!=null){//merging function
            ListNode temp1=first.next;//temp1 to store the next value of first half
            ListNode temp2 = second.next;//temp 2 to store the next value of second half
            first.next = second;
            second.next =temp1;
            first = temp1;//reseting first
            second = temp2;//resenting second
        }
    }
}  