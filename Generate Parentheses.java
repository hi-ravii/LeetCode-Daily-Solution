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
SOLUTION = 1: 

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int open =n;//no. of open brakets
        int close = n;//no. of close brakets
        String op = "";//output string
        solve(open,close,op,res);//calling the helper function
        return res;
    }
    public void solve(int open,int close,String op,List<String> res){
        //base case
        if(open==0&&close==0)res.add(op);//if no open and close brakets are left then add the string to the list and return 
        
        if(open!=0){//we can add open braket at any time in the string
            String op1 = op;//creating a new string to store the string with open braket added
            op1+='(';//adding open braket
            solve(open-1,close,op1,res);//calling the function with one less open braket
        }
        if(close>open){//we can add close braket only if there are more close brakets than open brakets otherwise it will be invalid string
            String op2 = op;//creating a new string to store the string with close braket added
            op2+=')';//adding close braket
            solve(open,close-1,op2,res);//calling the function with one less close braket
        }
    }
}

SOLUTION 2= https://leetcode.com/problems/generate-parentheses/discuss/1945298/Java-BackTracking-with-recursive-tree

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res,"",0,0,n);
        return res;
    }
    public void generate(List<String> res,String s,int open,int close,int max){
        if(s.length()==max*2){
            res.add(s);
            return;
        }
        if(open<max)generate(res,s+"(",open+1,close,max);
        if(close<open)generate(res,s+")",open,close+1,max);
    }
}