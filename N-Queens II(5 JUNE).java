// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

// Example 1:


// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
// Example 2:

// Input: n = 1
// Output: 1
 

// Constraints:

// 1 <= n <= 9
// Accepted
// 229,819
// Submissions
// 341,986
class Solution {
    int ans;
    
    public int totalNQueens(int N) {
        ans = 0;
        place(0,0,0,0,N);
        return ans;
    }
    
    private void place(int i, int vert, int ldiag, int rdiag, int N) {
        if (i == N) ans++;
        else for (int j = 0; j < N; j++) {
            int vmask = 1 << j, lmask = 1 << (i+j), rmask = 1 << (N-i-1+j);
            if ((vert & vmask) + (ldiag & lmask) + (rdiag & rmask) > 0) continue;
            place(i+1, vert | vmask, ldiag | lmask, rdiag | rmask, N);
        }
    }
}