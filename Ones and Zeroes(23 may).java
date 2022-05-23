// You are given an array of binary strings strs and two integers m and n.

// Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

// A set x is a subset of a set y if all elements of x are also elements of y.

 

// Example 1:

// Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
// Output: 4
// Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
// Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
// {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
// Example 2:

// Input: strs = ["10","0","1"], m = 1, n = 1
// Output: 2
// Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 

// Constraints:

// 1 <= strs.length <= 600
// 1 <= strs[i].length <= 100
// strs[i] consists only of digits '0' and '1'.
// 1 <= m, n <= 100
class Solution {
    
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for(String str : strs){
            //count of onees and zeors for this string
            int[]count = getCount(str);
            
            for(int zeroes = m; zeroes >= count[0]; zeroes--){
                for(int ones = n; ones >= count[1]; ones--){
                    
                    //update the current subset length,
                    //find the maximum subsets length, when consider current element or when we donn't consider
                    dp[zeroes][ones] = Math.max(dp[zeroes][ones], 1 + dp[zeroes - count[0]][ones - count[1]]);
                }  
            }
        }
        
        return dp[m][n];
    }
    

    
    private int[] getCount(String str){
        int[] count = new int[2];
        
        //count zeroes and ones of current string
        for(char c : str.toCharArray()){
            count[c - '0']++;
        }
        
        return count;
    }
}