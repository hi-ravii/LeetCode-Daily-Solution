// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

 

// Example 1:


// Input: head = [1,4,3,2,5,2], x = 3
// Output: [1,2,2,4,3,5]
// Example 2:

// Input: head = [2,1], x = 2
// Output: [1,2]
 

// Constraints:

// The number of nodes in the list is in the range [0, 200].
// -100 <= Node.val <= 100
// -200 <= x <= 200
// Accepted
// 386,743
// Submissions
// 772,582
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
    public ListNode partition(ListNode head, int x) {
        ListNode curr = head;
        ListNode smaller = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode first = smaller,second = greater;
        while(curr!=null){
            if(curr.val<x){
                first.next = curr;
                first = first.next;
            }
            else {
                second.next = curr;
                second = second.next;
            }
            curr = curr.next;
            second.next=null;
            first.next = greater.next;
        }
        return smaller.next;
    }
}