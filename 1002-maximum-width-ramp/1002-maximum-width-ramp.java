class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length; 
        Deque<Integer> stack = new ArrayDeque<>(); 
        for (int i = 0; i < n; ++i) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int maxWidth = 0; 
        for (int i = n - 1; i >= 0; --i) {
            // Try to extend the ramp from the end as far as possible
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                int startIndex = stack.pop(); // Retrieve the start index of a ramp
                maxWidth = Math.max(maxWidth, i - startIndex); // Update the maxWidth
            }
            // If the stack is empty, all possible start indices have been explored
            if (stack.isEmpty()) {
                break;
            }
        }
        return maxWidth; 
    }
}
