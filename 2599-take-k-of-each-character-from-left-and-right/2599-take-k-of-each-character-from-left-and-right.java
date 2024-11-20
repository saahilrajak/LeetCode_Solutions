class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;

        // Count total occurrences of 'a', 'b', 'c' in the string
        int[] totalCount = new int[3];
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }

        // If any character appears less than `k` times, it's impossible to satisfy the condition
        if (totalCount[0] < k || totalCount[1] < k || totalCount[2] < k) {
            return -1;
        }

        // Use a sliding window to find the longest valid subarray where we DON'T need `k` of each character
        int[] currentCount = new int[3];
        int n = s.length();
        int maxValidLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // Increment count for the current character
            currentCount[s.charAt(right) - 'a']++;

            // Shrink the window from the left if it exceeds the required condition
            while (currentCount[0] > totalCount[0] - k || 
                   currentCount[1] > totalCount[1] - k || 
                   currentCount[2] > totalCount[2] - k) {
                currentCount[s.charAt(left) - 'a']--;
                left++;
            }

            // Update the maximum valid length of the subarray
            maxValidLength = Math.max(maxValidLength, right - left + 1);
        }

        // The result is the total string length minus the longest valid subarray length
        return n - maxValidLength;
    }
}
