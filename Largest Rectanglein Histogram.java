// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

// Example 1:


// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.
// Example 2:


// Input: heights = [2,4]
// Output: 4
 

// Constraints:

// 1 <= heights.length <= 105
// 0 <= heights[i] <= 104
// Accepted
// 581,745
// Submissions
// 1,388,251
APPROACH 1 : BRUTE FORCE
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res =0;
        for(int i =0;i<n;i++){
            int min = heights[i];
            for(int j =i;j<n;j++){
                min = Math.min(min,heights[j]);
                res = Math.max(res,min*(j-i+1));
            }
        }
        return res;
    }
}
APPROACH 2: STACK
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res =0;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int h = heights[st.pop()];
                int w = st.isEmpty()?i:i-st.peek()-1;
                res = Math.max(res,h*w);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int h = heights[st.pop()];
            int w = st.isEmpty()?n:n-st.peek()-1;
            res = Math.max(res,h*w);
        }
        return res;
    }
}
APPROACH 3 : DIVIDE AND CONQUER
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        return helper(heights,0,n-1);
    }
    public int helper(int[] heights,int l,int r){
        if(l>r)return 0;
        if(l==r)return heights[l];
        int min = l;
        for(int i =l;i<=r;i++){
            if(heights[i]<heights[min])min = i;
        }
        return Math.max(heights[min]*(r-l+1),Math.max(helper(heights,l,min-1),helper(heights,min+1,r)));
    }
}
APPROACH 4 : DIVIDE AND CONQUER USING SEGMENT TREE
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])st.pop();
            left[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i =n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])st.pop();
            right[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int res =0;
        for(int i =0;i<n;i++){
            res = Math.max(res,heights[i]*(right[i]-left[i]-1));
        }
        return res;
    }
}
APPROACH 5 : USING 2 STACK
class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int left[]=new int[n];
        int right[]=new int[n];
        Stack<int[]> sl = new Stack<>();
        Stack<int[]> sr = new Stack<>();
        //NEXT LEFT SMALLER
        for(int i =0;i<n;i++){
            if(sl.isEmpty())left[i]=-1;
            if(!sl.isEmpty()&& sl.peek()[0]<h[i])left[i]=sl.peek()[1];
            if(!sl.isEmpty()&& sl.peek()[0]>=h[i]){
                while(!sl.isEmpty()&& sl.peek()[0]>=h[i])sl.pop();
                if(sl.isEmpty())left[i]=-1;
                else left[i]=sl.peek()[1];
            }
            sl.push(new int[]{h[i],i});
                
        }
        System.out.println(Arrays.toString(left));
        
        //NEXT RIGHT SMALLER
        for(int j =n-1;j>=0;j--){
            if(sr.isEmpty())right[j]=n;
            if(!sr.isEmpty()&& sr.peek()[0]<h[j])right[j]=sr.peek()[1];
            if(!sr.isEmpty()&& sr.peek()[0]>=h[j]){
                while(!sr.isEmpty()&& sr.peek()[0]>=h[j])sr.pop();
                if(sr.isEmpty())right[j]=n;
                else right[j]=sr.peek()[1];
            }
            sr.push(new int[]{h[j],j});
            
        }
        
        System.out.println(Arrays.toString(right));
        int width[]=new int[n];
        for(int i =0;i<n;i++){
            width[i]=right[i]-left[i]-1;
        }
        int max =Integer.MIN_VALUE;//max area
        for(int i =0;i<n;i++){
            max = Math.max(width[i]*h[i],max);
        }
        return max;
    }
}