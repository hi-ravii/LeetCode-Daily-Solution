
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
// Example 2:


// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]
 

// Constraints:

// The number of nodes in the list is n.
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000
 

// Follow-up: Can you solve the problem in O(1) extra memory space?

// Accepted
// 597,290
// Submissions
// 1,125,065

APPROACH 1: RECURSION
//APPROACH -phle k nodes ko reverse krke dekho aur baki k hisse ko recursion se call krke reverse krke dekho and then merge the two lists
//
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null && count != k){//INCREASING the count till k means while look k end me hume count k ke barabr milega aur curr humra k+1 node pe poch chuka hoga
            curr = curr.next;
            count++;
        }
        if(count == k){//valid case jab humpe group me k jitne nodes hoge
            curr = reverseKGroup(curr, k);// k+1 node ko hum recursion se call krke uske badle hume k nodes ko reverse krne honge
            //k+1 node se h 2k+1 node tak reverse krge recursive call k thorugh
            //basically hum ist ko todte rahege aur recurssion call kr k reverse krte rahege
            while(count-- > 0){//aab hum 1 se k node ko reverse krege yaha
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }//while loop k end me humara curr k+1 node ka address hoga aur head k node ka address hoga
            head = curr;
            //head ko aab nye group ka head bana do 
        }
        return head;        
    }
}

APPROACH 2: ITERATION

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;//if k is 1 then no need to reverse the list so return head as it is 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy;
        ListNode forw = dummy;
        
        int count = 0;
        while(curr.next != null){//counting the total nodes in the list
            curr = curr.next;
            count++;
        }
        
        while(count >= k){//while loop tab tak chalega jab tak humpe valid group bachege
            curr = prev.next;
            forw = curr.next;
            
            for(int i = 1; i < k; i++){//hume k-1 pointer ko reverse krne honge
                //iss loop pe prev ka kaam uss node k address ko save kr k rakhne ka hoga jo hume reverse krne honge
                curr.next = forw.next;//curr ka next ko forw ka next pe point krdo
                forw.next = prev.next;//forw ka next ko prev ka next pe point krdo
                prev.next = forw;//prev ka next ko forw pe point krdo
                forw = curr.next;//forw ko curr ka next pe point krdo
            }
            prev = curr;//prev humara group k last node pe point krta hoga 
            count -= k;//count ko k se kam krdo
        }
        return dummy.next;
    }
}
APPROACH 3: RECURSION (MOST SIMPLE)
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null ||head.next==null || k==1)return head;
        ListNode s = head, e = head;// s matlab start and e matlab end
        int inc =k-1;//k-1 nodes ko reverse krna hoga
        while(inc!=0){//while loop jab tak humara inc 0 nhi ho jata tab tak chalega
            //aur while loop k end me hume humara end pointer 
            e= e.next;
            if(e==null)return head;
            inc--;
        }
        ListNode nex = reverseKGroup(e.next,k);
        reverse(s,e);
        s.next = nex;
        return e;
    }
    public void reverse(ListNode head, ListNode end){
        ListNode curr = head,prev = null,forw=curr.next;
        while(prev!=end){
            curr.next = prev;
            prev = curr;
            curr= forw;
            if(forw!=null)forw = forw.next;
        }
    }
}
