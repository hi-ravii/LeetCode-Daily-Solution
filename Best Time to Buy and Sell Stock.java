// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.
 

// Constraints:

// 1 <= prices.length <= 105
// 0 <= prices[i] <= 104
// Accepted
// 2,475,293
// Submissions
// 4,553,577

APPROCH 1 : BRUTE FORCE
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }
}
APPROCH 2 : MIN LEFT
//we will find the min price so far and then subtract it from the current price to get the profit
//hence return the max profit
class Solution {
    public int maxProfit(int[] prices) {
        int min =prices[0];
        int profit =0;
        int max=0;
        for(int i =0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            profit= prices[i]-min;
            max=Math.max(max,profit);
        }
        return max;
    }
}

APPROACH 3: SLIDING WINDOW
//we will use a window to find the max profit
//we will keep on updating the max profit and the min price

class Solution {
    public int maxProfit(int[] prices) {
        int i =0,j=1,max=0;
        while(j<prices.length){
            if(prices[i]<prices[j])
                max = Math.max(max,prices[j]-prices[i]);
            else{
                i=j;
               
            }
            j++;
        }
        return max;
    }
}