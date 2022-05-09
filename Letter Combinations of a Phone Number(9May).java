// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].
APPROACH 1

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>(); //empty string, return empty arraylist
        List<String> l1 = new ArrayList<>();
        solve("", digits, l1);//calling the helper fuction
        return l1;
    }
    public void solve(String p, String up, List<String> l1){
        if(up.isEmpty()){
            l1.add(p);
            return;
        }
        // taking the number corresponding to the first char of string.
        int number = up.charAt(0) - '0';
        // initializing start and end as random char, here it is takesn as '0'
        char start = '0';
        char end = '0';
        // setting up start and end
        // normally until 7, it follows (char)(((number-1) * 3 - 3) + 'a'), but since 7 has 4 characters,
        // adding extra checks to set up start and end.
        if(number == 8 || number == 9){
            start = (char)(((number-1) * 3 - 2) + 'a');
        }else{
            start = (char)(((number-1) * 3 - 3) + 'a');
        }
        if(number == 7 || number == 9){
            end = (char)(start + 4);
        }else{
            end = (char)(start + 3);
        }
        // calling all possible calls by adding each character in current number to previous p.
        for(char i = start; i < end; i++){
            solve(p + i, up.substring(1), l1);
        }
    }
}
APPROACH 2

class Solution {
    public List<String> letterCombinations(String digits) {
        //If digits length is zero -> return empty array list
        if(digits.length()==0)    return new ArrayList<String>();
        //Create a dictionary to hold the mapping of phone number to digit.
        String[] dictionary = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        ArrayList<String> result = new ArrayList<>();
        //We will go through the digits one by one.
        for(int i=0; i<digits.length(); i++) {
            //We will use a helper function called combine.
            result = combine(dictionary[digits.charAt(i)-'0'].toCharArray(), result);
            //combine will take character array of all the letters corresponding to current digit and the result up till now.
        }
        
        return result;
    }
    
    public ArrayList<String> combine(char[] toBeAdded, ArrayList<String> result) {
        
        if (result.isEmpty()) {
            for(char tba: toBeAdded)
                result.add(String.valueOf(tba));
            return result;
        }
        
        ArrayList<String> result2 = new ArrayList<String>();
        ////We will run 2 loops - outer loop goes through each character in the char array like 'a', 'b', 'c'. and inner loop will go through already present strings in result like "ad", "ae", "af" etc.
        for(String res: result) {
            for(char tba: toBeAdded)
                //Will simply concatenate and store in new array list.
                result2.add(res+String.valueOf(tba));
        }
        //finally returing the array list
        return result2;
    }
}
APPROACH 3

class Solution {
    public List<String> letterCombinations(String digits) {
        var res = new ArrayList<String>();
        if(digits == null || digits.isEmpty()) {
            return res;
        }
        var map = Map.of('2', new Character[] { 'a', 'b', 'c' }, '3', new Character[] { 'd', 'e', 'f' }, '4',
                new Character[] { 'g', 'h', 'i' }, '5', new Character[] { 'j', 'k', 'l' }, '6',
                new Character[] { 'm', 'n', 'o' }, '7', new Character[] { 'p', 'q', 'r', 's' }, '8',
                new Character[] { 't', 'u', 'v' }, '9', new Character[] { 'w', 'x', 'y', 'z' });

        util(map, res, "", digits, 0);
        return res;
    }

    private void util(Map<Character, Character[]> map, List<String> res, String partial, String digits, int i) {
        if (partial.length() == digits.length()) {
            res.add(partial);
            return;
        }

        Character[] t = map.get(digits.charAt(i));
        for (int p = 0; p < t.length; p++) {
            partial += t[p];
            util(map, res, partial, digits, i + 1);
            partial = partial.substring(0, partial.length() - 1);
        }
    }
}