class Solution {
    public int longestMonotonicSubarray(int[] nums) {
      int n = nums.length;
        if (n == 0) return 0;

        int incLen = 1, decLen = 1, maxLen = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
                decLen = 1; // Reset decreasing length
            } else if (nums[i] < nums[i - 1]) {
                decLen++;
                incLen = 1; // Reset increasing length
            } else {
                incLen = 1;
                decLen = 1; // Reset both when elements are equal
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }

        return maxLen;
    }
}
