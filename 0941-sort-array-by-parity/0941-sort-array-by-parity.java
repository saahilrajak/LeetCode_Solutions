class Solution {
    public int[] sortArrayByParity(int[] nums) {
       
        int left = 0;  // Pointer for even numbers
        int right = nums.length - 1;  // Pointer for odd numbers

        // Iterate through the array
        while (left < right) {
            // If the number at the left pointer is even, move the left pointer forward
            if (nums[left] % 2 == 0) {
                left++;
            }
            // If the number at the right pointer is odd, move the right pointer backward
            else if (nums[right] % 2 == 1) {
                right--;
            }
            // Swap the even and odd numbers when left is odd and right is even
            else {
                // Swap nums[left] and nums[right]
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
