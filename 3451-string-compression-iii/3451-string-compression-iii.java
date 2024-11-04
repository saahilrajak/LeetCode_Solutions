class Solution {
    public String compressedString(String word) {
         StringBuilder comp = new StringBuilder();
        int i = 0;
        int n = word.length();

        while (i < n) {
            char currentChar = word.charAt(i);
            int count = 0;
            while (i < n && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }
            comp.append(count).append(currentChar);
        }
        return comp.toString();
    }
}