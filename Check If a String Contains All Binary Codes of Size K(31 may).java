// Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.

 

// Example 1:

// Input: s = "00110110", k = 2
// Output: true
// Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
// Example 2:

// Input: s = "0110", k = 1
// Output: true
// Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring. 
// Example 3:

// Input: s = "0110", k = 2
// Output: false
// Explanation: The binary code "00" is of length 2 and does not exist in the array.
 

// Constraints:

// 1 <= s.length <= 5 * 105
// s[i] is either '0' or '1'.
// 1 <= k <= 20
// Accepted
// 54,388
// Submissions
// 98,226

APPROACH1

class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k) return false;
        HashSet<String> set = new HashSet();
        for(int i = 0 ; i <= s.length() - k; i++)//length-k becauze to make sure we get the window of size k after ith index 
            set.add(s.substring(i, i+k));// it will automatically skip the duppliates
        return set.size() == (int)Math.pow(2,k);
    }
}
APPROACH 2= LEFT SHIFTING
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> got = new HashSet<String>();

        for (int i = k; i <= s.length(); i++) {
            String a = s.substring(i - k, i);
            if (!got.contains(a)) {
                got.add(a);
                need--;
                // return true when found all occurrences
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
