// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

 

// Example 1:

// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
 

// Constraints:

// 1 <= s1.length, s2.length <= 104
// s1 and s2 consist of lowercase English letters.
// Accepted
// 446,604
// Submissions
// 1,011,892
APPROACH : HASHMAP WITH SLIDING WINDOW
// the approach is to use a hashmap to store the frequency of each character in S1 and then we mark count as the size of map 
//size of window will be the length of s1
//then we slide the window and check while j++ that chaaracter at j present in the map or not
//if it is not present in the map then we decrement count
//if it is present in the map then we increment count
//when count is 0 then we return true
//if count is not 0 then we keep sliding the window
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i<s1.length();i++){//filling the map with the frequency of each character in s1
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        int i=0,j=0;
        int count=map.size();//count is the size of the map
        int k =s1.length();//k is the size of the window
        while(j<s2.length()){
            if(map.containsKey(s2.charAt(j))){//if the character at j is present in the map then decrement the count
                map.put(s2.charAt(j),map.get(s2.charAt(j))-1);//decrement the frequnecy of the character in the map
                if(map.get(s2.charAt(j))==0){//if the frequency of the character is 0 then decrement the count
                    count--;
                }
            }
            if(j-i+1<k)j++;//if the window size is less than k then increment the window size
            else if(j-i+1==k){//if the window size is equal to k then check if the count is 0 or not
                if(count==0)return true;//if the count is 0 then return true
                 if(map.containsKey(s2.charAt(i))){
                    map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0)+1);//increment the frequency of the character in the map
                    if(map.get(s2.charAt(i))==1){//if the frequency of the character is greater than 0 then increment the count
                        count++;
                    }
                 }
            i++;//increment the window size from the front
            j++;//increment the window size from the back
            }
               
        }
        return false;//if the count is not 0 then return false
    }
}