// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]


// EXPALNED SLOUTION - https://leetcode.com/problems/rotate-list/discuss/1838527/(JAVA-C%2B%2B)-Best-Diagramatic-Explanation

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        int Count = 1;
        if(head== null || head.next == null|| k==0)return head;
        while(curr.next!=null){
            curr = curr.next;
            Count ++;
        }
        curr.next = head;
        k= Count -(k%Count);
        while(k-->0)curr = curr.next;
        head = curr.next;
        curr.next=null;
        return head;
    }
    
}