// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
 

// Example 1:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
// Example 2:


// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
// Accepted
// 894,138
// Submissions
// 1,955,680
Aproach 1: Binary Search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        //considering it as a 1D sorted array and then using binary search over it
        int low =0;//at the starting element
        int high =(n*m)-1;// at the last element
        while(low<=high){
            int mid = low+(high-low)/2;
            //to calculate row =mid/m
            //to calculate col = mid%m
            if(matrix[mid/m][mid%m]==target)return true;
            else if(matrix[mid/m][mid%m]<target)low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
