//T.C : O(N)
//S.C : O(N)
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        
        // Calculate cumulative sum
        long[] cumSum = new long[n];
        cumSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            cumSum[i] = cumSum[i - 1] + nums[i];
        }
        
        int split = 0;
        
        // Iterate and check conditions
        for (int i = 0; i < n - 1; i++) {
            long leftSum = cumSum[i];
            long rightSum = cumSum[n - 1] - cumSum[i];
            
            if (leftSum >= rightSum) {
                split++;
            }
        }
        
        return split;
    }
}
