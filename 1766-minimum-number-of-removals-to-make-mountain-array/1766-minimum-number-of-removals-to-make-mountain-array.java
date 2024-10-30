public class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Step 1: Calculate LIS for each element
        int[] LIS = new int[n];
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        // Step 2: Calculate LDS for each element
        int[] LDS = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            LDS[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        // Step 3: Find the maximum length of a mountain array
        int longestMountain = 0;
        for (int i = 1; i < n - 1; i++) {
            if (LIS[i] > 1 && LDS[i] > 1) { // i has to be a peak of a mountain
                longestMountain = Math.max(longestMountain, LIS[i] + LDS[i] - 1);
            }
        }

        // Step 4: Calculate the minimum number of removals
        return n - longestMountain;
    }
}
