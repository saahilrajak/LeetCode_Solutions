public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Calculate the maximum possible bitwise OR of the entire array
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num; // Bitwise OR of all elements
        }

        // Step 2: Generate all subsets using bitmasking and count those with the maximum OR
        int count = 0;
        int n = nums.length;
        
        // There are 2^n subsets, we use bit masking to generate them
        for (int mask = 1; mask < (1 << n); mask++) {
            int subsetOr = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // If the ith bit is set in the mask, include nums[i] in the subset
                    subsetOr |= nums[i];
                }
            }
            if (subsetOr == maxOr) {
                count++; // Increment count if the OR equals the max OR
            }
        }

        return count;
    }
}