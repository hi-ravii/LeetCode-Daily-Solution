// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

 

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
// Example 2:

// Input: lists = []
// Output: []
// Example 3:

// Input: lists = [[]]
// Output: []
 

// Constraints:

// k == lists.length
// 0 <= k <= 104
// 0 <= lists[i].length <= 500
// -104 <= lists[i][j] <= 104
// lists[i] is sorted in ascending order.
// The sum of lists[i].length will not exceed 104.
// Accepted
// 1,415,552
// Submissions
// 2,939,186
APPROACH 1: BRUTE FORCE
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(true){
            int min = Integer.MAX_VALUE;
            int index =-1;
            for(int i =0;i<lists.length;i++){
                if(lists[i]!=null && lists[i].val<min){
                    min = lists[i].val;
                    index = i;
                }
            }
            if(index==-1)break;
            prev.next = lists[index];
            lists[index] = lists[index].next;
            prev = prev.next;
        }
        return dummy.next;
    }
}
APPROACH 2: USING MIN HEAP
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists){
            if(node!=null)pq.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            prev.next = node;
            prev = prev.next;
            if(node.next!=null)pq.add(node.next);
        }
        return dummy.next;
    }
}
APPROACH 3: USING MERGE SORT //HI-MALIK SOLUTION
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int start,int end){
        if(start==end)return lists[start];
        int mid = start+(end-start)/2;
        ListNode left = merge(lists,start,mid);
        ListNode right = merge(lists,mid+1,end);
        return mergeTwoLists(left,right);
    }
    public ListNode getmerge(ListNode left, ListNode right){
        if(left==null)return right;
        if(right==null)return left;
        if(left.val<right.val){
            left.next = getmerge(left.next,right);
            return left;
        }
        else{
            right.next = getmerge(left,right.next);
            return right;
        }
    }
}
