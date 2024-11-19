import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        long sum = 0;
        HashSet<Integer> set = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Slide the window and remove duplicates
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Add the current element to the window
            set.add(nums[right]);
            sum += nums[right];

            // If the window size exceeds `k`, shrink it
            if (right - left + 1 > k) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Check if the window size is exactly `k` and update result
            if (right - left + 1 == k) {
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}
