// Given a number N. Count the number of digits in N which evenly divides N.
 

// Example 1:

// Input:
// N = 12
// Output:
// 2
// Explanation:
// 1, 2 both divide 12 evenly
// Example 2:

// Input:
// N = 23
// Output
// 0
// Explanation:
// 2 and 3, none of them
// divide 23 evenly

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function evenlyDivides() which takes an integer N as input parameters and returns an integer, total number factor of digits N which divides N evenly.


// Expected Time Complexity: O(log N)
// Expected Space Complexity: O(1)

class Solution{
    static int evenlyDivides(int N){
        // code here
        int count=0;
        int temp =N;
        while(temp!=0){
            int digit = temp%10;
            if(digit!=0 && N%digit==0)count++;
            temp = temp/10;
        }
        return count;
        
    }
}