// Given a balanced parentheses string s, return the score of the string.

// The score of a balanced parentheses string is based on the following rule:

// "()" has score 1.
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.
 

// Example 1:

// Input: s = "()"
// Output: 1
// Example 2:

// Input: s = "(())"
// Output: 2
// Example 3:

// Input: s = "()()"
// Output: 2
 

// Constraints:

// 2 <= s.length <= 50
// s consists of only '(' and ')'.
// s is a balanced parentheses string.

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        int score = 0; 
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch =='('){
                st.push(score);
                score =0;
            }
            else{
                score = st.pop()+Math.max(2*score,1);
            }
        }
        return score;
    }
}