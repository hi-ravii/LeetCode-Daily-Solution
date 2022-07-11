// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 

// Constraints:

// 1 <= n <= 8
// Accepted
// 1,120,781
// Submissions
// 1,583,059

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int open =n;
        int close = n;
        String op = "";
        solve(open,close,op,res);
        return res;
    }
    public void solve(int open,int close,String op,List<String> res){
        if(open==0&&close==0)res.add(op);
        
        if(open!=0){
            String op1 = op;
            op1+='(';
            solve(open-1,close,op1,res);
        }
        if(close>open){
            String op2 = op;
            op2+=')';
            solve(open,close-1,op2,res);
        }
    }
}