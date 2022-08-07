// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// A substring is a contiguous sequence of characters within the string.

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.

// Constraints:

// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.

// Follow up: Could you find an algorithm that runs in O(m + n) time?
// Accepted
// 820,287
// Submissions
// 2,071,356
// APPROACH : HASHMAP WITH SLIDING WINDOW
// // the approach is to use a hashmap to store the frequency of each character in t and then we mark count as the size of map
// //size of window will be the length of t
// //then we slide the window and check while j++ that chaaracter at j present in the map or not
// //if it is not present in the map then we decrement count
// //if it is present in the map then we increment count
// //when count is 0 then we return then we will check for min window possible ans store it in min 
// //if count is not 0 then we keep sliding the window
// //j++ pe map se frequency mein count mein decrement karne ke liye
// //i++ pe map se frequency mein count mein increment karne ke liye

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";
        int count = map.size();
        if (s.length() < t.length())
            return "";
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0)
                    count--;
            }
            while (count == 0) {
                if (min > j - i + 1) {
                    min = j - i + 1;
                    ans = s.substring(i, i + (j - i + 1));
                }
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                    if (map.get(s.charAt(i)) == 1)
                        count++;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}