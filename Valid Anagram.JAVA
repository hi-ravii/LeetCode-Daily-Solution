// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false
 

// Constraints:

// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.
 

// Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

// Accepted
// 1,628,116
// Submissions
// 2,602,847
APPROACH 1: SORTING
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        char[] ss=s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for(int i=0;i<s.length();i++){
            if(ss[i]!=tt[i])return false;
        }
        return true;
    }
}
APPROACH 2: HASHMAP
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();++i){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();++i ){
            char ch = t.charAt(i);
            if(!map.containsKey(ch))return false;
            if(map.containsKey(ch))
                map.put(ch,map.get(ch)-1);
            if(map.get(ch)==0)map.remove(ch);
        }
        return map.size()==0;
    }
}