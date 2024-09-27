class Solution {
    public String restoreString(String s, int[] indices) {
        // Creating a character array to hold the result
        char[] result = new char[s.length()];

        // Loop over the characters in the string 's'
        for (int i = 0; i < s.length(); i++) {
            // Place the character at the correct position in the result array
            result[indices[i]] = s.charAt(i);
        }
        // Convert the character array back to a string and return
        return new String(result);
    }
}
