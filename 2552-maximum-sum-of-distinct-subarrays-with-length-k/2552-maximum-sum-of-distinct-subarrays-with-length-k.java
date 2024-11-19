import java.util.HashSet;
//Tc: O(n)
//sc: O(k)

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        long sum = 0;
        HashSet<Integer> set = new HashSet<>();
        int left = 0; // Sliding window's left pointer
        
        for (int right = 0; right < nums.length; right++) {
            // Shrink the window if we encounter a duplicate or exceed size `k`
            while (set.contains(nums[right]) || set.size() >= k) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            
            // Add current element to the set and update the sum
            set.add(nums[right]);
            sum += nums[right];
            
            // Check if the window size is exactly `k` and update the result
            if (set.size() == k) {
                result = Math.max(result, sum);
            }
        }
        
        return result;
    }
}
