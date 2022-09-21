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
APPROACH : Stack 
// 1-LOOP ULTA SE TRAVERSE KARKE PUSH KARNA HAI STACK ME HRR VALUE KO USKI INDEX K SATH (temperatures[i],i)[0,1]
// 2-agr stack empty h toh res[i] me zero daal do
// 3- agr stack.peek > temp[i] toh stack me push kro aur res[i]=st.peek()[1]-i
// 4-agr stack.peek< temp[i]toh stack.pop() krte raho jab tak badi value na mil jaye phir step 3 follow krna aur agr st empty ho jaye pop krte krte toh res[i] me zero daal do
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //greater to right ques of stack
        //stack[0]=value  stack[1]index
        int n =temperatures.length;
        Stack<int[]>st = new Stack<>();
        int res []=new int[n];
        for(int i=n-1;i>=0;i--){//greater to right to left
            if(st.isEmpty())res[i]=0;//1st condition
            //for last element if stack is empty means no grater element is present then take 0 in res[i]
            else if(!st.isEmpty()&&st.peek()[0]>temperatures[i])res[i]=st.peek()[1]-i;//2nd condition
            //if a grater elemnt than current element is present in stack then take the index of that element and subtract it from current index
            else if(!st.isEmpty()&&st.peek()[0]<=temperatures[i]){//3rd condition
                //if a grater element is not present in stack then pop the element from stack and check for next element in stack
                while(!st.isEmpty()&&st.peek()[0]<=temperatures[i])st.pop();//repeated 3 rd condition
                if(st.isEmpty())res[i]=0;//repeated 1 st condition
                //after poping if stack become empty then just take 0 in res[i]
                else res[i]=st.peek()[1]-i;//repeated 2nd condition
                //if stack is not empty then take the index of that element and subtract it from current index
            }
            st.push(new int[]{temperatures[i],i});//pushing
        }
        return res;
    }
}
APPRACH 2: BRUTE FORCE
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n =temperatures.length;
        int res []=new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(temperatures[j]>temperatures[i]){
                    res[i]=j-i;
                    break;
                }
            }
        }
        return res;
    }
}
APPROACH 3 : SLIDING WINDOW
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int res[]= new int[n];
        int i=0,j=1;
        while(i<n-1){//moving i till second last element of array 
            if(temp[i]>=temp[j]){// if i is greater than j then move j forward means move j till we find the greater element than i
                j++;
                if(j>n-1){//if j moves till the last element of array then move i forward that means no greater element is found then reset j to i+1
                    //reseting the window by moving i forward by 1 and j to i+1
                    i++;//moving i forward
                    j=i+1;//resetting j to i+1
                }
            }
            else{//if greater element is found then store the difference of j and i in res[i] and move window forward by 1 
                res[i]=j-i;//storing the difference of j and i in res[i]
                i++;//moving i forward
                j=i+1;//resetting j to i+1
            }
        }
        return res;
    }
}