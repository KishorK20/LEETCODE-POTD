// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
// Note that after backspacing an empty text, the text will continue empty.
// Example 1:

// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

class Solution {
    public boolean backspaceCompare(String s, String t) {
        String finalS = buildString(s);
        String finalT = buildString(t);
        return finalS.equals(finalT); 
    }

    public static String buildString(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c != '#') {
                result.append(c);
            } else if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
        }

        return result.toString();
    }
}
