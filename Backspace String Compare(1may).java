// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

// Note that after backspacing an empty text, the text will continue empty.

 

// Example 1:

// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".
// Example 2:

// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".
// Example 3:

// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".
 

// Constraints:

// 1 <= s.length, t.length <= 200
// s and t only contain lowercase letters and '#' characters.
class Solution {
    public boolean backspaceCompare(String S, String T) {
	assert S != null && T != null;

    // Iterate to find next pair each time
    int i = S.length() - 1;
    int j = T.length() - 1;
    while (i >= 0 || j >= 0) {
        // Skip deleted elements in both strings, until next effective character
        i = skipBackspaceCharacters(S, i);
        j = skipBackspaceCharacters(T, j);

        // Compare character pair
        if (i >= 0 && j >= 0) {
            if (S.charAt(i) != T.charAt(j)) {
                return false;
            }

            i--;
            j--;
        } else if ((i >= 0) != (j >= 0)) {    // Unmatched indices
            return false;
        }
    }

    return true;
}

private int skipBackspaceCharacters(String s, int index) {
    // Simulate stack in & out sequence with counter
    while (index >= 0 && s.charAt(index) == '#') {
        int count = 1;
        index--;

        while (index >= 0 && count > 0) {
            if (s.charAt(index) == '#') {
                count++;
            } else {
                count--;
            }
            index--;
        }
    }

    return index;
}
    
}