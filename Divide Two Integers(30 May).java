// Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

// The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

// Return the quotient after dividing dividend by divisor.

// Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

// Example 1:

// Input: dividend = 10, divisor = 3
// Output: 3
// Explanation: 10/3 = 3.33333.. which is truncated to 3.
// Example 2:

// Input: dividend = 7, divisor = -3
// Output: -2
// Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 

// Constraints:

// -231 <= dividend, divisor <= 231 - 1
// divisor != 0
// Accepted
// 476,030
// Submissions
// 2,794,183
class Solution {
    public int divide(int A, int B) {
        // A= Divident (jo divide hota h )
        //B= Divisor (jo divide krta h)
       if (A == 1 << 31 && B == -1) return Integer.MAX_VALUE ;
       int a = Math.abs(A), b = Math.abs(B), result = 0, count = 0;
        // a=absolute value of A
        // b= absolute value of B
       boolean sign =(A > 0) == (B > 0);//if both are psotive then sign flat is true
       while (a - b >= 0) {//while b can be remove from a till then 
           for (count = 0; a - (b << count << 1) >= 0; count++);//remove b from a by multiplying it by 2 everytime and increasing count as well
           result += 1 << count;// add count to result
           a -= b << count;//updating a value after removing b from it
       }
       return sign ? result : -result;//if sign is true the return +ve result else -ve res
   }
}
