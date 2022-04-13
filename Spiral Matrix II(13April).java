// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

// Example 1:


// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]
// Example 2:

// Input: n = 1
// Output: [[1]]
 

// Constraints:

// 1 <= n <= 20

class Solution {
    Integer rowDir = 0, colDir = 1;
    
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int row =0, col=0;
        
        
        while(num<= n*n) {
            matrix[row][col] = num;
            
            int tempRow = row+rowDir;
            int tempCol = col+colDir;
			
			//Condition to change direction 
            if(tempRow < 0 || tempCol <0 || tempRow == n || tempCol == n || matrix[tempRow][tempCol] != 0) {
                changeDirection();
            }
            
            row += rowDir;
            col += colDir;
            
            num++;
        }
        
        return matrix;
    }
    
    public void changeDirection() {
		
        if(rowDir == 0 && colDir ==1) {
			// initial: right -> new: down
            colDir = 0;
            rowDir = 1;
        } else if (colDir == 0 && rowDir ==1) {
			// initial: down -> new: left
            rowDir = 0;
            colDir = -1;
        } else if (colDir == -1 && rowDir == 0) {
			// initial: left -> new: up
            rowDir = -1;
            colDir = 0;
        } else if (rowDir == -1 && colDir == 0) {
			// initial: up -> new: right
            colDir = 1;
            rowDir = 0;
        }
    }
}