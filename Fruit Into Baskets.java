// You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

// You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

// You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
// Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
// Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
// Given the integer array fruits, return the maximum number of fruits you can pick.

 

// Example 1:

// Input: fruits = [1,2,1]
// Output: 3
// Explanation: We can pick from all 3 trees.
// Example 2:

// Input: fruits = [0,1,2,2]
// Output: 3
// Explanation: We can pick from trees [1,2,2].
// If we had started at the first tree, we would only pick from trees [0,1].
// Example 3:

// Input: fruits = [1,2,3,2,2]
// Output: 4
// Explanation: We can pick from trees [2,3,2,2].
// If we had started at the first tree, we would only pick from trees [1,2].
 

// Constraints:

// 1 <= fruits.length <= 105
// 0 <= fruits[i] < fruits.length
// Accepted
// 232,356
// Submissions
// 545,832

APPROACH 1: SLIDDING WINDOW

class Solution {
    public int totalFruit(int[] nums) {
        int i=0,j=0,max=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);//putting the element in the map and increasing the count
            if(map.size()>2){//if the size of the map is greater than 2 then we have to remove the element from the map and move the window forward till the size of the map is 2 
                map.put(nums[i],map.get(nums[i])-1);//decreasing the count of the element at i index 
                if(map.get(nums[i])==0){//if the count becomes 0 then we remove the element from the map
                    map.remove(nums[i]);
                }
                i++;//moving the window forward
            }
            max = Math.max(max,j-i+1);//calculating the max size of the window
            j++;//moving the window forward
        }
        return max;
    }
}