// Palindrome
// SchoolAccuracy: 52.66%Submissions: 21767Points: 0
// Given an integer, check whether it is a palindrome or not.

// Example 1:

// Input: n = 55555
// Output: Yes

// Example 2:

// Input: n = 123
// Output: No
 

// Your Task:
// You don't need to read or print anything. Your task is to complete the function is_palindrome() which takes the number as input parameter and returns "Yes" if it is palindrome otherwise returns "No"(Without quotes).
 

// Expected Time Complexity: O(x)
// Expected Space Complexity: O(x) where x is number of digits in n.
 

// Constraints:
// 1 <= n <= 1000
APPROACH 1: USING TEMP VARIABLE
class Solution
{
    public String is_palindrome(int n)
    {
        // Code here
        int num =n;
        int temp =0;
        int rev =0;
        while(n!=0){
            temp=n%10;
            n =n/10;
            rev = rev*10 +temp;
            
        }
        if(num ==rev)return "Yes";
        else return "No";
    }
}
APPROACH 2 : USING STRING
class Solution
{
    public String is_palindrome(int n)
    {
        // Code here
        String s = Integer.toString(n);
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return "No";
            i++;
            j--;
        }
        return "Yes";
    }
}