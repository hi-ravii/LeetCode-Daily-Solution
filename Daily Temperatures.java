// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

// Example 1:

// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]
// Example 2:

// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]
// Example 3:

// Input: temperatures = [30,60,90]
// Output: [1,1,0]
 

// Constraints:

// 1 <= temperatures.length <= 105
// 30 <= temperatures[i] <= 100
// Accepted
// 421,359
// Submissions
// 624,370
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //greater to right ques of stack
        //stack[0]=value  stack[1]index
        int n =temperatures.length;
        Stack<int[]>st = new Stack<>();
        int res []=new int[n];
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty())res[i]=0;//1st condition
            else if(!st.isEmpty()&&st.peek()[0]>temperatures[i])res[i]=st.peek()[1]-i;//2nd condition
            else if(!st.isEmpty()&&st.peek()[0]<=temperatures[i]){//3rd condition
                while(!st.isEmpty()&&st.peek()[0]<=temperatures[i])st.pop();//repeated 3 rd condition
                if(st.isEmpty())res[i]=0;//repeated 1 st condition
                else res[i]=st.peek()[1]-i;//repeated 2nd condition
            }
            st.push(new int[]{temperatures[i],i});//pushing
        }
        return res;
    }
}