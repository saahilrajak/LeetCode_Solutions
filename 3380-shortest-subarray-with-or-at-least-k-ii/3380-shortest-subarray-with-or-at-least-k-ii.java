class Solution {
    void updateFreq(int[] bitFreq, int number, int val) {
        for (int i = 0; i < 32; ++i) {
            if ((number & (1 << i)) != 0) {
                bitFreq[i] += val;
            }
        }
    }

    int getNumber(int[] bitFreq) {
        int number = 0;
        long pow = 1;
        for (int i = 0; i < 32; ++i) {
            if (bitFreq[i] > 0) {
                number += pow;
            }
            pow *= 2;
        }
        return number;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        if (k == 0) {
            return 1;
        }

        int n = nums.length;
        int shortest = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int currOR = 0;
        int[] bitFreq = new int[32];

        while (right < n) {
            updateFreq(bitFreq, nums[right], 1);
            currOR |= nums[right];

            // Resize window
            while (left <= right && currOR >= k) {
                shortest = Math.min(shortest, right - left + 1);
                updateFreq(bitFreq, nums[left], -1);
                currOR = getNumber(bitFreq);
                left++;
            }
            right++;
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}