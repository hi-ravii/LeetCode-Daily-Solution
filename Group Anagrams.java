// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:

// Input: strs = [""]
// Output: [[""]]
// Example 3:

// Input: strs = ["a"]
// Output: [["a"]]
 

// Constraints:

// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lowercase English letters.
// Accepted
// 1,561,729
// Submissions
// 2,384,605
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String i :strs){
            char ch[] = i.toCharArray();//storing every string and converting into array
            Arrays.sort(ch);// sorting that string
            String s = new String(ch);//storing that string in another string
            if(!map.containsKey(s)){//checking if new string exist in map or not
                map.put(s,new ArrayList<>());//if not then add into map with key as the sorted string and value as the list of its anagram strings
            }
            map.get(s).add(i);//if s string is in map already then add it to the list in value 
        }
        for(List<String> l:map.values()){//add all the list in the values od map into another list which is to be return
            ans.add(l);
        }
        return ans;
    }
}