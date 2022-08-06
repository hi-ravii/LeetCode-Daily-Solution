// Given a string s, find the length of the longest substring without repeating characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
// Accepted
// 3,652,119
// Submissions
// 10,877,154
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,max=0;
        Map<Character,Integer> map = new HashMap<>();

        while(j<s.length()){//while loop till the end of the string
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);//filling map with the character and its frequency
            if(map.size()==j-i+1){//if the map size is equal to the window size
                max=Math.max(max,j-i+1);//update the max AND store the value of max sizze window possible
                j++;//increment the window size
                
            }
            else if(map.size()<j-i+1){//if the map size is less than the window size
                while(map.size()<j-i+1){//while the map size is less than the window size
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);//decrement the frequency of the character in the map
                    if(map.get(s.charAt(i))==0)//if the frequency of the character is 0
                        map.remove(s.charAt(i));//remove the character from the map
                    i++;//decrement the window size from the front
                }
                j++;//increment the window size
            }
            
        }
        return max;
    }
}