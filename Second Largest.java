// Given an array Arr of size N, print second largest element from an array.

// Example 1:

// Input: 
// N = 6
// Arr[] = {12, 35, 1, 10, 34, 1}
// Output: 34
// Explanation: The largest element of the 
// array is 35 and the second largest element
// is 34.
// Example 2:

// Input: 
// N = 3
// Arr[] = {10, 5, 10}
// Output: 5
// Explanation: The largest element of 
// the array is 10 and the second 
// largest element is 5.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function print2largest() which takes the array of integers arr and n as parameters and returns an integer denoting the answer. If 2nd largest element doesn't exist then return -1.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 ≤ N ≤ 105
// 1 ≤ Arri ≤ 105
Explanation = first find the max in one itration 
then find the second max in another itration such that element itselft should not be max and element value should be less then max and greater than second max
one edge case = if all elements are same then return -1 
class Solution {
    int print2largest(int arr[], int n) {
        // code here
        int max = Integer.MIN_VALUE;//max element
        int min = Integer.MIN_VALUE;//second max element
        for(int i =0;i<n;i++){//find max element in one itration
            max = Math.max(max,arr[i]);
        }
        for(int i =0;i<n;i++){//second itration to find second max element
            if(arr[i]!=max && arr[i]>min){//if element is not max and greater than second max then update second max
                min =Math.max(arr[i],min);//update second max
            }
            else if(arr[0]==arr[n-1]) return -1;//if all elements are same then return -1
        }
        return min;
    }
}