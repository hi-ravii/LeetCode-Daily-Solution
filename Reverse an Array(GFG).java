// Given an array A of size N, print the reverse of it.

// Example:

// Input:
// 1
// 4
// 1 2 3 4
// Output:
// 4 3 2 1
// Input:
// First line contains an integer denoting the test cases 'T'. T testcases follow. Each testcase contains two lines of input. First line contains N the size of the array A. The second line contains the elements of the array.

// Output:
// For each testcase, in a new line, print the array in reverse order.

// Constraints:
// 1 <= T <= 100
// 1 <= N <=100
// 0 <= Ai <= 100
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
                //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            for(int i = n - 1; i >= 0; i--){
                System.out.print(arr[i] + " ");
            }
            System.out.println();// ye line likhna jaruri hai kyuki agar nhi likha toh next test case ka output pehle wale test case ka output ke baad print hoga aur ye nhi chahiye kyuki ek line me ek hi output print hona chahiye test case ke liye 
        }   
	}
}