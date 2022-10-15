// Given a sorted array A[] of size N, delete all the duplicated elements from A[]. Modify the array such that if there are X distinct elements in it then the first X positions of the array should be filled with them in increasing order and return the number of distinct elements in the array.

// Note:
// 1. Don't use set or HashMap to solve the problem.
// 2. You must return the number of distinct elements(X) in the array, the generated output will print all the elements of the modified array from index 0 to X-1.

// Example 1:

// Input:
// N = 5
// Array = {2, 2, 2, 2, 2}
// Output: {2}
// Explanation: After removing all the duplicates 
// only one instance of 2 will remain.
// Example 2:

// Input:
// N = 3
// Array = {1, 2, 2}
// Output: {1, 2}

// Your Task:  
// You don't need to read input or print anything. Complete the function remove_duplicate() which takes the array A[] and its size N as input parameters and modifies it in place to delete all the duplicates. The function must return an integer X denoting the new modified size of the array. 


// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)


// Constraints:
// 1 ≤ N ≤ 104
// 1 ≤ A[i] ≤ 106

// EXPLANATION OF BOTH APPROACH IN STRIVER PAGE https://takeuforward.org/data-structure/remove-duplicates-in-place-from-sorted-array/
APPROACH 1: TWO POINTER 

class Solution {
    int remove_duplicate(int A[],int N){
        // code here
        // take 2 pointers 

        

        

        int pointer1=0; // pointer-1

        int pointer2;  // pointer-2

        

        for(pointer2=1;pointer2<N;pointer2++)

        {

            // check if elements are different or not !!!

            

            if(A[pointer1]!=A[pointer2]){

                pointer1++;

                A[pointer1]=A[pointer2];

            }

        }

        

        return pointer1+1;
    }
}
APPROACH 2 : using Treeset
//using TreeSet as without it output was not coming in sorted order so in GFG it will help to get a desired output
class Solution {
    int remove_duplicate(int A[],int N){
        // code here
        TreeSet < Integer > set = new TreeSet < > ();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x: set) {
            A[j++] = x;
        }
        return k;
    }
}