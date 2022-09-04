// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

// Given a string s, return true if it is a palindrome, or false otherwise.

 

// Example 1:

// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
// Example 2:

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.
// Example 3:

// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.
 

// Constraints:

// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.
// Accepted
// 1,379,343
// Submissions
// 3,251,492
APPROACH 1

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s .charAt(i);
            if(Character.isLetterOrDigit(ch)){//checking if the character is alphanumeric , number or not
                sb.append(Character.toLowerCase(ch));//converting a charcter into lowercase and then adding in stringbuilder
            }
            
        }
        return isValid(sb.toString());//converting stringbuilder to string
    }
    public boolean isValid(String sb){
        int i =0,j=sb.length()-1;
        while(i<=j){
            if(sb.charAt(i)!=sb.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
APPROACH 2
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        
        while(start <= end){
            while(start <= end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start <= end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if(start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }
}