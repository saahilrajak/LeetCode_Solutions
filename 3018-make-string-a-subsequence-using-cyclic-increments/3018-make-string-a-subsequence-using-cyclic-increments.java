class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {

        // Time complexity = O(m+n)
        // Space complexity = O(1)
        
        int m = str1.length();
        int n = str2.length();

        int i = 0;
        int j = 0;

        while (i < m) {
            if (j == n) { 
                break;
            }
            if ((str1.charAt(i) == str2.charAt(j) || 
                 str1.charAt(i) + 1 == str2.charAt(j)) || 
                (str1.charAt(i) == 'z' && str2.charAt(j) == 'a')) {
                j++;
            }
            i++;
        }
        return j == n;
    }
}
