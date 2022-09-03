// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.
 

// Example 1:


// Input: board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true
// Example 2:

// Input: board = 
// [["8","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

// Constraints:

// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.
// Accepted
// 787.4K
// Submissions
// 1.4M
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();// creating a set
        for(int i=0;i<9;i++){// itrating over all rows
            for(int j=0;j<9;j++){//itrating over all col
                if(board[i][j]!='.'){//if the element is not empty then only we will check and add to set
                    if(!set.add("ROW"+i+board[i][j]))return false;//set will return false if the element is already present in set within same row and its unable to add it again
                    if(!set.add("COL"+j+board[i][j]))return false;//set will return false if the element is already present in set within same column and its unable to add it again
                    if(!set.add("BOX"+((i/3)*3+(j/3))+board[i][j]))return false;//set will return false if the element is already present in set within same subbox and its unable to add it again
                }
            }
        }
        return true;//if all the elements are valid then return true
    }
}