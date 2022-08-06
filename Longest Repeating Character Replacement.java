// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.
// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
 

// Constraints:

// 1 <= s.length <= 105
// s consists of only uppercase English letters.
// 0 <= k <= s.length
// Accepted
// 286,074
// Submissions
// 558,368

APPROACH : SLIDING WINDOW
// the approach is to always count the max frequent element in map while slinging window
//and the letters to change will be equal length of the window minus the max frequent element in map
//and if the letters to change is smaller than k the increse the length of the window by 1 and add length of window in maz and keep updating it
//and if the letters to change is greater than k the decrese the length of the window by 1

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        int most_frequent_character = 0;
        
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);//filling map with the character and its frequency
            most_frequent_character = Math.max(most_frequent_character, map.get(s.charAt(j)));//keep updating the max frequent character from checking the frequency of each character in the map
            int letter_to_change = (j - i + 1) - most_frequent_character;//calculate the number of letters to change by subtracting the max frequent character from the window size
            if(letter_to_change > k){//if the number of letters to change is greater than k then decrease the size of window
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);//decrement the frequency of the character in the map
                i++;//decrement the window size from the front
            }
            max = Math.max(max, j - i + 1);//update the max AND store the value of max sizze window possible
            j++;//increment the window size
        }
        return max;//return the max size of window
    }
}